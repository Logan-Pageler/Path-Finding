import './App.css';
import { useState } from 'react';
import { BarChart, YAxis, XAxis, Bar } from 'recharts';

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
  const [ snapshot, setSnapshot ] = useState([]);
  var list;

  function load() {
    fetch(`http://localhost:8080/${algorithm}`)
    .then((res) => {
      return res.json();
    })
    .then((snapshots) => {
      var list = convertSnapshots(snapshots);
      setSnapshot(list[0]);
      return list;
    });
  }

  function update() {
    if (list !== undefined && idx > list.length) {
      clearInterval(intervalId);
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
      console.log("list:", list);
      setSnapshot(list[0]);
      intervalId = setInterval(update, 100);
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
        <XAxis dataKey="index" />
        <YAxis />
        <Bar dataKey="value" fill="#61dafb" />
      </BarChart>
      <Button onClick={sort} />
    </div>
  );
}

function Button({ onClick }) {
  return (
      <button className="Button" onClick={(onClick)}>
        Sort (for now just prints to console)
      </button>
  );
}

function getRandom() {
  const length = 20;
  var arr = [];
  for (var i = 0; i < length; i++)
    arr.push(Math.random() * 20 * length);
  return arr;
}

export default App;
