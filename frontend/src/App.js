import './App.css';

async function test() {
  const response = await fetch("http://localhost:8080/");
  //const jsonData = await response.json();
  //console.log(jsonData);
  
}

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <button onClick={test}>Click me!</button>
      </header>
      <p>hello</p>
    </div>
  );
}

export default App;
