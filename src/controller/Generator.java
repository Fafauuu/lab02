package controller;

import model.FlowerBox;
import model.FlowerBoxesCombination;
import model.Plant;
import model.Storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Generator {
    private final Storage storage;

    //Map with plants and their possible combinations of partition that sum to initial amount of this plant
    private final Map<Plant, List<List<Integer>>> plantPossiblePartitions;
    private final List<FlowerBoxesCombination> flowerBoxesCombinations;

    public Generator(Storage storage) {
        this.storage = storage;
        this.plantPossiblePartitions = new HashMap<>();
        addPlantPartitions();
        this.flowerBoxesCombinations = new ArrayList<>();
        addFlowerBoxesCombinations();
    }

    private void addPlantPartitions() {
        for (Plant plant : storage.getPlants()) {
            int plantAmount = storage.getPlantAmounts().get(plant);
            List<List<Integer>> plantAmounts = PartitionGenerator.partition(plantAmount);
            plantPossiblePartitions.put(plant, plantAmounts);
        }
    }

    private void addFlowerBoxesCombinations() {
        List<FlowerBox> flowerBoxes = new ArrayList<>();
        for (Plant outerPlant : plantPossiblePartitions.keySet()) {

        }
    }

    void generateCombinations(List<List<FlowerBoxesCombination>> lists, List<String> result, int depth, String current) {
        if (depth == lists.size()) {
            result.add(current);
            return;
        }

        for (int i = 0; i < lists.get(depth).size(); i++) {
            generateCombinations(lists, result, depth + 1, current + lists.get(depth).get(i));
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

    public Map<Plant, List<List<Integer>>> getPlantPossiblePartitions() {
        return plantPossiblePartitions;
    }
}
