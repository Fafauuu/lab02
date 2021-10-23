package model;

import java.util.ArrayList;
import java.util.List;

public class Border {
    private final int borderNumber;
    private final float area;
    private final List<FlowerBox> flowerBoxes = new ArrayList<>();

    public Border(int id, float area) {
        this.borderNumber = id;
        this.area = area;
    }

    public int getBorderNumber() {
        return borderNumber;
    }

    public float getArea() {
        return area;
    }

    public List<FlowerBox> getFlowerBoxes() {
        return flowerBoxes;
    }

    public void addFlowerBox(FlowerBox flowerBox){
        flowerBoxes.add(flowerBox);
    }
}
