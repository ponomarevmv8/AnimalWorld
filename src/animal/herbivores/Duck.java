package animal.herbivores;

public class Duck extends Herbivores{
    private static final double WEIGHT = 1.0;
    private static final int MAX_NUMBER_PER_CELL = 200;
    private static final int MOVEMENT_SPEED = 4;

    private static final double NEED_FOOD = 0.15;

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
