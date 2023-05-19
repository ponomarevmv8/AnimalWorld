package animal.herbivores;

import animal.Plants;

public class Mouse extends Herbivores{
    private static final double WEIGHT = 0.05;
    private static final int MAX_NUMBER_PER_CELL = 500;
    private static final int MOVEMENT_SPEED = 1;

    private static final double NEED_FOOD = 0.01;

    @Override
    public void reproduce() {

    }

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
}
