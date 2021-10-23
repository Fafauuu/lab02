package model;

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
}
