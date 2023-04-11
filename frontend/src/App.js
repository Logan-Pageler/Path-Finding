import './App.css';
import Home from './pages/Home';
import Navbar from './navbar/Navbar';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import BubbleSort from './pages/sorters/BubbleSort';
import QuickSort from './pages/sorters/QuickSort';
import Stack from './pages/structures/Stack';

function App() {
  return (
    <>
      <BrowserRouter>
        
        <div className="App">
        <Navbar/>
            <header className="App-header">
            <Routes>
              <Route path="/">
                <Route index element={<Home />} />
                <Route path="bubblesort" element={<BubbleSort />} />
                <Route path="quicksort" element={<QuickSort />} />
                <Route path="selectionsort" element={<BubbleSort />} />
                <Route path="insertionsort" element={<QuickSort />} />
                <Route path="heapsort" element={<BubbleSort />} />
                <Route path="shellsort" element={<QuickSort />} />
                <Route path="stack" element={<Stack />} />
              </Route>
            </Routes>
          </header>
        </div>
      </BrowserRouter>
    </>
  );
}


export default App;
