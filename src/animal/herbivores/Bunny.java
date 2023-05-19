package animal.herbivores;

public class Bunny extends Herbivores{
    private static final double WEIGHT = 2.0;
    private static final int MAX_NUMBER_PER_CELL = 150;
    private static final int MOVEMENT_SPEED = 2;

    private static final double NEED_FOOD = 0.45;

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
