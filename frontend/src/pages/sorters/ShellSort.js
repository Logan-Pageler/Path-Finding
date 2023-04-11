import SortDisplay from "../../components/SortDisplay";

function ShellSort() {
    return (
        <>
            <SortDisplay algorithm={"shellsort"} displayName="Shell Sort" />
            <p className="description">
            &emsp;&emsp;Shell Sort relies on creating a partially sorted array using 
            spaced-out insertion sort, and then using insertion sort again 
            to sort the partially sorted array. This algorithm uses an h-value 
            to exchange values from a far distance. The initial h-value is set 
            to the number that is greater than or equal to the length of the 
            array divided by three. The algorithm performs insertion sort on every 
            other h-indexed value starting at index 0. The h-value then updates to 
            3 * (the previous h value) + 1 and repeats the insertion sort. The h value 
            updates until it reaches one, once h equals one insertion sort is performed 
            on the array. Shell sort requires small amounts of code, good for moderately 
            large arrays, and space usage is O(1). Shell sort is not stable, meaning the 
            order of the array is not preserved. It is sensitive to input, meaning the 
            array values will affect the runtime of the algorithm. Its performance 
            depends on the number of increments of h and the size of the common divisor. 
            The best-case runtime is O(NlogN) which occurs when the array is already sorted. 
            The worst-case along with the average-case runtime is O(N^(3/2)). 
            </p>
        </>
    );
}

export default ShellSort;