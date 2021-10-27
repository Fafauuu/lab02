package controller;

import model.*;

import java.util.*;

public class Generator {
    private final Storage storage;

    //Map with plants and their possible combinations of partition that sum to initial amount of this plant
    private final Map<Plant, List<List<Integer>>> plantPossiblePartitions;
    private final List<List<FlowerBoxesPackage>> allFlowerBoxesPackages;
    private final List<List<FlowerBoxesPackage>> allFlowerBoxesCombinations;

    public Generator(Storage storage) {
        this.storage = storage;
        this.plantPossiblePartitions = new HashMap<>();
        addPlantPartitions();
        this.allFlowerBoxesPackages = new ArrayList<>();
        addAllFlowerBoxesPackages();
        this.allFlowerBoxesCombinations = CombinationGenerator.getCombinations(allFlowerBoxesPackages);
    }

    private void addPlantPartitions() {
        for (Plant plant : storage.getPlants()) {
            int plantAmount = storage.getPlantAmounts().get(plant);
            List<List<Integer>> plantAmounts = PartitionGenerator.partition(plantAmount);
            plantPossiblePartitions.put(plant, plantAmounts);
        }
    }

    //TODO delete
    public void soutPossiblePartitions(){
        for (Plant plant : plantPossiblePartitions.keySet()) {
            System.out.println("plant: " + plant.getPlantType());
            for (List<Integer> partitions : plantPossiblePartitions.get(plant)) {
                System.out.println(partitions);
            }
            System.out.println();
        }
    }

    //TODO delete
    public void soutAllFlowerBoxesCombinations(){
        for (List<FlowerBoxesPackage> allFlowerBoxesCombination : allFlowerBoxesCombinations) {
            System.out.println(allFlowerBoxesCombination);
        }
        System.out.println(allFlowerBoxesCombinations.size());
    }

    private void addAllFlowerBoxesPackages() {
        for (Plant plant : plantPossiblePartitions.keySet()) {
            allFlowerBoxesPackages.add(getListOfFlowerPossibleBoxesPackages((Flower) plant));
        }
    }

    private List<FlowerBoxesPackage> getListOfFlowerPossibleBoxesPackages(Flower flower) {
        List<FlowerBoxesPackage> listOfSingleFlowerPossibleBoxesPackages = new ArrayList<>();
        List<FlowerBox> singleFlowerPossibleBoxesPackage;
        List<List<Integer>> allSplitPossibilities = plantPossiblePartitions.get(flower);
        for (List<Integer> splitPossibility : allSplitPossibilities) {
            singleFlowerPossibleBoxesPackage = new ArrayList<>();
            for (Integer plantAmount : splitPossibility) {
                singleFlowerPossibleBoxesPackage.add(new FlowerBox(flower, plantAmount));
            }
            listOfSingleFlowerPossibleBoxesPackages.add(new FlowerBoxesPackage(singleFlowerPossibleBoxesPackage));
        }
        return listOfSingleFlowerPossibleBoxesPackages;
    }

    public Map<Plant, List<List<Integer>>> getPlantPossiblePartitions() {
        return plantPossiblePartitions;
    }
}
