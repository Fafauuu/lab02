package model;

public abstract class Plant {
    private final int plantType;
    private final float space;

    public Plant(int plantType, float space) {
        this.plantType = plantType;
        this.space = space;
    }

    public int getPlantType() {
        return plantType;
    }

    public float getSpace() {
        return space;
    }
}
