import SortDisplay from "../../components/SortDisplay";

function HeapSort() {
    return (
        <>
        <SortDisplay algorithm={"heapsort"} displayName="Heap Sort" />
        <p className="description">
        &emsp;&emsp;Heap Sort relies on creating a max heap array and swapping the max 
        element to create a sorted array starting from the end of the array 
        to the beginning. The algorithm first starts off by sorting the array 
        into max heap order. It then swaps the first element with the last 
        making the last index in sorted order. It then re-heapifies the array 
        starting from the first element to the last unsorted element. It does 
        this by bubbling down the updated first element into the correct max 
        heap order with respect to the unsorted portion of the array. This 
        process then repeats until the array has been heapified the length of 
        the array times. Heap sort is not stable, meaning the order of the array 
        is not preserved. Heap Sort is input sensitive, meaning the array values 
        will affect the runtime/work the algorithm does. Although heap sort is 
        not the most efficient with more complex data the best-case runtime is O(N), 
        the worst-case along with the average runtime is O(NlogN), and the space 
        use is O(1).
        </p>
        <p className="description">
            <a style={{color: "#61dafb"}}
            href="https://www.geeksforgeeks.org/array-representation-of-binary-heap/ ">
                What is a max heap array?
            </a>
        </p>
        </>
    );
}

export default HeapSort;