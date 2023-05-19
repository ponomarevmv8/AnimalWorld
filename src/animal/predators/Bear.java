package animal.predators;

import animal.ChanceToEat;
public class Bear extends Predators{
    private static final double WEIGHT = 500.0;

    private static final int MAX_NUMBER_PER_CELL = 5;
    private static final int MOVEMENT_SPEED = 2;
    private ChanceToEat chanceToEat = ChanceToEat.BEAR;
    private static final double NEED_FOOD = 80.0;


    @Override
    public void reproduce() {

    }

    @Override
    public void movement() {

    }
    public double getNeedFood() {
        return NEED_FOOD;
    }

    @Override
    public double getWeight() {
        return WEIGHT;
    }
}
