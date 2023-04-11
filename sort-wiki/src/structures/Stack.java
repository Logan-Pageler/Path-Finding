package structures;

import java.util.EmptyStackException;

/**
 * Implementation of a growable stack. Uses an array.
 * 
 * @author Logan Pageler
 * @since 4/10/2023
 */
public class Stack<E> {
    public Object[] arr;
    public int size;

    public Stack() {
        arr = new Object[10];
        size = 0;
    }

    /**
     * Adds value to stack.
     * 
     * @param val Value to add.
     */
    public void push(E val) {
        if (size == arr.length) {
            Object[] tmp = new Object[arr.length * 2];
            copy(arr, tmp, size);
        }
        arr[size++] = val;
    }

    /**
     * Check wether stack is empty
     * 
     * @return boolean wether stack is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Pops item from stack and returns it
     * 
     * @return top value
     */
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        E val = (E) arr[--size];

        if (size <= arr.length / 4 && arr.length / 2 >= 10) {
            Object[] tmp = new Object[arr.length / 2];
            copy(arr, tmp, size);
        }

        return val;
    }

    /**
     * Returns the top value of the stack without removing it
     * 
     * @return Top value of the stack
     */
    public E peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return (E) arr[size - 1];
    }

    private static void copy(Object[] arr1, Object[] arr2, int size) {
        for (int i = 0; i < size; i++) {
            arr2[i] = arr1[i];
        }
    }

}
