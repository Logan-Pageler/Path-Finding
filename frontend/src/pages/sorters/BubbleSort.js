/**
 * Bubble Sort Page Component
 * 
 * @author Michelle Ramos, Evan Ohme, and Logan Pageler
 */
import SortDisplay from "../../components/SortDisplay";

function BubbleSort() {
    return (
        <>
        <SortDisplay algorithm={"bubblesort"} displayName="Bubble Sort" />
        <p className="description">
        &emsp;&emsp;Bubble Sort relies on swapping two consecutive elements
        depending on their values. It starts at the beginning of the array,
        checking if the current value is greater than the next. If so, they swap.
        The algorithm then moves on to the next two consecutive elements and checks
        if they need to swap. This process continues until it has worked its way to
        the end of the array. Once it reaches the end of the array, the algorithm restarts,
        this entails starting at the beginning of the array and checking if the current
        position is greater than the next position, if so they swap. This algorithm
        ends once it goes through the entire array without making any swaps. This algorithm
        is stable, meaning the order of the array is preserved and is sensitive to input.
        This is one of the slowest sorting algorithms with a best-case runtime of O(N),
        a worst-case of O(N^2), and an average O(N^2). It's space usage is O(1).
        Bubble Sort is easy to implement.
        </p>
        </>
    );
}

export default BubbleSort;