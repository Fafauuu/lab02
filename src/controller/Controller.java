package controller;

import model.FlowerBox;
import model.Plant;
import model.Storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    private final Storage storage;

    //Map with plants and their possible combinations of partition that sum to initial amount of this plant
    private final Map<Plant, List<List<Integer>>> plantPossiblePartitions;
    private final List<List<FlowerBox>> flowerBoxesCombinations;

    public Controller(Storage storage) {
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

    public Storage getStorage() {
        return storage;
    }

    public Map<Plant, List<List<Integer>>> getPlantPossiblePartitions() {
        return plantPossiblePartitions;
    }
}
