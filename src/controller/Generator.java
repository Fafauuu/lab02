package controller;

import model.*;

import java.util.*;

public class Generator {
    private final Storage storage;
    private final Combinations combinations;

    public Generator(Storage storage, Combinations combinations) {
        this.storage = storage;
        this.combinations = combinations;
    }

    public void generateAllPlantSplittings() {
        Map<Plant, List<List<Integer>>> plantPossibleSplitting = new HashMap<>();
        for (Plant plant : storage.getPlants()) {
            int plantAmount = storage.getPlantAmounts().get(plant);
            List<List<Integer>> plantAmounts = ListSplitter.split(plantAmount);
            plantPossibleSplitting.put(plant, plantAmounts);
        }
        combinations.setPlantPossibleSplitting(plantPossibleSplitting);
    }

    public void generateListOfFlowersPackingPossibilities() {
        List<List<List<FlowerBox>>> listOfFlowerPackingPossibilities = new ArrayList<>();
        for (Plant plant : combinations.getPlantPossibleSplitting().keySet()) {
            listOfFlowerPackingPossibilities.add(createListOfSingleFlowerPackingPossibilities((Flower) plant));
        }
        combinations.setListOfFlowersPackingPossibilities(listOfFlowerPackingPossibilities);
    }

    private List<List<FlowerBox>> createListOfSingleFlowerPackingPossibilities(Flower flower) {
        List<List<FlowerBox>> listOfPackingPossibilities = new ArrayList<>();
        List<FlowerBox> singlePackingPossibility;
        List<List<Integer>> allFlowerSplittingPossibilities = combinations.getPlantPossibleSplitting().get(flower);
        for (List<Integer> splitPossibility : allFlowerSplittingPossibilities) {
            singlePackingPossibility = new ArrayList<>();
            for (Integer plantAmount : splitPossibility) {
                singlePackingPossibility.add(new FlowerBox(flower, plantAmount));
            }
            listOfPackingPossibilities.add(singlePackingPossibility);
        }
        return listOfPackingPossibilities;
    }

    public void generateAllFlowerBoxesCombinations(){
        List<List<List<FlowerBox>>> flowerBoxesList = ListCombiner.getCombinations(
                combinations.getListOfFlowersPackingPossibilities());
        List<List<FlowerBox>> newList = new ArrayList<>();
        for (List<List<FlowerBox>> flowerBoxes : flowerBoxesList) {
            newList.add(combineFlowerBoxesList(flowerBoxes));
        }
        combinations.setAllFlowerBoxesCombinations(newList);
    }

    private List<FlowerBox> combineFlowerBoxesList(List<List<FlowerBox>> combination) {
        List<FlowerBox> newFlowerBoxes = new ArrayList<>();
        for (List<FlowerBox> flowerBoxList : combination) {
            newFlowerBoxes.addAll(flowerBoxList);
        }
        return newFlowerBoxes;
    }

    public void generateBordersFillingPossibilities(){
        List<Border> borders = storage.getBorders();
        Set<List<Integer>> bordersFillingOrder = createBordersFillingOrder();
        List<List<FlowerBox>> allFlowerBoxesCombinations = combinations.getAllFlowerBoxesCombinations();

        for (List<FlowerBox> combination : allFlowerBoxesCombinations) {
            for (List<Integer> fillingOrder : bordersFillingOrder) {

            }
        }

    }

    private Set<List<Integer>> createBordersFillingOrder(){
        int numberOfBorders = storage.getBorders().size();
        List<Integer> listToPermute = new ArrayList<>(9);

        //generator works precisely for border amount less than 5;
        //after that algorithm is simplified because of run time issue
        int iterations;
        switch (numberOfBorders) {
            case 2:
            case 4:
                iterations = 2;
                break;
            case 3:
                iterations = 3;
                break;
            default: iterations = 1;
        }
        for (int i = 0; i < (iterations); i++) {
            for (int j = 1; j <= numberOfBorders; j++) {
                listToPermute.add(j);
            }
        }
        int[] arrayToPermute = listToPermute.stream().mapToInt(i -> i).toArray();
        return IntPermutations.permute(arrayToPermute);
    }

    //        Set<List<Border>> borderPossibilities = new HashSet<>();
//        List<Border> list1 = storage.getBordersCopy();
//        List<Border> list2 = storage.getBordersCopy();
////        List<Border> list3 = new ArrayList<>(3);
//        list1.get(0).addFlowerBox(new FlowerBox((Flower) storage.getPlants().get(0),2));
//        list1.get(1).addFlowerBox(new FlowerBox((Flower) storage.getPlants().get(0),3));
//
//        list2.get(0).addFlowerBox(new FlowerBox((Flower) storage.getPlants().get(0),2));
//        list2.get(1).addFlowerBox(new FlowerBox((Flower) storage.getPlants().get(0),3));
//
//        borderPossibilities.add(list1);
//        borderPossibilities.add(list2);
//
//        combinations.setBordersFillingPossibilities(borderPossibilities);
}
