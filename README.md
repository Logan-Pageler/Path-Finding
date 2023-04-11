# Sort-Wiki
Sort-Wiki is accessible algorithm learning tool, that can be used to understand and visualize a multitude of sorting algorithms.

### Implementation:
Sort-Wiki is a multilayer project comprised of three parts. The main part is under the sort-wiki folder. This is a java project
which contains the actual implementations of our sorting algorithms. It also contains a tester, (Test.java) to verify that our 
algorithms work. The second part is a custom made http server library called Compass, so that our java code can be accessed anywhere
in the world. The third part is the frontend website. We used the react.js framework with MUI to implement our frontend, so that it
can look as clean and professional as possible.

### Usage:
Sort-Wiki is view able at http://sort.wiki. There you can access all of the sorting algorithms and in depth descriptions of them.
There is also a implementation of a stack to compute expressions. Sort-Wiki can be accessed anywhere in the world, with the only
necessity being an internet connection.

### Development

#### Backend:

Using whatever IDE you are most comfortable with, run Main.java in sort-wiki/src

#### Frontend:

Running the front end requires npm!

Installation:

    make install-frontend

Running:

    make run-frontend


Alternatively if you are unable to run the make file, see frontend/README.md

#### Testing:

To test the java code run Test.java in sort-wiki/src

