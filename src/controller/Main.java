package controller;

import model.*;
import view.ConsolePrinter;

import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        storage.setBorders(CsvReader.readBorders("borders.csv"));
        storage.setPlants(CsvReader.readFlowers("flowers.csv"));
        storage.setPlantAmounts(CsvReader.readPlantAmounts("flowerAmounts.csv"));

        Combinations combinations = new Combinations();
        Generator generator = new Generator(storage, combinations);
        ConsolePrinter consolePrinter = new ConsolePrinter(storage, combinations);

        generator.generateAllPlantSplittings();
        generator.generateListOfFlowersPackingPossibilities();
        generator.generateAllFlowerBoxesCombinations();
        generator.generateBordersFillingPossibilities();

//        consolePrinter.printBorders();
//        consolePrinter.printPlants();
//        consolePrinter.printPossibleSplittings();
//        consolePrinter.printAllFlowerBoxesCombinations();
        consolePrinter.printBorderFillingPossibilities();


        BestCombinationChooser bestCombinationChooser1 = new BestCombinationChooser(combinations, 0,1);

//        Iterator iter = combinations.getBordersFillingPossibilities().iterator();
//
//        for (int i = 0; i < 50; i++) {
//            List<Border> list = (List<Border>) iter.next();
//            System.out.println(bestCombinationChooser1.calculateColorSimilarity(list));
//        }

        List<Border> bestCombination1 = bestCombinationChooser1.choose();

//        System.out.println(bestCombination1);
        consolePrinter.printBorderCombination(bestCombination1);

        BestCombinationChooser bestCombinationChooser2 = new BestCombinationChooser(combinations, 1,1);

        Iterator iter = combinations.getBordersFillingPossibilities().iterator();

        List<Border> bestCombination2 = bestCombinationChooser2.choose();
        consolePrinter.printBorderCombination(bestCombination2);

        BestCombinationChooser bestCombinationChooser3 = new BestCombinationChooser(combinations, 2,1);

        List<Border> bestCombination3 = bestCombinationChooser3.choose();
        consolePrinter.printBorderCombination(bestCombination3);


//        System.out.println(bestCombination2);
//
//        FlowerBox flowerBox1 = new FlowerBox((Flower) storage.getPlants().get(0), 2);
//        FlowerBox flowerBox2 = new FlowerBox((Flower) storage.getPlants().get(1), 2);
//        FlowerBox flowerBox3 = new FlowerBox((Flower) storage.getPlants().get(2), 2);
//        FlowerBox flowerBox4 = new FlowerBox((Flower) storage.getPlants().get(3), 2);
//        FlowerBox flowerBox5 = new FlowerBox((Flower) storage.getPlants().get(4), 2);
//        FlowerBox flowerBox6 = new FlowerBox((Flower) storage.getPlants().get(5), 2);
//        FlowerBox flowerBox7 = new FlowerBox((Flower) storage.getPlants().get(6), 2);
//        FlowerBox flowerBox8 = new FlowerBox((Flower) storage.getPlants().get(7), 2);
//
//        List<Border> borderCombination1 = new ArrayList<>(3);
//        List<Border> borderCombination2 = new ArrayList<>(3);
//        Border border1 = new Border(1, 2);
//        Border border2 = new Border(2, 2);
//        Border border3 = new Border(3, 2);
//        Border border4 = new Border(1, 2);
//        Border border5 = new Border(2, 2);
//        Border border6 = new Border(3, 2);
//
//
//        border1.addFlowerBox(flowerBox1);
//        border1.addFlowerBox(flowerBox2);
//        border1.addFlowerBox(flowerBox3);
//        border1.addFlowerBox(flowerBox4);
//
//        border2.addFlowerBox(flowerBox3);
//        border2.addFlowerBox(flowerBox4);
//        border2.addFlowerBox(flowerBox5);
//        border2.addFlowerBox(flowerBox6);
//
//        border3.addFlowerBox(flowerBox5);
//        border3.addFlowerBox(flowerBox6);
//        border3.addFlowerBox(flowerBox7);
//        border3.addFlowerBox(flowerBox8);
//
//        borderCombination1.add(border1);
//        borderCombination1.add(border2);
//        borderCombination1.add(border3);
//
//        border4.addFlowerBox(flowerBox1);
//        border4.addFlowerBox(flowerBox7);
//        border4.addFlowerBox(flowerBox4);
//        border4.addFlowerBox(flowerBox8);
//
//        border5.addFlowerBox(flowerBox3);
//        border5.addFlowerBox(flowerBox6);
//        border5.addFlowerBox(flowerBox1);
//        border5.addFlowerBox(flowerBox8);
//
//        border6.addFlowerBox(flowerBox2);
//        border6.addFlowerBox(flowerBox5);
//        border6.addFlowerBox(flowerBox8);
//        border6.addFlowerBox(flowerBox7);
//
//        borderCombination2.add(border4);
//        borderCombination2.add(border5);
//        borderCombination2.add(border6);
//
//        for (Border border : borderCombination1) {
//            System.out.println(border);
//        }
//        System.out.println();
//
//        for (Border border : borderCombination2) {
//            System.out.println(border);
//        }
//
//        System.out.println(bestCombinationChooser1.calculateColorSimilarity(borderCombination1));
//        System.out.println(bestCombinationChooser1.calculateColorSimilarity(borderCombination2));

//        List<FlowerBox> list1 = new ArrayList<>();
//        list1.add(flowerBox1);
//        list1.add(flowerBox2);
//
//        List<FlowerBox> list2 = new ArrayList<>();
//        list2.add(flowerBox3);
//        list2.add(flowerBox4);
//
//        List<FlowerBox> list3 = new ArrayList<>();
//        list3.add(flowerBox5);
//        list3.add(flowerBox6);
//
//        List<FlowerBox> list4 = new ArrayList<>();
//        list4.add(flowerBox7);
//        list4.add(flowerBox8);
//
//        List<FlowerBox> list5 = new ArrayList<>();
//        list5.add(flowerBox1);
//        list5.add(flowerBox6);
//
//        List<FlowerBox> list6 = new ArrayList<>();
//        list6.add(flowerBox2);
//        list6.add(flowerBox5);
//
//        List<FlowerBox> list7 = new ArrayList<>();
//        list7.add(flowerBox4);
//        list7.add(flowerBox8);
//
//        List<FlowerBox> list8 = new ArrayList<>();
//        list8.add(flowerBox2);
//        list8.add(flowerBox5);
    }
}
