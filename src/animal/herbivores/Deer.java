package animal.herbivores;

public class Deer extends Herbivores{
    private static final double WEIGHT = 300.0;
    private static final int MAX_NUMBER_PER_CELL = 20;
    private static final int MOVEMENT_SPEED = 4;

    private static final double NEED_FOOD = 50.0;

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

    @Override
    public int getMaxNumberPerCell() {
        return MAX_NUMBER_PER_CELL;
    }
}
