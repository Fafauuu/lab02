package controller;

import model.Combinations;
import model.Storage;
import view.ConsoleWriter;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        storage.setBorders(CsvReader.readBorders("borders.csv"));
        storage.setPlants(CsvReader.readFlowers("flowers.csv"));
        storage.setPlantAmounts(CsvReader.readPlantAmounts("flowerAmounts.csv"));

        Combinations combinations = new Combinations();

        Generator generator = new Generator(storage, combinations);
        generator.generateAllPlantSplittings();
        generator.generateListOfFlowersPackingPossibilities();
        generator.generateAllFlowerBoxesCombinations();

        ConsoleWriter consoleWriter = new ConsoleWriter(storage, combinations);
        consoleWriter.printBorders();
        consoleWriter.printPlants();
        consoleWriter.printPossibleSplittings();
        consoleWriter.printAllFlowerBoxesCombinations();
    }
}
