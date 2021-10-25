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
    private final List<List<SingleFlowerBoxesPackage>> allFlowerBoxesPackages;

    public Generator(Storage storage) {
        this.storage = storage;
        this.plantPossiblePartitions = new HashMap<>();
        addPlantPartitions();
        this.allFlowerBoxesPackages = new ArrayList<>();
        addAllFlowerBoxesPackages();
    }

    private void addPlantPartitions() {
        for (Plant plant : storage.getPlants()) {
            int plantAmount = storage.getPlantAmounts().get(plant);
            List<List<Integer>> plantAmounts = PartitionGenerator.partition(plantAmount);
            plantPossiblePartitions.put(plant, plantAmounts);
        }
    }

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
        List<SingleFlowerBoxesPackage> listOfSingleFlowerBoxesPackages = new ArrayList<>();
        SingleFlowerBoxesPackage singleFlowerBoxesPackage;
        for (Plant plant : plantPossiblePartitions.keySet()) {
            singleFlowerBoxesPackage = new SingleFlowerBoxesPackage(createFlowerBoxes(plant));
        }
    }

    private List<FlowerBox> createFlowerBoxes(Plant plant) {

        SingleFlowerBoxesPackage singleFlowerBoxesPackage;
        List<FlowerBox> singlePossibilityFlowerBoxes;
        List<List<Integer>> allSplitPossibilities = plantPossiblePartitions.get(plant);
        for (List<Integer> splitPossibility : allSplitPossibilities) {
            singlePossibilityFlowerBoxes = new ArrayList<>();
            for (Integer plantAmount : splitPossibility) {
                singlePossibilityFlowerBoxes.add(new FlowerBox((Flower) plant, plantAmount));
            }
            singleFlowerBoxesPackage = new SingleFlowerBoxesPackage(singlePossibilityFlowerBoxes);
        }
        return null;
    }

    void generateCombinations(List<List<SingleFlowerBoxesPackage>> lists, List<String> result, int depth, String current) {
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
