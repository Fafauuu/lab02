package model;

import java.util.List;
import java.util.Objects;

public class FlowerBoxesCombination {
    private List<FlowerBox> flowerBoxes;

    public FlowerBoxesCombination(List<FlowerBox> flowerBoxes) {
        this.flowerBoxes = flowerBoxes;
        sortBoxesCombination();
    }

    private void sortBoxesCombination() {
        flowerBoxes.sort((o1, o2) -> {
            if (o1.getFlower().getPlantType() > o2.getFlower().getPlantType()) return 1;
            else if (o1.getFlower().getPlantType() < o2.getFlower().getPlantType()) return -1;
            else {
                if (o1.getQuantity() < o2.getQuantity()) return 1;
                else if (o1.getQuantity() > o2.getQuantity()) return -1;
                else return 0;
            }
        });
    }

    public void soutList(){
        System.out.println("boxes contained: " + flowerBoxes.size());
        for (FlowerBox flowerBox : flowerBoxes) {
            System.out.println("flower type contained: "
                    + flowerBox.getFlower().getPlantType()
                    + " quantity: " + flowerBox.getQuantity());
        }
        System.out.println();
    }

    public List<FlowerBox> getFlowerBoxes() {
        return flowerBoxes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlowerBoxesCombination boxListCompared = (FlowerBoxesCombination) o;
        List<FlowerBox> flowerBoxesCompared = boxListCompared.getFlowerBoxes();

        if (flowerBoxes.size() != flowerBoxesCompared.size()) return false;

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

    @Override
    public String toString() {
        return "FlowerBoxesCombination{" +
                "flowerBoxes=" + flowerBoxes +
                '}';
    }
}
