package animal.herbivores;

import animal.ChanceToEat;

import java.util.List;
import java.util.Random;

public class Boar extends Herbivores{
    private static final double WEIGHT = 400.0;
    private static final int MAX_NUMBER_PER_CELL = 50;
    private static final int MOVEMENT_SPEED = 2;

    private static final double NEED_FOOD = 50.0;


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

    public boolean eat(Herbivores herbivores) {
        if(herbivores == null) {
            return false;
        }
        ChanceToEat chance = ChanceToEat.BOAR;
        int numberChance = getChance(herbivores.getClass().getSimpleName(), chance.getChance());
        if(isEat(numberChance)) {
            this.setHealth(herbivores.getWeight());
            return true;
        }
        return false;
    }

    private int getChance(String className, List<String> chance) {
        int numberChance = 0;
        for(String str : chance) {
            int index= str.indexOf('=');
            if(className.equals(str.substring(0, index))) {
                numberChance = Integer.parseInt( str.substring(index+1));
            }
        }
        return numberChance;
    }

    private boolean isEat(int numberChance){
        int randomChance = new Random().nextInt(100) + 1;
        return randomChance <= numberChance;
    }
}
