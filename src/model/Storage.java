package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private List<Border> borders;
    private List<Plant> plants;
    private Map<Integer, Integer> plantAmounts;

    public Storage() {
        this.borders = new ArrayList<>();
        this.plants = new ArrayList<>();
        this.plantAmounts = new HashMap<>();
    }

    public List<Border> getBorders() {
        return borders;
    }

    public void setBorders(List<Border> borders) {
        this.borders = borders;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    public Map<Integer, Integer> getPlantAmounts() {
        return plantAmounts;
    }

    public int getPlantAmount(Plant plant){
        int plantTypeToReturn = 0;
        for (Integer plantType : plantAmounts.keySet()) {
            if (plantType == plant.getPlantType())
                plantTypeToReturn = plantAmounts.get(plantType);
        }
        return plantTypeToReturn;
    }

    public void setPlantAmounts(Map<Integer, Integer> plantAmounts) {
        this.plantAmounts = plantAmounts;
    }
}
