package controller;

import model.Storage;
import view.ConsoleWriter;

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
        generator.soutAllFlowerBoxesCombinations();
    }
}
