package animal;

import animal.herbivores.Herbivores;
import gui.Cell;
import gui.GameField;
import service.Logger;

import java.util.Random;

public abstract class Animal {

    private Cell cell;
    private int health = 100;

    public void reproduce(){
        try {
            Animal animal = this.getClass().newInstance();
            this.getCell().addAnimal(animal);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void movement(GameField gameField){
        int x = cell.getX();
        int y = cell.getY();
        int movementSpeed  = this.getMovementSpeed();
        int randomX = new Random().nextInt(movementSpeed*2 + 1) - movementSpeed;
        if((x + randomX) < 0) {
            randomX = -x;
        } else if ((x + randomX) > gameField.getGamefield().length - 1) {
            randomX = gameField.getGamefield().length - 1 - x;
        }
        int randomY = (movementSpeed - Math.abs(randomX)) == 0 ? 0
                : new Random().nextInt((movementSpeed - Math.abs(randomX) )*2 + 1) - (movementSpeed - Math.abs(randomX));
        if((y + randomY) < 0) {
            randomY = -y;
        } else if ((y + randomY) > gameField.getGamefield()[0].length - 1) {
            randomY = gameField.getGamefield()[0].length - 1 - y;
        }
        this.cell.removeAnimal(this);
        gameField.getGamefield()[x+randomX][randomY + y].addAnimal(this);

    }

    public abstract double getNeedFood();
    public abstract int getMovementSpeed();

    public int getHealth() {
        return health;
    }

    public synchronized void setHealth(double getFood) {
        double getHepth = (getFood * 100) / getNeedFood() ;
        this.health += (int) getHepth;
        if(health < 0) {
            cell.removeAnimal(this);
            if (this instanceof Herbivores) {
                Logger.addCountDeadHerbivores();
            } else {
                Logger.addCountDeadPredators();
            }
        } else if (health > 100) {
            health = 100;
        }
    }

    public abstract double getWeight();

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Cell getCell () {
        return cell;
    }



}
