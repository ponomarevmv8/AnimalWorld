package animal;

import gui.Cell;
import gui.GameField;

import java.util.Random;

public abstract class Animal {

    private Cell cell;
    private int health = 100;

    public abstract void reproduce();

    public void movement(GameField gameField){
        int x = cell.getX();
        int y = cell.getY();
        int movementSpeed  = this.getMovementSpeed();
        int randomX = new Random().nextInt(movementSpeed*2 + 1) - movementSpeed;
        if((x + randomX) < 0) {
            randomX = -x;
        } else if ((x + randomX) > 9) {
            randomX = 9-x;
        }
        int randomY = (movementSpeed - Math.abs(randomX)) == 0 ? 0
                : new Random().nextInt((movementSpeed - Math.abs(randomX) )*2 + 1) - (movementSpeed - Math.abs(randomX));
        if((y + randomY) < 0) {
            randomY = -y;
        } else if ((y + randomY) > 9) {
            randomY = 9-y;
        }
        System.out.println("Координаты были " + x + ", " + y + "\nСтали " + (x+randomX) + ", " + (y + randomY));
        this.cell.removeAnimal(this);
        gameField.getGamefield()[x+randomX][randomY + y].addAnimal(this);

    }

    public abstract double getNeedFood();
    public abstract int getMovementSpeed();

    public int getHealth() {
        return health;
    }

    public void setHealth(double getFood) {
        double getHepth = (getFood * 100) / getNeedFood() ;
        this.health += (int) getHepth;
        System.out.println("Жизни составляют: " + health);
    }

    public abstract double getWeight();

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Cell getCell () {
        return cell;
    }



}
