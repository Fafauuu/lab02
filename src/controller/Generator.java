package controller;

import model.*;

import java.util.*;

public class Generator {
    private final Storage storage;
    private final Combinations combinations;

    public Generator(Storage storage, Combinations combinations) {
        this.storage = storage;
        this.combinations = combinations;
    }

    public void generateAllPlantSplittings() {
        Map<Plant, List<List<Integer>>> plantPossibleSplitting = new HashMap<>();
        for (Plant plant : storage.getPlants()) {
            int plantAmount = storage.getPlantAmounts().get(plant);
            List<List<Integer>> plantAmounts = ListSplitter.split(plantAmount);
            plantPossibleSplitting.put(plant, plantAmounts);
        }
        combinations.setPlantPossibleSplitting(plantPossibleSplitting);
    }

    public void generateListOfFlowersPackingPossibilities() {
        List<List<List<FlowerBox>>> listOfFlowerPackingPossibilities = new ArrayList<>();
        for (Plant plant : combinations.getPlantPossibleSplitting().keySet()) {
            listOfFlowerPackingPossibilities.add(createListOfSingleFlowerPackingPossibilities((Flower) plant));
        }
        combinations.setListOfFlowersPackingPossibilities(listOfFlowerPackingPossibilities);
    }

    private List<List<FlowerBox>> createListOfSingleFlowerPackingPossibilities(Flower flower) {
        List<List<FlowerBox>> listOfPackingPossibilities = new ArrayList<>();
        List<FlowerBox> singlePackingPossibility;
        List<List<Integer>> allFlowerSplittingPossibilities = combinations.getPlantPossibleSplitting().get(flower);
        for (List<Integer> splitPossibility : allFlowerSplittingPossibilities) {
            singlePackingPossibility = new ArrayList<>();
            for (Integer plantAmount : splitPossibility) {
                singlePackingPossibility.add(new FlowerBox(flower, plantAmount));
            }
            listOfPackingPossibilities.add(singlePackingPossibility);
        }
        return listOfPackingPossibilities;
    }

    public void generateAllFlowerBoxesCombinations(){
        combinations.setAllFlowerBoxesCombinations(
                ListCombiner.getCombinations(combinations.getListOfFlowersPackingPossibilities()));
    }
}
