package animal.predators;

import animal.Animal;
import animal.ChanceToEat;
import animal.herbivores.Herbivores;

import java.util.List;
import java.util.Random;

public abstract class Predators extends Animal {

    public synchronized boolean eat(Herbivores herbivores) {
        if(herbivores == null) {
            return false;
        }
        ChanceToEat chance = getPredators(this.getClass().getSimpleName());
        if (chance != null) {
            int numberChance = getChance(herbivores.getClass().getSimpleName(), chance.getChance());
            if(isEat(numberChance)) {
                this.setHealth(herbivores.getWeight());
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    private ChanceToEat getPredators(String className){
        ChanceToEat chance = switch (className) {
            case "Bear" : yield ChanceToEat.BEAR;
            case "Boa" : yield  ChanceToEat.BOA;
            case "Eagle" : yield ChanceToEat.EAGLE;
            case "Fox" : yield ChanceToEat.FOX;
            case "Wolf" : yield ChanceToEat.WOLF;
            default:
                yield null;
        };
        return chance;
    }

    private int getChance(String className, List<String> chance) {
        int numberChance = 0;
        for(String str : chance) {
            int index = str.indexOf('=');
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
