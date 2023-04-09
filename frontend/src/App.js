import './App.css';
//import { useState } from 'react';

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
  function play() {
    fetch(`http://localhost:8080/${algorithm}`)
    .then((res) => {
      return res.json();
    }).then((snapshots) => {
      var i = 0;
      snapshots.forEach((snapshot) => {
        console.log(`${i++}: ${snapshot}`);
      });
    });
  }
  return (
    <div className="SortDisplay">
      <h2>{algorithm}</h2>
      <Button onClick={play} />
    </div>
  );
}

function Button({ onClick }) {
  return (
      <button className="Button" onClick={(onClick)}>
        Play (for now just prints to console)
      </button>
  );
}

export default App;
