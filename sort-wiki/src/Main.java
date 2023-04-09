import java.util.Arrays;
import java.util.List;

import compass.App;
import compass.http.Session;

import sorters.QuickSort;
import sorters.BubbleSort;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        App<Session> app = new App<Session>(8080);

        app.getDefaultMessage().addHeader("Access-Control-Allow-Origin", "*");

        app.addRoute("/", (req, res, ses) -> {
            System.out.println(req);
            res.setBody("Hello Word!");
        });

        app.addRoute("/quicksort", (req, res, ses) -> {
            int[] arr = new int[20];
            for (int i = 0; i < arr.length; i++)
                arr[i] = (int) (Math.random() * arr.length * 2);

            List<int[]> list = QuickSort.sort(arr);
            res.setBody(stringifySnapshots(list));
        });

        app.addRoute("/bubblesort", (req, res, ses) -> {
            int[] arr = new int[20];
            for (int i = 0; i < arr.length; i++)
                arr[i] = (int) (Math.random() * arr.length * 2);

            List<int[]> list = BubbleSort.sort(arr);
            res.setBody(stringifySnapshots(list));
        });

        app.start();
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