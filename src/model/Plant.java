package model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return plantType == plant.plantType && Float.compare(plant.space, space) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(plantType, space);
    }
}
