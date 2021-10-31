package model;

import java.util.Objects;

public class FlowerBox {
    private final Flower flower;
    private final int quantity;
    private final float spaceRequired;

    public FlowerBox(Flower flower, int quantity) {
        this.flower = flower;
        this.quantity = quantity;
        this.spaceRequired = flower.getSpace() * quantity;
    }

    public Flower getFlower() {
        return flower;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getSpaceRequired() {
        return spaceRequired;
    }

    @Override
    public String toString() {
        return flower.getPlantType() +
                "," + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlowerBox flowerBox = (FlowerBox) o;
        return this.flower == flowerBox.getFlower() && this.quantity == flowerBox.getQuantity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(flower, quantity);
    }
}
