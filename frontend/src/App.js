import './App.css';
import Home from './pages/Home';
import Navbar from './navbar/Navbar';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import BubbleSort from './pages/sorters/BubbleSort';
import QuickSort from './pages/sorters/QuickSort';

function App() {
  return (
    <>
      <BrowserRouter>
        <Navbar/>
        <div className="App">
            <header className="App-header">
            <Routes>
              <Route path="/">
                <Route index element={<Home />} />
                <Route path="bubblesort" element={<BubbleSort />} />
                <Route path="quicksort" element={<QuickSort />} />
              </Route>
            </Routes>
          </header>
        </div>
      </BrowserRouter>
    </>
  );
}


export default App;
