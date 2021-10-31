package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Border {
    private final int borderNumber;
    private final float area;
    private float areaLeft;
    private List<FlowerBox> flowerBoxes;
    private boolean empty;

    public Border(int id, float area) {
        this.borderNumber = id;
        this.area = area;
        this.areaLeft = area;
        this.flowerBoxes = new ArrayList<>();
        this.empty = true;
    }

    public boolean isBloomingEveryMonth() {
        for (int i = 0; i < 12; i++) {
            boolean bloomsThisMonth = false;
            for (FlowerBox flowerBox : flowerBoxes) {
                boolean[] bloomingMonths = flowerBox.getFlower().getBlooming();
                if (bloomingMonths[i]) {
                    bloomsThisMonth = true;
                    break;
                }
            }
            if (!bloomsThisMonth) return false;
        }
        return true;
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

    public void addFlowerBox(FlowerBox flowerBox) {
        for (FlowerBox box : flowerBoxes) {
            if (flowerBox.getFlower().getPlantType() == box.getFlower().getPlantType()) return;
        }
        if (flowerBox.getSpaceRequired()/10000 > areaLeft) return;

        flowerBoxes.add(flowerBox);
        empty = false;
        areaLeft -= flowerBox.getSpaceRequired()/10000;
    }

    public boolean isEmpty() {
        return empty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Border border = (Border) o;
        return borderNumber == border.borderNumber && Objects.equals(flowerBoxes, border.flowerBoxes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(borderNumber, flowerBoxes);
    }

    @Override
    public String toString() {
        return "{borderNumber=" + borderNumber +
                ", flowerBoxes=" + flowerBoxes +
                '}';
    }
}
