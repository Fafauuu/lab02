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

    }

    private void addPlantPartitions() {
        for (int i = 0; i < storage.getPlants().size(); i++) {
            Plant plant = storage.getPlants().get(i);
            plantPossiblePartitions.put(plant, PartitionGenerator.partition(storage.getPlantAmount(plant)));
        }
    }

    public Storage getStorage() {
        return storage;
    }

    public Map<Plant, List<List<Integer>>> getPlantPossiblePartitions() {
        return plantPossiblePartitions;
    }
}
