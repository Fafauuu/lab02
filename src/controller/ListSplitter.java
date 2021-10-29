package controller;

import java.util.ArrayList;
import java.util.List;

public class ListSplitter {
    private static List<List<Integer>> splittingList;

    public static List<List<Integer>> split(int n) {
        splittingList = new ArrayList<>();
        split(n, n, "");
        return splittingList;
    }

    public static void split(int n, int max, String prefix) {

        if (n == 0) {
            splittingList.add(divide(prefix));
        }

        for (int i = Math.min(max, n); i >= 1; i--) {
            split(n - i, i, prefix + " " + i);
        }
    }

    private static List<Integer> divide(String prefix) {
        List<Integer> intLine = new ArrayList<>(5);
        String[] data = prefix.split(" ");
        for (int i = 1; i < data.length; i++) {
            intLine.add(Integer.parseInt(data[i]));
        }
        return intLine;
    }
}
