package animal.herbivores;

public class Buffalo extends Herbivores{
    private static final double WEIGHT = 700.0;
    private static final int MAX_NUMBER_PER_CELL = 10;
    private static final int MOVEMENT_SPEED = 3;

    private static final double NEED_FOOD = 100.0;

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
