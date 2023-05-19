package animal.predators;

public class Eagle extends Predators{
    private static final double WEIGHT = 6.0;
    private static final int MAX_NUMBER_PER_CELL = 20;
    private static final int MOVEMENT_SPEED = 3;

    private static final double NEED_FOOD = 1.0;

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
