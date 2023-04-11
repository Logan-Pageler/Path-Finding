/**
 * Home page component.
 * 
 * @author Logan Pageler
 */
import "./Home.css"

function Home() {
    return (
        <>
            <h class="Sort-Wiki-Title">
                SORT-WIKI
            </h>
            <p className="description">
            &emsp;&emsp;Sort-Wiki is accessible algorithm learning tool, that can be used to understand and visualize a multitude of sorting algorithms.
            <br />
            <br />

            &emsp;&emsp;Sort-Wiki is a multilayer project comprised of three parts. The main part is under the sort-wiki folder. This is a java project
            which contains the actual implementations of our sorting algorithms.The second part is a custom made http server library called Compass, so that our java code can be accessed anywhere
            in the world. The third part is the frontend website. We used the react.js framework with MUI to implement our frontend, so that it
            can look as clean and professional as possible. This implementation allows Sort-Wiki can be accessed anywhere in the world, with the only
            necessity being an internet connection.
            </p>
        </>

    );
}

export default Home;