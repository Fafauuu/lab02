package model;

import java.util.List;

public class SingleFlowerBoxesPackage {
    private List<FlowerBox> flowerBoxes;

    public SingleFlowerBoxesPackage(List<FlowerBox> flowerBoxes) {
        this.flowerBoxes = flowerBoxes;
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
    public String toString() {
        return flowerBoxes +
                ";";
    }
}
