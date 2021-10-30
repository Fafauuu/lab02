package view;

import model.*;

import java.util.List;
import java.util.Map;

public class ConsoleWriter {
    private final Storage storage;
    private final Combinations combinations;

    public ConsoleWriter(Storage storage, Combinations combinations) {
        this.storage = storage;
        this.combinations = combinations;
    }

    public void printBorders(){
        List<Border> borders = storage.getBorders();
        System.out.println("Borders:");
        for (Border border : borders) {
            System.out.println(border.getBorderNumber() + ";" + getPlantsInBorder(border));
        }
        System.out.println();
    }

    private String getPlantsInBorder(Border border) {
        List<FlowerBox> flowerBoxes = border.getFlowerBoxes();
        StringBuilder stringBuilder = new StringBuilder();
        for (FlowerBox flowerBox : flowerBoxes) {
            stringBuilder.append(flowerBox.getFlower().getPlantType())
                    .append(",")
                    .append(flowerBox.getQuantity())
                    .append(";");
        }
        return stringBuilder.toString();
    }

    public void printPlants(){
        Map<Plant, Integer> plantAmounts = storage.getPlantAmounts();
        System.out.println("Plants:");
        for (Plant plant : plantAmounts.keySet()) {
            System.out.println(plant.getPlantType() + " amount: " + plantAmounts.get(plant));
        }
        System.out.println();
    }

    public void printPossibleSplittings(){
        for (Plant plant : combinations.getPlantPossibleSplitting().keySet()) {
            System.out.println("plant: " + plant.getPlantType());
            for (List<Integer> partitions : combinations.getPlantPossibleSplitting().get(plant)) {
                System.out.println(partitions);
            }
            System.out.println();
        }
    }

    public void printAllFlowerBoxesCombinations(){
        for (List<FlowerBox> flowerBoxesCombination : combinations.getAllFlowerBoxesCombinations()) {
            System.out.println(flowerBoxesCombination);
        }
        System.out.println(combinations.getAllFlowerBoxesCombinations().size());
    }

    public void printBorderFillingPossibilities(){
        StringBuilder bordersPossibilities = new StringBuilder();

        for (List<Border> bordersFillingPossibility : combinations.getBordersFillingPossibilities()) {
            for (Border border : bordersFillingPossibility) {
                bordersPossibilities.append(String.format("%-60s", border.toString()));
            }
            bordersPossibilities.append("\n");
        }
        System.out.println(bordersPossibilities);

        System.out.println(combinations.getBordersFillingPossibilities().size());
    }
}
