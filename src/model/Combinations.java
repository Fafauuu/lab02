package model;

import java.util.List;
import java.util.Map;

public class Combinations {
    //Map with plants and their possible combinations of splitting that sum to initial amount of this plant
    private Map<Plant, List<List<Integer>>> plantPossibleSplitting;
    private List<List<List<FlowerBox>>> listOfFlowersPackingPossibilities;
    private List<List<List<FlowerBox>>> allFlowerBoxesCombinations;

    public Map<Plant, List<List<Integer>>> getPlantPossibleSplitting() {
        if (plantPossibleSplitting == null) {
            throw new RuntimeException("No plant possible splittings generated yet");
        }
        return plantPossibleSplitting;
    }

    public void setPlantPossibleSplitting(Map<Plant, List<List<Integer>>> plantPossibleSplitting) {
        this.plantPossibleSplitting = plantPossibleSplitting;
    }

    public List<List<List<FlowerBox>>> getListOfFlowersPackingPossibilities() {
        if (listOfFlowersPackingPossibilities == null) {
            throw new RuntimeException("No flower packing possibilities generated yet");
        }
        return listOfFlowersPackingPossibilities;
    }

    public void setListOfFlowersPackingPossibilities(List<List<List<FlowerBox>>> listOfFlowersPackingPossibilities) {
        this.listOfFlowersPackingPossibilities = listOfFlowersPackingPossibilities;
    }

    public List<List<List<FlowerBox>>> getAllFlowerBoxesCombinations() {
        if (allFlowerBoxesCombinations == null) {
            throw new RuntimeException("No flower boxes combinations generated yet");
        }
        return allFlowerBoxesCombinations;
    }

    public void setAllFlowerBoxesCombinations(List<List<List<FlowerBox>>> allFlowerBoxesCombinations) {
        this.allFlowerBoxesCombinations = allFlowerBoxesCombinations;
    }
}
