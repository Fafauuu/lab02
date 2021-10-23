package controller;

import model.Flower;
import model.FlowerBox;
import model.Storage;

import java.util.List;

public class FlowerBoxCombinationGenerator {
    private Storage storage;

    public FlowerBoxCombinationGenerator(Storage storage) {
        this.storage = storage;
    }

    public List<FlowerBox> generate(Flower flower){
        int flowerAmount = storage.getPlantAmounts().get(flower.getPlantType());

        return null;
    }
}
