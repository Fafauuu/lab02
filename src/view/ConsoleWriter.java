package view;

import model.Border;
import model.FlowerBox;
import model.Plant;
import model.Storage;

import java.util.List;
import java.util.Map;

public class ConsoleWriter {
    private Storage storage;

    public ConsoleWriter(Storage storage) {
        this.storage = storage;
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
}
