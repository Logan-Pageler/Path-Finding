

function Home() {
    return (
        <div className="App">
      <header className="App-header">
        <SortDisplay algorithm={"quicksort"} />
        <SortDisplay algorithm={"bubblesort"} />
        <SortDisplay algorithm={"selectionsort"} />
        <SortDisplay algorithm={"insertionsort"} />
        <SortDisplay algorithm={"heapsort"} />
        <SortDisplay algorithm={"shellsort"} />
      </header>
    </div>
    );
}

export default Home;