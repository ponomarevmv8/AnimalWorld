package animal.herbivores;

public class Sheep extends Herbivores{
    private static final double WEIGHT = 70.0;
        private static final int MAX_NUMBER_PER_CELL = 140;
    private static final int MOVEMENT_SPEED = 3;

    private static final double NEED_FOOD = 15.0;


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
