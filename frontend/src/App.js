import './App.css';
<<<<<<< HEAD

async function test() {
  const response = await fetch("http://localhost:8080/quicksort");
  const jsonData = await response.json();
  console.log(jsonData);
  
}
=======
import { useState } from 'react';
import { BarChart, YAxis, XAxis, Bar } from 'recharts';
>>>>>>> 2781102ea35d057a593ab5549a0a51d758425b63

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <SortDisplay algorithm={"quicksort"} />
        <SortDisplay algorithm={"bubblesort"} />
      </header>
    </div>
  );
}

function SortDisplay({ algorithm }) {

  var idx = 0;
  var intervalId;
  const [ snapshot, setSnapshot ] = useState([{index: 0, value: 0}]);
  var list; var length;

  function update() {
    if (idx >= length) {
      clearInterval(intervalId);
      setSnapshot(list[--idx]);
      return;
    }
    setSnapshot(list[idx++]);
  }

  function sort() {
    fetch(`http://localhost:8080/${algorithm}`)
    .then((res) => {
      return res.json();
    })
    .then((snapshots) => {
      list = convertSnapshots(snapshots);
      length = list.length;
      intervalId = setInterval(update, 75);
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
