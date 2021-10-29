package controller;

import java.util.ArrayList;
import java.util.List;

public class ListCombiner {
    public static <T> List<List<T>> getCombinations(List<List<T>> lists) {
        List<List<T>> combinations = new ArrayList<>();
        List<List<T>> newCombinations;

        int index = 0;

        for (T i : lists.get(0)) {
            List<T> newList = new ArrayList<>();
            newList.add(i);
            combinations.add(newList);
        }
        index++;
        while (index < lists.size()) {
            List<T> nextList = lists.get(index);
            newCombinations = new ArrayList<>();
            for (List<T> first : combinations) {
                for (T second : nextList) {
                    List<T> newList = new ArrayList<>();
                    newList.addAll(first);
                    newList.add(second);
                    newCombinations.add(newList);
                }
            }
            combinations = newCombinations;
            index++;
        }
        return combinations;
    }
}
