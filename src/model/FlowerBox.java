package model;

import java.util.Objects;

public class FlowerBox {
    private Flower flower;
    private int quantity;

    public FlowerBox(Flower flower, int quantity) {
        this.flower = flower;
        this.quantity = quantity;
    }

    public Flower getFlower() {
        return flower;
    }

    public int getQuantity() {
        return quantity;
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
