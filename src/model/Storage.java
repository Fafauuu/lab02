package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private List<Border> borders;
    private List<Plant> plants;
    private Map<Plant, Integer> plantAmounts;

    public Storage() {
        this.borders = new ArrayList<>();
        this.plants = new ArrayList<>();
        this.plantAmounts = new HashMap<>();
    }

    public List<Border> getBorders() {
        return borders;
    }

    public List<Border> getBordersCopy(){
        List<Border> bordersCopy = new ArrayList<>(borders.size());
        for (Border border : borders) {
            bordersCopy.add(new Border(border.getBorderNumber(), border.getArea()));
        }
        return bordersCopy;
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

    public Map<Plant, Integer> getPlantAmounts() {
        return plantAmounts;
    }

    public void setPlantAmounts(Map<Integer, Integer> plantAmountsPassed) {
        Map<Plant, Integer> plantAmounts = new HashMap<>();
        for (Integer plantType : plantAmountsPassed.keySet()) {
            for (Plant plant : plants) {
                if (plant.getPlantType() == plantType){
                    plantAmounts.put(plant, plantAmountsPassed.get(plantType));
                }
            }
        }
        this.plantAmounts = plantAmounts;
    }
}
