package service;

import animal.Animal;
import animal.Plants;
import animal.herbivores.Herbivores;
import animal.predators.Predators;
import gui.Cell;
import gui.GameField;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Service {
    private GameField gameField;
    private ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

    public Service(GameField gameField) {
        this.gameField = gameField;
    }
    public void startService(){

        //Жизненный цикл Животных
        Runnable circleOfLifeAnimal = new Runnable() {
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
                                circleOfLife(cells[cellX][cellY].getPredatorsList(), cells[cellX][cellY].getHerbivoresList(), cells[cellX][cellY].getPlantsList());
                            }
                        });
                    }
                }
            }
        };

        //Отрисовка поля
        Runnable drawField = new Runnable() {
            @Override
            public void run() {
                gameField.drawField();
                System.out.println("\n");
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
                int numberCells = gameField.getGamefield().length * gameField.getGamefield()[0].length;
                for (int i = 0; i < numberCells * 3 / 20; i++){
                    gameField.getGamefield()[new Random().nextInt(10)][new Random().nextInt(10)].addPlants(new Plants());
                }
            }
        };

        service.scheduleAtFixedRate(circleOfLifeAnimal, 0, 2, TimeUnit.SECONDS);

        service.scheduleAtFixedRate(drawField, 0, 3, TimeUnit.SECONDS);

        service.scheduleAtFixedRate(starvation, 3, 3, TimeUnit.SECONDS);

        service.scheduleAtFixedRate(plantGrowth, 0, 2, TimeUnit.SECONDS);

        service.scheduleAtFixedRate(checkAnimal, 5, 5, TimeUnit.SECONDS);


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

}
