package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class FlowerBoxesCombinationList {
    private List<FlowerBox> flowerBoxes;

    public FlowerBoxesCombinationList(List<FlowerBox> flowerBoxes) {
        //TODO Sort method
        this.flowerBoxes = flowerBoxes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlowerBoxesCombinationList boxListCompared = (FlowerBoxesCombinationList) o;
        List<FlowerBox> flowerBoxesCompared = boxListCompared.getFlowerBoxes();

        if (flowerBoxes.size() != flowerBoxesCompared.size()) return false;

//        for (FlowerBox flowerBox : flowerBoxes) {
//            if (!(flowerBoxesCompared.contains(flowerBox))) return false;
//
//        }
        for (int i = 0; i < flowerBoxes.size(); i++) {
            if (!(flowerBoxes.get(i).equals(flowerBoxesCompared.get(i)))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowerBoxes);
    }

    public List<FlowerBox> getFlowerBoxes() {
        return flowerBoxes;
    }
}
