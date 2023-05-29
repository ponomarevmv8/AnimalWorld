package service;

import animal.Animal;
import animal.Plants;
import animal.herbivores.*;
import animal.predators.*;
import gui.Cell;
import gui.GameField;

import java.util.Random;

public class StartProgram {
    public static void startProgram() {
        GameField gameField = new GameField(PropertiesUtil.getMatrixX(), PropertiesUtil.getMatrixY());
        Cell[][] cells = gameField.getGamefield();
        addAnimal(cells);
        addSpecificAnimal(cells);
        Service service = new Service(gameField);
        service.startService();
    }

    private static void addAnimal(Cell[][] cells){
        int predators = PropertiesUtil.getPredators();
        if(predators != 0) {
            for (int i = 0; i < predators; i++) {
                cells[new Random().nextInt(PropertiesUtil.getMatrixX())][new Random().nextInt(PropertiesUtil.getMatrixY())].addAnimal(getRandomPredators());
            }
        }
        if(PropertiesUtil.getHerbivores() != 0) {
            for (int i = 0; i < PropertiesUtil.getHerbivores(); i++) {
                cells[new Random().nextInt(PropertiesUtil.getMatrixX())][new Random().nextInt(PropertiesUtil.getMatrixY())].addAnimal(getRandomHerbivores());
            }
        }
        if(PropertiesUtil.getPlants() != 0) {
            for (int i = 0; i < PropertiesUtil.getHerbivores(); i++) {
                cells[new Random().nextInt(PropertiesUtil.getMatrixX())][new Random().nextInt(PropertiesUtil.getMatrixY())].addPlants(new Plants());
            }
        }
    }

    private static Animal getRandomPredators(){
      return switch (new Random().nextInt(5)) {
          case 0 -> new Bear();
          case 1 -> new Boa();
          case 2 -> new Eagle();
          case 3 -> new Fox();
          case 4 -> new Wolf();
          default -> null;
      };
    }

    private static Animal getRandomHerbivores(){
        return switch (new Random().nextInt(10)) {
            case 0 -> new Boar();
            case 1 -> new Buffalo();
            case 2 -> new Bunny();
            case 3 -> new Sheep();
            case 4 -> new Caterpillar();
            case 5 -> new Deer();
            case 6 -> new Duck();
            case 7 -> new Goat();
            case 8 -> new Horse();
            case 9 -> new Mouse();
            default -> null;
        };
    }

    private static void addSpecificAnimal(Cell[][] cells) {
        if(PropertiesUtil.getBoar()!=0) {
            for(int i = 0; i < PropertiesUtil.getBoar(); i++) {
                cells[new Random().nextInt(PropertiesUtil.getMatrixX())][new Random().nextInt(PropertiesUtil.getMatrixY())].addAnimal(new Boar());
            }
        }
        if(PropertiesUtil.getBuffalo()!=0) {
            for(int i = 0; i < PropertiesUtil.getBuffalo(); i++) {
                cells[new Random().nextInt(PropertiesUtil.getMatrixX())][new Random().nextInt(PropertiesUtil.getMatrixY())].addAnimal(new Buffalo());
            }
        }
        if(PropertiesUtil.getBunny()!=0) {
            for(int i = 0; i < PropertiesUtil.getBunny(); i++) {
                cells[new Random().nextInt(PropertiesUtil.getMatrixX())][new Random().nextInt(PropertiesUtil.getMatrixY())].addAnimal(new Bunny());
            }
        }
        if(PropertiesUtil.getCaterpillar()!=0) {
            for(int i = 0; i < PropertiesUtil.getCaterpillar(); i++) {
                cells[new Random().nextInt(PropertiesUtil.getMatrixX())][new Random().nextInt(PropertiesUtil.getMatrixY())].addAnimal(new Caterpillar());
            }
        }
        if(PropertiesUtil.getDeer()!=0) {
            for(int i = 0; i < PropertiesUtil.getDeer(); i++) {
                cells[new Random().nextInt(PropertiesUtil.getMatrixX())][new Random().nextInt(PropertiesUtil.getMatrixY())].addAnimal(new Deer());
            }
        }
        if(PropertiesUtil.getDuck()!=0) {
            for(int i = 0; i < PropertiesUtil.getDuck(); i++) {
                cells[new Random().nextInt(PropertiesUtil.getMatrixX())][new Random().nextInt(PropertiesUtil.getMatrixY())].addAnimal(new Duck());
            }
        }
        if(PropertiesUtil.getGoat()!=0) {
            for(int i = 0; i < PropertiesUtil.getGoat(); i++) {
                cells[new Random().nextInt(PropertiesUtil.getMatrixX())][new Random().nextInt(PropertiesUtil.getMatrixY())].addAnimal(new Goat());
            }
        }
        if(PropertiesUtil.getHorse()!=0) {
            for(int i = 0; i < PropertiesUtil.getHorse(); i++) {
                cells[new Random().nextInt(PropertiesUtil.getMatrixX())][new Random().nextInt(PropertiesUtil.getMatrixY())].addAnimal(new Horse());
            }
        }
        if(PropertiesUtil.getMouse()!=0) {
            for(int i = 0; i < PropertiesUtil.getMouse(); i++) {
                cells[new Random().nextInt(PropertiesUtil.getMatrixX())][new Random().nextInt(PropertiesUtil.getMatrixY())].addAnimal(new Mouse());
            }
        }
        if(PropertiesUtil.getSheep()!=0) {
            for(int i = 0; i < PropertiesUtil.getSheep(); i++) {
                cells[new Random().nextInt(PropertiesUtil.getMatrixX())][new Random().nextInt(PropertiesUtil.getMatrixY())].addAnimal(new Sheep());
            }
        }
        if(PropertiesUtil.getBear()!=0) {
            for(int i = 0; i < PropertiesUtil.getBear(); i++) {
                cells[new Random().nextInt(PropertiesUtil.getMatrixX())][new Random().nextInt(PropertiesUtil.getMatrixY())].addAnimal(new Bear());
            }
        }
        if(PropertiesUtil.getBoa()!=0) {
            for(int i = 0; i < PropertiesUtil.getBoa(); i++) {
                cells[new Random().nextInt(PropertiesUtil.getMatrixX())][new Random().nextInt(PropertiesUtil.getMatrixY())].addAnimal(new Boa());
            }
        }
        if(PropertiesUtil.getEagle()!=0) {
            for(int i = 0; i < PropertiesUtil.getEagle(); i++) {
                cells[new Random().nextInt(PropertiesUtil.getMatrixX())][new Random().nextInt(PropertiesUtil.getMatrixY())].addAnimal(new Eagle());
            }
        }
        if(PropertiesUtil.getFox()!=0) {
            for(int i = 0; i < PropertiesUtil.getFox(); i++) {
                cells[new Random().nextInt(PropertiesUtil.getMatrixX())][new Random().nextInt(PropertiesUtil.getMatrixY())].addAnimal(new Fox());
            }
        }
        if(PropertiesUtil.getWolf()!=0) {
            for(int i = 0; i < PropertiesUtil.getWolf(); i++) {
                cells[new Random().nextInt(PropertiesUtil.getMatrixX())][new Random().nextInt(PropertiesUtil.getMatrixY())].addAnimal(new Wolf());
            }
        }
    }


}
