package gui;

import animal.Animal;
import animal.Plants;
import animal.herbivores.Herbivores;
import animal.predators.Predators;

import java.util.*;
import java.util.stream.Collectors;

public class Cell {
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int x;
    private int y;

    private Map<String, Integer> countAnimal = new HashMap<>();

    public List<Herbivores> getHerbivoresList() {
        return herbivoresList;
    }

    public List<Predators> getPredatorsList() {
        return predatorsList;
    }

    public List<Plants> getPlantsList() {
        return plantsList;
    }

    private List<Herbivores> herbivoresList = new ArrayList<>();

    private List<Predators> predatorsList = new ArrayList<>();

    private List<Plants> plantsList = new ArrayList<>();

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized void drawCell() {
        cleanNull();
        if(!herbivoresList.isEmpty() || !predatorsList.isEmpty()) {
            for(String str : countAnimal.keySet()) {
                switch (str) {
                    case "Boar":
                        System.out.print("🐗");
                        break;
                    case "Buffalo":
                        System.out.print("\uD83D\uDC03");
                        break;
                    case "Bunny":
                        System.out.print("\uD83D\uDC07");
                        break;
                    case "Caterpillar":
                        System.out.print("\uD83D\uDC1B");
                        break;
                    case "Deer":
                        System.out.print("\uD83E\uDD8C");
                        break;
                    case "Goat":
                        System.out.print("\uD83D\uDC10");
                        break;
                    case "Horse":
                        System.out.print("\uD83D\uDC0E");
                        break;
                    case "Mouse":
                        System.out.print("\uD83D\uDC01");
                        break;
                    case "Sheep":
                        System.out.print("\uD83D\uDC11");
                        break;
                    case "Bear" :
                        System.out.print("\uD83D\uDC3B");
                        break;
                    case "Boa" :
                        System.out.print("\uD83D\uDC0D");
                        break;
                    case "Eagle" :
                        System.out.print("\uD83E\uDD85");
                        break;
                    case "Fox" :
                        System.out.print("\uD83E\uDD8A");
                        break;
                    case "Wolf" :
                        System.out.print("\uD83D\uDC3A");
                        break;
                }
            }
        }
        if(!plantsList.isEmpty()) {
            System.out.print("\uD83C\uDF31");
        }
        if(herbivoresList.isEmpty() && plantsList.isEmpty() && predatorsList.isEmpty()){
            System.out.print("|*|");
        }
    }

    public synchronized void addAnimal(Animal animal) {
        String nameClass = animal.getClass().getSimpleName();
        if(countAnimal.containsKey(nameClass)) {
            Integer count = countAnimal.get(nameClass);
            count += 1;
            countAnimal.put(nameClass, count);
        } else {
            countAnimal.put(nameClass, 1);
        }
        if(animal instanceof Herbivores) {
            herbivoresList.add((Herbivores) animal);
            animal.setCell(this);
        } else {
            predatorsList.add((Predators) animal);
            animal.setCell(this);
        }
    }

    public synchronized void addPlants(Plants plants) {
        plantsList.add(plants);
    }

    private void cleanNull(){
        herbivoresList.stream().filter(herbivores -> herbivores != null).collect(Collectors.toList());
        predatorsList.stream().filter(predators -> predators != null).collect(Collectors.toList());
        plantsList.stream().filter(plants -> plants != null).collect(Collectors.toList());
    }

    public synchronized void removeAnimal(Animal animal) {
        String nameClass = animal.getClass().getSimpleName();
        if(animal instanceof Herbivores) {
            herbivoresList.remove(animal);
        } else {
            predatorsList.remove(animal);
        }
        Integer count = countAnimal.get(nameClass);
        if(count > 1) {
            count -= 1;
            countAnimal.put(nameClass, count);
        } else {
            countAnimal.remove(nameClass);
        }
    }

}
