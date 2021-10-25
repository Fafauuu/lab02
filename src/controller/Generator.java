package controller;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Generator {
    private final Storage storage;

    //Map with plants and their possible combinations of partition that sum to initial amount of this plant
    private final Map<Plant, List<List<Integer>>> plantPossiblePartitions;
    private final List<List<FlowerBoxesPackage>> allFlowerBoxesPackages;
    private List<String> allPossibleFlowerBoxesCombinations;

    public Generator(Storage storage) {
        this.storage = storage;
        this.plantPossiblePartitions = new HashMap<>();
        addPlantPartitions();
        this.allFlowerBoxesPackages = new ArrayList<>();
        addAllFlowerBoxesPackages();
        this.allPossibleFlowerBoxesCombinations = new ArrayList<>();
        generateCombinations(allFlowerBoxesPackages, allPossibleFlowerBoxesCombinations, 0, ";");
        for (String s : allPossibleFlowerBoxesCombinations) {
            System.out.println(s);
        }
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

    public void generateCombinations(List<List<FlowerBoxesPackage>> lists, List<String> result, int depth, String current) {
        if (depth == lists.size()) {
            result.add(current);
            return;
        }

        for (int i = 0; i < lists.get(depth).size(); i++) {
            generateCombinations(lists, result, depth + 1, current + lists.get(depth).get(i));
        }
    }

    public Map<Plant, List<List<Integer>>> getPlantPossiblePartitions() {
        return plantPossiblePartitions;
    }
}
