package animal.herbivores;

import animal.Animal;
import animal.Plants;

public abstract class Herbivores extends Animal {
    public synchronized boolean eat(Plants plants){
        this.setHealth(plants.getWeight());
        return true;
    }


}
