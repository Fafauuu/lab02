package controller;

import model.Flower;
import model.FlowerBox;
import model.FlowerBoxesPackage;
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
        FlowerBoxesPackage boxList1 = new FlowerBoxesPackage(flowerBoxList);

        flowerBoxList = new ArrayList<>();
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(0), 2));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(0), 1));
        FlowerBoxesPackage boxList2 = new FlowerBoxesPackage(flowerBoxList);

        flowerBoxList = new ArrayList<>();
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(0), 1));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(0), 1));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(0), 1));
        FlowerBoxesPackage boxList3 = new FlowerBoxesPackage(flowerBoxList);


        flowerBoxList = new ArrayList<>();
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 4));
        FlowerBoxesPackage boxList4 = new FlowerBoxesPackage(flowerBoxList);

        flowerBoxList = new ArrayList<>();
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 3));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 1));
        FlowerBoxesPackage boxList5 = new FlowerBoxesPackage(flowerBoxList);

        flowerBoxList = new ArrayList<>();
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 2));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 2));
        FlowerBoxesPackage boxList6 = new FlowerBoxesPackage(flowerBoxList);

        flowerBoxList = new ArrayList<>();
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 2));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 1));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 1));
        FlowerBoxesPackage boxList7 = new FlowerBoxesPackage(flowerBoxList);

        flowerBoxList = new ArrayList<>();
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 1));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 1));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 1));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(1), 1));
        FlowerBoxesPackage boxList8 = new FlowerBoxesPackage(flowerBoxList);

        flowerBoxList = new ArrayList<>();
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(2), 2));
        FlowerBoxesPackage boxList9 = new FlowerBoxesPackage(flowerBoxList);

        flowerBoxList = new ArrayList<>();
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(2), 1));
        flowerBoxList.add(new FlowerBox((Flower) storage.getPlants().get(2), 1));
        FlowerBoxesPackage boxList10 = new FlowerBoxesPackage(flowerBoxList);

        boxList1.soutList();
        boxList2.soutList();
        boxList3.soutList();
        boxList4.soutList();
        boxList5.soutList();
        boxList6.soutList();
        boxList7.soutList();
        boxList8.soutList();
        boxList9.soutList();
        boxList10.soutList();

        System.out.println("box1 equals box2? " + boxList1.equals(boxList2));

        List<FlowerBoxesPackage> listOfPackages1 = new ArrayList<>();
        listOfPackages1.add(boxList1);
        listOfPackages1.add(boxList2);
        listOfPackages1.add(boxList3);

        List<FlowerBoxesPackage> listOfPackages2 = new ArrayList<>();
        listOfPackages2.add(boxList4);
        listOfPackages2.add(boxList5);
        listOfPackages2.add(boxList6);
        listOfPackages2.add(boxList7);
        listOfPackages2.add(boxList8);

        List<FlowerBoxesPackage> listOfPackages3 = new ArrayList<>();
        listOfPackages3.add(boxList9);
        listOfPackages3.add(boxList10);

        List<List<FlowerBoxesPackage>> argument = new ArrayList<>();
        argument.add(listOfPackages1);
        argument.add(listOfPackages2);
        argument.add(listOfPackages3);

        System.out.println();
        System.out.println("test");
        for (List<FlowerBoxesPackage> flowerBoxesPackages : argument) {
            for (FlowerBoxesPackage flowerBoxesPackage : flowerBoxesPackages) {
                System.out.println(flowerBoxesPackage);
            }
        }
        System.out.println("koniec testu");


        List<String> result = new ArrayList<>();

        generator.generateCombinations(argument, result, 0, ";");
        System.out.println(result);
        System.out.println();
        System.out.println();

        for (String s : result) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println();

//        List<FlowerBoxesPackage> argument = new ArrayList<>();
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
