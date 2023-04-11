# sort.wiki

This is the main part of our final 345 project. It contains our implementations for
the algorithms we learned in class. It is broken into two main parts. 

## Test.java

This is our tester to show that our implementations work. 

## Main.java

This is our server API for handling requests from the fronted.

### Routes:

### GET /
#### No Params
#### Return:
This returns the string 'Hello World!' to test that the server is live.

### GET /quicksort
#### Params:
size: size of array to generate and sort
#### Return:
This returns a json that is a 2D list of the steps to perform quick sort

### GET /bubblesort
#### Params:
size: size of array to generate and sort
#### Return:
This returns a json that is a 2D list of the steps to perform bubble sort

### GET /selectionsort
#### Params:
size: size of array to generate and sort
#### Return:
This returns a json that is a 2D list of the steps to perform selection sort

### GET /insertionsort
#### Params:
size: size of array to generate and sort
#### Return:
This returns a json that is a 2D list of the steps to perform insertion sort

### GET /heapsort
#### Params:
size: size of array to generate and sort
#### Return:
This returns a json that is a 2D list of the steps to perform heap sort

### GET /shellsort
#### Params:
size: size of array to generate and sort
#### Return:
This returns a json that is a 2D list of the steps to perform shell sort

### GET /stack
#### Params:
expression: string expression to evaluate
#### Return:
This returns the evaluated sum of the expression. Returns 'Invalid Format!' if it
is unable to evaluate.
