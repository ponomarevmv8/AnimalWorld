package service;

public class Logger {
    private static int countHerbivores = 0;
    private static int countPredators = 0;
    private static int countPlants = 0;

    private static int countEatHerbivores = 0;
    private static int countEatPlants = 0;
    private static int countDeadPredators = 0;

    private static int countDeadHerbivores = 0;

    private static int countHerbivoresBorn = 0;

    private static int countPredatorsBorn = 0;

    private static int countPlantsGrown = 0;

    public synchronized static void addCountHerbivores() {
        Logger.countHerbivores += 1;
    }

    public synchronized static void downCountHerbivores() {
        Logger.countHerbivores -= 1;
    }

    public synchronized static void addCountPredators() {
        Logger.countPredators += 1;
    }

    public synchronized static void downCountPredators() {
        Logger.countPredators -= 1;
    }

    public synchronized static void addCountPlants() {
        Logger.countPlants += 1;
    }

    public synchronized static void downCountPlants() {
        Logger.countPlants -= 1;
    }

    public synchronized static void addCountEatHerbivores() {
        Logger.countEatHerbivores += 1;
    }

    public synchronized static void addCountEatPlants() {
        Logger.countEatPlants += 1;
    }

    public synchronized static void addCountDeadPredators() {
        Logger.countDeadPredators += 1;
    }

    public synchronized static void addCountDeadHerbivores() {
        Logger.countDeadHerbivores += 1;
    }

    public synchronized static void addCountHerbivoresBorn() {
        Logger.countHerbivoresBorn += 1;
    }

    public synchronized static void addCountPredatorsBorn() {
        Logger.countPredatorsBorn += 1;
    }

    public synchronized static void addCountPlantsGrown() {
        Logger.countPlantsGrown += 1;
    }

    public synchronized static void printStats(){
        System.out.println("Статистика по острову.......");
        System.out.println("Всего хищников: "  + countPredators);
        System.out.println("Всего травоядных: " + countHerbivores);
        System.out.println("Всего растений: " + countPlants);
        System.out.println("За время существование системы было....");
        System.out.println("Съедено травоядных: " +countEatHerbivores);
        System.out.println("Съедено растений: " + countEatPlants);
        System.out.println("Умерло хищников:" + countDeadPredators);
        System.out.println("Умерло травоядных:" + countDeadHerbivores);
        System.out.println("Рожденно хищников: " + countPredatorsBorn);
        System.out.println("Рожденно травойдных: " + countHerbivoresBorn);
        System.out.println("И выросло растений: " + countPlantsGrown);
    }
}
