package animal;

import gui.Cell;

public abstract class Animal {

    private Cell cell;
    private int health = 100;

    public abstract void reproduce();

    public abstract void movement();

    public abstract double getNeedFood();

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
