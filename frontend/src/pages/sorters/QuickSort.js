/**
 * Quick Sort Page Component
 * 
 * @author Michelle Ramos, Evan Ohme, and Logan Pageler
 */
import SortDisplay from "../../components/SortDisplay";

function QuickSort() {
    return (
        <>
            <SortDisplay algorithm={"quicksort"} displayName="Quick Sort" />
            <p className="description">
            &emsp;&emsp;Quick Sort relies on a technique called divide and conquer. 
            It picks an element as a pivot and partitions the array around 
            the picked pivot. The algorithm picks a random pivot, then partitions 
            around it. Given an array and an element x of an array as the pivot, 
            put x at its correct position in a sorted array and put all elements 
            that are smaller than x smaller elements before x, and put all elements 
            greater than x after it. While going through the array, if a smaller 
            element is found, it will swap the current element. Otherwise, we ignore 
            the current element. Quick Sort is efficient on larger data sets, its 
            space use is O(logN) on the stack because of the recursive nature of the 
            algorithm. Quick Sort is not stable, meaning the relative order of the 
            array elements are not preserved. It as well is slightly sensitive to input, 
            meaning the array values will affect the runtime/work the algorithm does. 
            The best-case runtime is O(NlogN), this would be in the case where the pivot 
            is always the median. The worst case would be O(N), this would be in the 
            case that the pivot is always the min or max element. This averages out 
            to O(NlogN). 
            </p>
        </>
    );
}

export default QuickSort;