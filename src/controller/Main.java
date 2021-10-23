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

        Controller controller = new Controller(storage);

//        CombinationGenerator cg = new CombinationGenerator(10,3);
//        while(cg.hasMore()){
//            int[] a = cg.getNext();
//            for(int i=0; i<3; i++)
//                System.out.print(a[i]+" ");
//            System.out.println();
//        }
    }
}
