package animal.herbivores;

import animal.Plants;
import service.Logger;

public class Caterpillar extends Herbivores{
    private static final double WEIGHT = 0.01;
    private static final int MAX_NUMBER_PER_CELL = 1000;
    private static final int MOVEMENT_SPEED = 0;

    private static final double NEED_FOOD = 0.0;


    @Override
    public double getNeedFood() {
        return NEED_FOOD;
    }

    @Override
    public int getMovementSpeed() {
        return MOVEMENT_SPEED;
    }

    @Override
    public double getWeight() {
        return WEIGHT;
    }

    @Override
    public int getMaxNumberPerCell() {
        return MAX_NUMBER_PER_CELL;
    }

    @Override
    public boolean eat(Plants plants) {
        return false;
    }

    @Override
    public void setHealth(double getFood) {
        return;
    }
}
