package service;

import animal.Animal;
import animal.Plants;
import animal.herbivores.Herbivores;
import animal.predators.Predators;
import gui.Cell;
import gui.GameField;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Service {
    private GameField gameField;
    private ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

    private int countCicleLife = 0;
    private boolean reproduce = false;

    private int countDrawField = 0;

    public Service(GameField gameField) {
        this.gameField = gameField;
    }
    public void startService(){

        //Жизненный цикл Животных
        Runnable circleOfLifeAnimal = new Runnable() {
            @Override
            public void run() {
                if(countCicleLife == 4) {
                    reproduce = true;
                } else if (countCicleLife > 4) {
                    countCicleLife = 0;
                    reproduce = false;
                }
                Cell[][] cells = gameField.getGamefield();
                for(int i = 0; i < cells.length; i++){
                    for(int j = 0; j < cells[0].length; j++) {
                        int cellX = i;
                        int cellY = j;
                        service.execute(new Runnable() {
                            @Override
                            public void run() {
                                if(reproduce) reproduceAnimal(cells[cellX][cellY]);
                                circleOfLife(cells[cellX][cellY].getPredatorsList(), cells[cellX][cellY].getHerbivoresList(), cells[cellX][cellY].getPlantsList());
                            }
                        });
                    }
                }
                countCicleLife ++;
            }
        };

        //Отрисовка поля
        Runnable drawField = new Runnable() {
            @Override
            public void run() {
                gameField.drawField();
                System.out.println("\n");
                if(countDrawField == 5) {
                    Logger.printStats();
                    countDrawField = 0;
                    System.out.println();
                } else countDrawField++;
            }
        };

        //Постепенное голодание животных
        Runnable starvation = new Runnable() {
            @Override
            public void run() {
                Cell[][] cells = gameField.getGamefield();
                for(int i = 0; i < cells.length; i++){
                    for(int j = 0; j < cells[0].length; j++) {
                        int cellX = i;
                        int cellY = j;
                        service.execute(new Runnable() {
                            @Override
                            public void run() {
                                starvationAnimal(cells[cellX][cellY].getPredatorsList(), cells[cellX][cellY].getHerbivoresList());
                            }
                        });
                    }
                }
            }
        };

        //Проверка вымирания животных
        Runnable checkAnimal = new Runnable() {
            @Override
            public void run() {
                Cell[][] cells = gameField.getGamefield();
                boolean isLife = false;
                for (int i = 0; i < cells.length; i++) {
                    for (int j = 0; j < cells[0].length; j++) {
                        if (!cells[i][j].getHerbivoresList().isEmpty() || !cells[i][j].getPredatorsList().isEmpty()){
                            isLife = true;
                            break;
                        }
                    }
                    if(isLife) break;
                }
                if (!isLife) {
                    System.out.println("Выключаем сервис");
                    service.shutdown();
                }
            }
        };

        //Рост травы
        Runnable plantGrowth = new Runnable() {
            @Override
            public void run() {
                int x = gameField.getGamefield().length;
                int y = gameField.getGamefield()[0].length;
                int numberCells = x*y;
                for (int i = 0; i < numberCells * 3 / 20; i++){
                    gameField.getGamefield()[new Random().nextInt(x)][new Random().nextInt(y)].addPlants(new Plants());
                    Logger.addCountPlantsGrown();
                }
            }
        };

        Runnable reproduce = new Runnable() {
            @Override
            public void run() {
                Cell[][] cells = gameField.getGamefield();
                for (int i = 0; i < cells.length; i++) {
                    for (int j = 0; j < cells[0].length; j++) {

                    }
                }
            }
        };

        Runnable stopService = new Runnable() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                String input;
                while (true){
                    input = scanner.nextLine();
                    if(input.equalsIgnoreCase("stop")){
                        service.shutdown();
                        break;
                    }
                }
            }
        };

        service.scheduleAtFixedRate(circleOfLifeAnimal, 0, 2, TimeUnit.SECONDS);

        service.scheduleAtFixedRate(drawField, 0, 3, TimeUnit.SECONDS);

        service.scheduleAtFixedRate(starvation, 3, 3, TimeUnit.SECONDS);

        service.scheduleAtFixedRate(plantGrowth, 0, 2, TimeUnit.SECONDS);

        service.scheduleAtFixedRate(checkAnimal, 5, 5, TimeUnit.SECONDS);

        service.execute(stopService);
    }

    private void circleOfLife(List<Predators> predatorsList, List<Herbivores> herbivoresList, List<Plants> plantsList) {
        for(Predators predators : predatorsList) {
            if(checkHealth(predators)) {
                predators.movement(gameField);
            } else {
                boolean isEat = false;
                for(Herbivores herbivores : herbivoresList) {
                    if(predators.eat(herbivores)) {
                        isEat = true;
                        herbivores.getCell().removeAnimal(herbivores);
                        Logger.addCountEatHerbivores();
                        break;
                    }
                }
                if(!isEat && herbivoresList.isEmpty()){
                    predators.movement(gameField);
                }
            }
        }
        for(Herbivores herbivores : herbivoresList) {
            if(checkHealth(herbivores)) {
                herbivores.movement(gameField);
            } else {
                if(!plantsList.isEmpty()) {
                    herbivores.eat(plantsList.get(0));
                    plantsList.remove(0);
                    Logger.addCountEatPlants();
                    Logger.downCountPlants();
                } else {
                    herbivores.movement(gameField);
                }
            }
        }
    }

    private boolean checkHealth(Animal animal) {
      return animal.getHealth() > 80;
    }

    private void starvationAnimal(List<Predators> predatorsList, List<Herbivores> herbivoresList) {
        predatorsList.forEach(x -> x.setHealth(-x.getNeedFood()/10));
        herbivoresList.forEach(x-> x.setHealth(-x.getNeedFood()/10));
    }

    private void reproduceAnimal(Cell cell) {
        for(String str : cell.getAnimalForReproduce()){
            String animal[] = str.split(" ");
            boolean findAnimal = false;
            for(Predators predators : cell.getPredatorsList()) {
                if(predators.getClass().getSimpleName().equals(animal[0])) {
                    for(int i = 0; i < Integer.parseInt(animal[1]); i++) {
                        predators.reproduce();
                        Logger.addCountPredatorsBorn();
                    }
                    findAnimal = true;
                    break;
                }
            }
            if(!findAnimal) {
                for (Herbivores herbivores : cell.getHerbivoresList()) {
                    if(herbivores.getClass().getSimpleName().equals(animal[0])) {
                        for(int i = 0; i < Integer.parseInt(animal[1]); i++) {
                            herbivores.reproduce();
                            Logger.addCountHerbivoresBorn();
                        }
                    }
                }
            }
        }
    }
}
