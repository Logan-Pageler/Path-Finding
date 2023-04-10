import './App.css';
import { useState } from 'react';
import { BarChart, YAxis, XAxis, Bar } from 'recharts';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <SortDisplay algorithm={"quicksort"} />
        <SortDisplay algorithm={"bubblesort"} />
        <SortDisplay algorithm={"selectionsort"} />
        <SortDisplay algorithm={"insertionsort"} />
        <SortDisplay algorithm={"heapsort"} />
        <SortDisplay algorithm={"shellsort"} />
      </header>
    </div>
  );
}

function SortDisplay({ algorithm }) {

  var idx = 0;
  var intervalId = null;
  const [ snapshot, setSnapshot ] = useState([{index: 0, value: 0}]);
  const [ isRunning, setIsRunning ] = useState(false);
  var list; var length;

  function update() {
    if (idx >= length) {
      clearInterval(intervalId);
      setSnapshot(list[--idx]);
      setIsRunning(false);
      return;
    }
    setSnapshot(list[idx++]);
  }

  function sort() {
    if (isRunning)
      return;
    fetch(`http://localhost:8080/${algorithm}`)
    .then((res) => {
      return res.json();
    })
    .then((snapshots) => {
      list = convertSnapshots(snapshots);
      length = list.length;
      if (!isRunning) {
        intervalId = setInterval(update, 75);
        setIsRunning(true);
      }
    });
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

  return (
    <div className="SortDisplay">
      <h2>{algorithm}</h2>
      <BarChart width={500} height={250} data={snapshot}>
        <XAxis dataKey="index" tick={false} />
        <YAxis hide={true} />
        <Bar dataKey="value" fill="#61dafb" />
      </BarChart>
      <Button onClick={sort} value="Sort" />
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

export default App;
