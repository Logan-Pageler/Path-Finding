/**
 * Selection Sort Page Component
 * 
 * @author Michelle Ramos, Evan Ohme, and Logan Pageler
 */
import SortDisplay from "../../components/SortDisplay";

function SelectionSort() {
    return (
        <>
            <SortDisplay algorithm={"selectionsort"} displayName="Selection Sort" />
            <p className="description">
            &emsp;&emsp;Selection Sort relies on finding the minimum value 
            and swapping it with the next unordered element. The algorithm 
            starts by finding the minimum value and swapping it with index 0, 
            then finding the next minimum value and swapping it with index 1, 
            creating indexes 0-1 to be in order. This process of finding and 
            swapping with the last unordered index continues until the last “min” 
            value is in the array's final position. This algorithm is not stable, 
            meaning the order of the array is not preserved. Selection sort does not 
            work well with larger arrays. The best-case, worst-case, and average 
            runtime is O(N^2). The benefits are minimal data movement and 
            input insensitivity. 
            </p>
        </>
    );
}

export default SelectionSort;