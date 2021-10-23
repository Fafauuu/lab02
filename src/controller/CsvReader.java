package controller;

import model.Border;
import model.Flower;
import model.Plant;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReader {

    public static List<Border> readBorders(String fileName){
        List<Border> borders = new ArrayList<>();

        try{
            BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
            String line;

            csvReader.readLine();

            while ((line = csvReader.readLine()) != null){
                String[] data = line.split(";");
                int borderNumber = Integer.parseInt(data[0]);
                float area = Float.parseFloat(data[1]);
                borders.add(new Border(borderNumber, area));
            }

        }catch (IOException e){
            e.printStackTrace();
            System.exit(2);
        }

        return borders;
    }

    public static List<Plant> readFlowers(String fileName){
        List<Plant> flowers = new ArrayList<>();

        try{
            BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
            String line;

            csvReader.readLine();

            while((line = csvReader.readLine()) != null) {
                String[] data = line.split(";");
                int plantType = Integer.parseInt(data[0]);
                Color color = Color.decode(data[1]);
                float space = Float.parseFloat(data[2]);

                List<Integer> bloomingMonthNumbers = new ArrayList<>(12);

                for (String stringValue : data[3].split(",")) {
                    bloomingMonthNumbers.add(Integer.parseInt(stringValue));
                }

                boolean[] blooming = new boolean[12];
                for (Integer bloomingMonthNumber : bloomingMonthNumbers) {
                    blooming[bloomingMonthNumber - 1] = true;
                }

                flowers.add(new Flower(plantType, space, color, blooming));
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(2);
        }

        return flowers;
    }

    public static Map<Integer, Integer> readPlantAmounts(String fileName){
        Map<Integer, Integer> plantAmounts = new HashMap<>();

        try{
            BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
            String line;

            csvReader.readLine();

            while ((line = csvReader.readLine()) != null){
                String[] data = line.split(";");
                Integer plantType = Integer.parseInt(data[0]);
                Integer quantity = Integer.parseInt(data[1]);
                plantAmounts.put(plantType, quantity);
            }

        }catch (IOException e){
            e.printStackTrace();
            System.exit(2);
        }

        return plantAmounts;
    }
}
