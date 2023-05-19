package animal.predators;

public class Wolf extends Predators{

    private static final double WEIGHT = 50.0;
    private static final int MAX_NUMBER_PER_CELL = 30;
    private static final int MOVEMENT_SPEED = 3;

    private static final double NEED_FOOD = 8.0;

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
