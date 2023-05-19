package animal.predators;

public class Fox extends Predators{
    private static final double WEIGHT = 8.0;
    private static final int MAX_NUMBER_PER_CELL = 30;
    private static final int MOVEMENT_SPEED = 2;

    private static final double NEED_FOOD = 2.0;


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
