package controller;

import java.util.ArrayList;
import java.util.List;

public class PartitionGenerator {
    private static final List<List<Integer>> partitionsList = new ArrayList<>();

    public static List<List<Integer>> partition(int n) {
        partitionsList.clear();
        partition(n, n, "");
        return partitionsList;
    }

    public static void partition(int n, int max, String prefix) {

        if (n == 0) {
            partitionsList.add(divide(prefix));
        }

        for (int i = Math.min(max, n); i >= 1; i--) {
            partition(n - i, i, prefix + " " + i);
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
