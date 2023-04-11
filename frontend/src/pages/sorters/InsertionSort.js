import SortDisplay from "../../components/SortDisplay";

function InsertionSort() {
    return (
        <>
            <SortDisplay algorithm={"insertionsort"} displayName="Insertion Sort" />
            <p className="description">
            &emsp;&emsp;Insertion Sort relies on inserting elements into a sorted array, 
            growing the sorted array size. The algorithm starts by sorting the 
            first two elements, then when moving on to the next element it will 
            be swapped down until it is either the first element in the array or 
            between an element that is less than or equal to the element and a 
            greater than element. This assures when the element is moved into the 
            correct position the left side of the original index is in sorted order. 
            Insertion sort is simple to implement and is efficient in smaller arrays 
            and partially sorted arrays. This algorithm is sensitive to input and is 
            not stable, meaning the relative order of the array is not preserved. 
            The best-case runtime is O(N), and the worst-case along with the average 
            case is O(N^2). 
            </p>
        </>
    );
}

export default InsertionSort;