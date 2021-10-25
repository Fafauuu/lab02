package controller;

import model.Flower;
import model.FlowerBox;
import model.FlowerBoxesCombination;
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

        Generator generator = new Generator(storage);
        generator.soutPossiblePartitions();

        List<FlowerBox> flowerBoxList = new ArrayList<>();
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(0), 3));
        FlowerBoxesCombination boxList1 = new FlowerBoxesCombination(flowerBoxList);

        flowerBoxList = new ArrayList<>();
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(0), 2));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(0), 1));
        FlowerBoxesCombination boxList2 = new FlowerBoxesCombination(flowerBoxList);

        flowerBoxList = new ArrayList<>();
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(0), 1));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(0), 1));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(0), 1));
        FlowerBoxesCombination boxList3 = new FlowerBoxesCombination(flowerBoxList);


        flowerBoxList = new ArrayList<>();
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 4));
        FlowerBoxesCombination boxList4 = new FlowerBoxesCombination(flowerBoxList);

        flowerBoxList = new ArrayList<>();
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 3));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 1));
        FlowerBoxesCombination boxList5 = new FlowerBoxesCombination(flowerBoxList);

        flowerBoxList = new ArrayList<>();
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 2));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 2));
        FlowerBoxesCombination boxList6 = new FlowerBoxesCombination(flowerBoxList);

        flowerBoxList = new ArrayList<>();
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 2));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 1));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 1));
        FlowerBoxesCombination boxList7 = new FlowerBoxesCombination(flowerBoxList);

        flowerBoxList = new ArrayList<>();
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 1));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 1));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 1));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 1));
        FlowerBoxesCombination boxList8 = new FlowerBoxesCombination(flowerBoxList);

        boxList1.soutList();
        boxList2.soutList();
        boxList3.soutList();
        boxList4.soutList();
        boxList5.soutList();
        boxList6.soutList();
        boxList7.soutList();
        boxList8.soutList();

        System.out.println("box1 equals box2? " + boxList1.equals(boxList2));

        List<FlowerBoxesCombination> listOfCombinations1 = new ArrayList<>();
        listOfCombinations1.add(boxList1);
        listOfCombinations1.add(boxList2);
        listOfCombinations1.add(boxList3);

        List<FlowerBoxesCombination> listOfCombinations2 = new ArrayList<>();
        listOfCombinations2.add(boxList4);
        listOfCombinations2.add(boxList5);
        listOfCombinations2.add(boxList6);
        listOfCombinations2.add(boxList7);
        listOfCombinations2.add(boxList8);

        List<List<FlowerBoxesCombination>> argument = new ArrayList<>();
        argument.add(listOfCombinations1);
        argument.add(listOfCombinations2);

        List<String> result = new ArrayList<>();

        generator.generateCombinations(argument, result, 0, ";");
        System.out.println(result);

//        List<FlowerBoxesCombination> argument = new ArrayList<>();
//        argument.add(boxList1);
//        argument.add(boxList2);
//
//        List<String> result = new ArrayList<>();
//
//        generator.generateCombinations(argument, result, 0, ";");
//
//        System.out.println(result);

//        CombinationGenerator cg = new CombinationGenerator(10,3);
//        while(cg.hasMore()){
//            int[] a = cg.getNext();
//            for(int i=0; i<3; i++)
//                System.out.print(a[i]+" ");
//            System.out.println();
//        }
    }
}
