import { BarChart, YAxis, XAxis, Bar } from 'recharts';
import { useState } from 'react';

function SortDisplay({ algorithm }) {

  var idx = 0;

  const [ snapshot, setSnapshot ] = useState([{index: 0, value: 0}]);
  const [ list, setList ] = useState([[{index: 0, value: 0}]]);
  const isRunning = useRef(false);
  const isSorted = useRef(false);
  const intervalId = useRef(null);

  function update() {
    if (idx >= list.length) {
      clearInterval(intervalId.current);
      setSnapshot(list[idx-1]);
      isRunning.current = false;
      isSorted.current = true;
      return;
    }
    setSnapshot(list[idx++]);
  }

  function randomize() {
    if (isRunning.current)
      return;
    fetch(`http://localhost:8080/${algorithm}`)
    .then((res) => {
      return res.json();
    })
    .then((snapshots) => {
      setList(convertSnapshots(snapshots));
      isSorted.current = false;
    });
  }

  function sort() {
    if (!isRunning.current && !isSorted.current) {
      intervalId.current = setInterval(update, 75);
      isRunning.current = true;
    }
  }

  function convertSnapshots(snapshots) {
    var retval = [];
    snapshots.forEach((snapshot) => {
      var i = 0;
      var newSS = [];
      snapshot.forEach((val) => {
        let o = {index:i++, value:val};
        newSS.push(o);
      });
      retval.push(newSS);
    });
    return retval;
  }

  useEffect(() => {
    randomize();
    // the below comment is needed, it ignores an annoying warning
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);  // <- empty array means 'run once on first render'

  useEffect(() => {
    setSnapshot(list[0]);
  }, [list]); 

  return (
    <div className="SortDisplay">
      <h2>{algorithm}</h2>
      <BarChart width={500} height={250} data={snapshot}>
        <XAxis dataKey="index" tick={false} />
        <YAxis hide={true} />
        <Bar dataKey="value" fill="#61dafb" />
      </BarChart>
      <span>
        <Button onClick={sort} value="Sort" />
        <Button onClick={randomize} value="Randomize" />
      </span>
    </div>
  );
}

function Button({ onClick, value }) {
  return (
    <button className="Button" onClick={onClick}>
      {value}
    </button>
  );
}

export default SortDisplay;