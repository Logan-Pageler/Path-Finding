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

  const [ snapshot, setSnapshot ] = useState([10, 20]);

  function play() {
    fetch(`http://localhost:8080/${algorithm}`)
    .then((res) => {
      return res.json();
    }).then((snapshots) => {
      snapshots.forEach((snapshot) => {
        var i = 0;
        var newSS = [];
        snapshot.forEach((val) => {
          var o = {index:i++, value:val};
          newSS.push(o);
          console.log("obj:", o);
        });
        snapshot = newSS;
        console.log(`updated snapshot: ${snapshot}`);
        setSnapshot(snapshot);
      });
    });
  }
  return (
    <div className="SortDisplay">
      <h2>{algorithm}</h2>
      <BarChart width={500} height={250} data={snapshot}>
        <XAxis dataKey="index" />
        <YAxis />
        <Bar dataKey="value" fill="#61dafb" />
      </BarChart>
      <Button onClick={play} />
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

export default App;
