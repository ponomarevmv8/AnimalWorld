package animal.herbivores;

public class Caterpillar extends Herbivores{
    private static final double WEIGHT = 0.01;
    private static final int MAX_NUMBER_PER_CELL = 1000;
    private static final int MOVEMENT_SPEED = 0;

    private static final double NEED_FOOD = 0.0;

    @Override
    public void reproduce() {

    }

    @Override
    public void movement() {

    }

    @Override
    public double getNeedFood() {
        return NEED_FOOD;
    }

    @Override
    public double getWeight() {
        return WEIGHT;
    }
}
