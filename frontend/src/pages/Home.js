import SortDisplay from "../components/SortDisplay";

function Home() {
    return (
        <>
            <SortDisplay algorithm={"quicksort"} />
            <SortDisplay algorithm={"bubblesort"} />
            <SortDisplay algorithm={"selectionsort"} />
            <SortDisplay algorithm={"insertionsort"} />
            <SortDisplay algorithm={"heapsort"} />
            <SortDisplay algorithm={"shellsort"} />
        </>

    );
}

export default Home;