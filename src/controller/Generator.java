package controller;

import model.*;

import java.util.*;

public class Generator {
    private final Storage storage;

    //Map with plants and their possible combinations of splitting that sum to initial amount of this plant
    private final Map<Plant, List<List<Integer>>> plantPossibleSplitting;
    private final List<List<List<FlowerBox>>> listOfFlowerPackingPossibilities;
    private final List<List<List<FlowerBox>>> allFlowerBoxesCombinations;

    public Generator(Storage storage) {
        this.storage = storage;
        this.plantPossibleSplitting = new HashMap<>();
        generateAllPlantSplittings();
        this.listOfFlowerPackingPossibilities = new ArrayList<>();
        generateListOfFlowerPackingPossibilities();
        this.allFlowerBoxesCombinations = CombinationGenerator.getCombinations(listOfFlowerPackingPossibilities);
    }

    private void generateAllPlantSplittings() {
        for (Plant plant : storage.getPlants()) {
            int plantAmount = storage.getPlantAmounts().get(plant);
            List<List<Integer>> plantAmounts = SplittingGenerator.split(plantAmount);
            plantPossibleSplitting.put(plant, plantAmounts);
        }
    }

    //TODO delete
    public void soutPossibleSplittings(){
        for (Plant plant : plantPossibleSplitting.keySet()) {
            System.out.println("plant: " + plant.getPlantType());
            for (List<Integer> partitions : plantPossibleSplitting.get(plant)) {
                System.out.println(partitions);
            }
            System.out.println();
        }
    }

    private void generateListOfFlowerPackingPossibilities() {
        for (Plant plant : plantPossibleSplitting.keySet()) {
            listOfFlowerPackingPossibilities.add(createListOfSingleFlowerPackingPossibilities((Flower) plant));
        }
    }

    private List<List<FlowerBox>> createListOfSingleFlowerPackingPossibilities(Flower flower) {
        List<List<FlowerBox>> listOfPackingPossibilities = new ArrayList<>();
        List<FlowerBox> singlePackingPossibility;
        List<List<Integer>> allFlowerSplittingPossibilities = plantPossibleSplitting.get(flower);
        for (List<Integer> splitPossibility : allFlowerSplittingPossibilities) {
            singlePackingPossibility = new ArrayList<>();
            for (Integer plantAmount : splitPossibility) {
                singlePackingPossibility.add(new FlowerBox(flower, plantAmount));
            }
            listOfPackingPossibilities.add(singlePackingPossibility);
        }
        return listOfPackingPossibilities;
    }

    //TODO delete
    public void soutAllFlowerBoxesCombinations(){
        for (List<List<FlowerBox>> flowerBoxesCombination : allFlowerBoxesCombinations) {
            System.out.println(flowerBoxesCombination);
        }
        System.out.println(allFlowerBoxesCombinations.size());
    }
}
