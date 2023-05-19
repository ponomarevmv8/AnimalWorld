import animal.Animal;
import animal.Plants;
import animal.herbivores.*;
import animal.predators.*;
import gui.Cell;
import gui.GameField;

public class Main {
    public static void main(String[] args) {
//        Predators predators = new Bear();
//        Predators predators1 = new Bear();
//        Herbivores herbivores = new Bunny();
//        Plants plants = new Plants();
//        System.out.println("Жизни зайца: " + herbivores.getHealth());
//        plants = herbivores.eat(plants);
//        System.out.println("Жизни зайца после еды: " + herbivores.getHealth());
//        herbivores = predators1.eat(herbivores);
//        herbivores = predators.eat(herbivores);
//        System.out.println("Жизни первого мишки: " + predators.getHealth());
//        System.out.println("Жизни второго мишки: " + predators1.getHealth());
//        System.out.println(herbivores == null ? "Заяйца нет" : (herbivores.getClass().getSimpleName() + " Убежал"));

        GameField gameField = new GameField(10, 10);
        Cell[][] cells = gameField.getGamefield();
        Herbivores herbivores = new Mouse();
        Herbivores herbivores1 = new Horse();
        Herbivores herbivores2 = new Bunny();
        Predators animal = new Bear();
        cells[2][4].addAnimal(herbivores);
        cells[2][4].addAnimal(herbivores1);
        cells[5][2].addAnimal(herbivores2);
        cells[5][2].addAnimal(animal);
        gameField.drawField();
        System.out.println();
        System.out.println("Координаты медведя: X=" + animal.getCell().getX() + ", Y=" + animal.getCell().getY());

        while (true) {
            animal.movement(gameField);
//        if(animal.eat(herbivores2)) {
//            cells[5][2].removeAnimal(herbivores2);
//            gameField.drawField();
//        }
            gameField.drawField();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}