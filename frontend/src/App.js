/**
 * Main App Page. Includes Router and Page format
 * 
 * @author Logan Pageler
 * @since 4/10/2023
 */
import './App.css';
import Home from './pages/Home';
import Navbar from './navbar/Navbar';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import BubbleSort from './pages/sorters/BubbleSort';
import QuickSort from './pages/sorters/QuickSort';
import Stack from './pages/structures/Stack';
import ShellSort from './pages/sorters/ShellSort';
import HeapSort from './pages/sorters/HeapSort';
import InsertionSort from './pages/sorters/InsertionSort';
import SelectionSort from './pages/sorters/SelectionSort';

function App() {
  return (
    <>
      <BrowserRouter>
        <div className="App">
<<<<<<< HEAD
        <Navbar/>
          <header className="App-header">
=======
          <Navbar/>
            <header className="App-header">
>>>>>>> f4a14953ffcbad2c658d3fdeb8d0016838ce5690
            <Routes>
              <Route path="/">
                <Route index element={<Home />} />
                <Route path="bubblesort" element={<BubbleSort />} />
                <Route path="quicksort" element={<QuickSort />} />
                <Route path="selectionsort" element={<SelectionSort />} />
                <Route path="insertionsort" element={<InsertionSort />} />
                <Route path="heapsort" element={<HeapSort />} />
                <Route path="shellsort" element={<ShellSort />} />
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
