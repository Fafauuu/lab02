package controller;

import model.Combinations;
import model.Storage;
import view.ConsolePrinter;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        storage.setBorders(CsvReader.readBorders(args[1]));
        storage.setPlants(CsvReader.readFlowers(args[2]));
        storage.setPlantAmounts(CsvReader.readPlantAmounts(args[3]));

        Combinations combinations = new Combinations();
        Generator generator = new Generator(storage, combinations);
        ConsolePrinter consolePrinter = new ConsolePrinter(storage, combinations);

        generator.generateAllPlantSplittings();
        generator.generateListOfFlowersPackingPossibilities();
        generator.generateAllFlowerBoxesCombinations();
        generator.generateBordersFillingPossibilities();

        BestCombinationChooser bcc
                = new BestCombinationChooser(combinations, Integer.parseInt(args[0]), Integer.parseInt(args[4]));

        consolePrinter.printBorderCombination(bcc.choose());
    }
}
