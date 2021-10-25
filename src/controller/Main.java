package controller;

import model.Flower;
import model.FlowerBox;
import model.FlowerBoxesCombinationList;
import model.Storage;
import view.ConsoleWriter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        storage.setBorders(CsvReader.readBorders("borders.csv"));
        storage.setPlants(CsvReader.readFlowers("flowers.csv"));
        storage.setPlantAmounts(CsvReader.readPlantAmounts("flowerAmounts.csv"));

        ConsoleWriter consoleWriter = new ConsoleWriter(storage);
        consoleWriter.printBorders();
        consoleWriter.printPlants();

        Controller controller = new Controller(storage);
        controller.soutPossiblePartitions();

        List<FlowerBox> flowerBoxList = new ArrayList<>();
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(0), 1));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(0), 2));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(0), 2));

        FlowerBoxesCombinationList boxList1 = new FlowerBoxesCombinationList(flowerBoxList);

        flowerBoxList = new ArrayList<>();
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(0), 1));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(0), 2));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(0), 2));

        FlowerBoxesCombinationList boxList2 = new FlowerBoxesCombinationList(flowerBoxList);

        System.out.println(boxList1.getFlowerBoxes().size());
        System.out.println(boxList2.getFlowerBoxes().size());
        System.out.println();
        System.out.println(boxList1.getFlowerBoxes().get(2).getQuantity());
        System.out.println(boxList2.getFlowerBoxes().get(2).getQuantity());
        System.out.println(boxList1.equals(boxList2));

//        CombinationGenerator cg = new CombinationGenerator(10,3);
//        while(cg.hasMore()){
//            int[] a = cg.getNext();
//            for(int i=0; i<3; i++)
//                System.out.print(a[i]+" ");
//            System.out.println();
//        }
    }
}
