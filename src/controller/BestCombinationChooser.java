package controller;

import model.Border;
import model.Combinations;
import model.Flower;
import model.FlowerBox;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BestCombinationChooser {
    private final Combinations combinations;
    private final int filteringMode;
    private final int colorSimilarityParameter;
    private final Set<List<Border>> allBordersFillingPossibilities;

    public BestCombinationChooser(Combinations combinations, int filteringMode, int colorSimilarityParameter) {
        this.combinations = combinations;
        if (filteringMode < 0 || filteringMode > 2) throw new RuntimeException("Invalid filtering mode");
        this.filteringMode = filteringMode;
        this.colorSimilarityParameter = colorSimilarityParameter;
        this.allBordersFillingPossibilities = combinations.getBordersFillingPossibilities();
    }

    public List<Border> choose() {
        List<Border> bestCombination;
        switch (filteringMode) {
            case 0: {
                bestCombination = similarColorsCombination(allBordersFillingPossibilities);
            }
            break;
            case 1: {
                bestCombination = maximumAmountCombination(allBordersFillingPossibilities);
            }
            break;
            default:{
                bestCombination = combineBothFilters(allBordersFillingPossibilities);
            }
        }
        return bestCombination;
    }

    private List<Border> combineBothFilters(Set<List<Border>> bordersFillingPossibilities) {
        List<Border> bordersWithTheMostSimilarColors = similarColorsCombination(bordersFillingPossibilities);
        double bestColorSimilarity = calculateColorSimilarity(bordersWithTheMostSimilarColors);
        double minimalColorSimilarity = bestColorSimilarity + Math.pow(colorSimilarityParameter, 2) * 10;

        Set<List<Border>> bordersWithAskedColorSimilarity = new HashSet<>();

        for (List<Border> bordersFillingPossibility : bordersFillingPossibilities) {
            double colorSimilarity = calculateColorSimilarity(bordersFillingPossibility);
            if (colorSimilarity <= minimalColorSimilarity){
                bordersWithAskedColorSimilarity.add(bordersFillingPossibility);
            }
        }
        return maximumAmountCombination(bordersWithAskedColorSimilarity);
    }

    private List<Border> maximumAmountCombination(Set<List<Border>> bordersFillingPossibilities) {
        List<Border> bestCombination = bordersFillingPossibilities.iterator().next();
        int bestCombinationBloomingAmount = calculateBloomingAmount(bestCombination);

        for (List<Border> bordersFillingPossibility : bordersFillingPossibilities) {
            int bloomingAmount = calculateBloomingAmount(bordersFillingPossibility);
            if (bloomingAmount > bestCombinationBloomingAmount){
                bestCombination = bordersFillingPossibility;
                bestCombinationBloomingAmount = bloomingAmount;
            }
        }
        return bestCombination;
    }

    private int calculateBloomingAmount(List<Border> bestCombination) {
        int bloomingAmount = 0;
        for (int i = 0; i < 12; i++) {
            for (Border border : bestCombination) {
                for (FlowerBox flowerBox : border.getFlowerBoxes()) {
                    if (flowerBox.getFlower().getBlooming()[i]) bloomingAmount += flowerBox.getQuantity();
                }
            }
        }
        return bloomingAmount;
    }

    private List<Border> similarColorsCombination(Set<List<Border>> bordersFillingPossibilities) {
        List<Border> bestCombination = bordersFillingPossibilities.iterator().next();
        double bestCombinationSimilarity = calculateColorSimilarity(bestCombination);

        for (List<Border> bordersFillingPossibility : bordersFillingPossibilities) {
            double similarity = calculateColorSimilarity(bordersFillingPossibility);
            if (similarity < bestCombinationSimilarity) {
                bestCombination = bordersFillingPossibility;
                bestCombinationSimilarity = similarity;
            }
        }
        return bestCombination;
    }

    private double calculateColorSimilarity(List<Border> bordersFillingPossibility) {
        double bordersOverallSimilarity = 0;
        for (Border border : bordersFillingPossibility) {
            double borderColorSimilarity = 0;
            for (int i = 0; i < 12; i++) {
                List<FlowerBox> bloomingBoxes = new ArrayList<>();
                for (FlowerBox flowerBox : border.getFlowerBoxes()) {
                    if (flowerBox.getFlower().getBlooming()[i]) bloomingBoxes.add(flowerBox);
                }
                double borderColorSimilarityInSingleMonth = 0;

                if (bloomingBoxes.size() > 1) {
                    List<List<Integer>> pairs = generateAllPossiblePairs(bloomingBoxes.size());
                    for (List<Integer> pair : pairs) {
                        double similarity = calculateFlowerBoxesColorSimilarity(bloomingBoxes, pair);
                        borderColorSimilarityInSingleMonth += similarity;
                    }

                    borderColorSimilarityInSingleMonth = borderColorSimilarityInSingleMonth / pairs.size();
                    borderColorSimilarity += borderColorSimilarityInSingleMonth;
                }
            }
            bordersOverallSimilarity += borderColorSimilarity;
        }
        return bordersOverallSimilarity / bordersFillingPossibility.size();
    }

    private double calculateFlowerBoxesColorSimilarity(List<FlowerBox> flowerBoxes, List<Integer> pair) {
        Flower firstFlower = flowerBoxes.get(pair.get(0)).getFlower();
        Flower secondFlower = flowerBoxes.get(pair.get(1)).getFlower();

        Color c1 = firstFlower.getColor();
        Color c2 = secondFlower.getColor();

        return Math.sqrt(
                Math.pow((c1.getRed() - c2.getRed()), 2)
                        + Math.pow((c1.getGreen() - c2.getGreen()), 2)
                        + Math.pow((c1.getBlue() - c2.getBlue()), 2)
        );
    }

    private List<List<Integer>> generateAllPossiblePairs(int n) {
        List<List<Integer>> list = new ArrayList<>();
        CombinationGenerator cg = new CombinationGenerator(n, 2);
        while (cg.hasMore()) {
            int[] a = cg.getNext();
            List<Integer> list1 = new ArrayList<>();
            list1.add(a[0]);
            list1.add(a[1]);

            list.add(list1);
        }
        return list;
    }
}
