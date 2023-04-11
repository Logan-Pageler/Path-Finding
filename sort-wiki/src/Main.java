import java.util.Arrays;
import java.util.List;

import compass.App;
import compass.http.Session;

import sorters.*;
import structures.ArithmeticSolver;

public class Main {

    /**
     * Server API to handle requests to sort arrays and solve
     * mathematical expressions.
     * 
     * @author Logan Pageler, Evan Ohme
     * @since 4/10/2023
     */
    public static void main(String[] args) {

        App<Session> app = new App<Session>(8080);

        app.getDefaultMessage().addHeader("Access-Control-Allow-Origin", "*");

        app.addRoute("/", (req, res, ses) -> {
            res.setBody("Hello Word!");
        });

        app.addRoute("/quicksort", (req, res, ses) -> {
            int[] arr = generateArray(20);
            List<int[]> list = QuickSort.sort(arr);
            res.setBody(stringifySnapshots(list));
        });

        app.addRoute("/bubblesort", (req, res, ses) -> {
            int[] arr = generateArray(20);
            List<int[]> list = BubbleSort.sort(arr);
            res.setBody(stringifySnapshots(list));
        });

        app.addRoute("/selectionsort", (req, res, ses) -> {
            int[] arr = generateArray(20);
            List<int[]> list = SelectionSort.sort(arr);
            res.setBody(stringifySnapshots(list));
        });

        app.addRoute("/insertionsort", (req, res, ses) -> {
            int[] arr = generateArray(20);
            List<int[]> list = InsertionSort.sort(arr);
            res.setBody(stringifySnapshots(list));
        });

        app.addRoute("/heapsort", (req, res, ses) -> {
            int[] arr = generateHeapArray(20);
            List<int[]> list = HeapSort.sort(arr);
            res.setBody(stringifySnapshots(list));
        });

        app.addRoute("/shellsort", (req, res, ses) -> {
            System.out.println(req.getQuery());
            int[] arr = generateArray(20);
            List<int[]> list = ShellSort.sort(arr);
            res.setBody(stringifySnapshots(list));
        });

        app.addRoute("/stack", (req, res, ses) -> {
            try {
                res.setBody("" + ArithmeticSolver.evaluate(req.getQuery().get("expression")));
            } catch (Exception e) {
                res.setBody("Invalid Format!");
            }
        });

        app.start();
    }

    private static int[] generateArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = (int) (Math.random() * n * 2);
        return arr;
    }

    private static int[] generateHeapArray(int n) {
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++)
            arr[i] = (int) (Math.random() * n * 2);
        return arr;
    }

    private static String stringifySnapshots(List<int[]> list) {
        String out = "[";
        for (int[] a : list)
            out += Arrays.toString(a) + ",";
        out = out.substring(0, out.length() - 1);
        out += "]";
        return out;
    }
}