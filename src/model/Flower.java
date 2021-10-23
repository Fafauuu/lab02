package model;

import java.awt.*;

public class Flower extends Plant{
    private final Color color;
    private final boolean[] blooming;

    public Flower(int plantType, float space, Color color, boolean[] blooming) {
        super(plantType, space);
        this.color = color;
        this.blooming = blooming;
    }

    public Color getColor() {
        return color;
    }

    public boolean[] getBlooming() {
        return blooming;
    }
}
