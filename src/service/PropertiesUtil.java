package service;

import com.sun.tools.javac.Main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private static Properties prop = new Properties();

    static {
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("service/props.yaml")) {

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }

            prop.load(input);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getMatrixX() {
        String str = prop.getProperty("matrix_x");
        return str != null ? Integer.parseInt(str) : 0;
    }

    public static int getMatrixY() {
        String str = prop.getProperty("matrix_y");
        return str != null ? Integer.parseInt(str) : 0;
    }

    public static int getHerbivores() {
        String str = prop.getProperty("Herbivores");
        return str != null ? Integer.parseInt(str) : 0;
    }

    public static int getPredators() {
        String str = prop.getProperty("Predators");
        return str != null ? Integer.parseInt(str) : 0;
    }

    public static int getPlants() {
        String str = prop.getProperty("Plants");
        return str != null ? Integer.parseInt(str) : 0;
    }

    //
    public static int getBoar() {
        String str = prop.getProperty("Boar");
        return str != null ? Integer.parseInt(str) : 0;
    }

    public static int getBuffalo() {
        String str = prop.getProperty("Buffalo");
        return str != null ? Integer.parseInt(str) : 0;
    }

    public static int getBunny() {
        String str = prop.getProperty("Bunny");
        return str != null ? Integer.parseInt(str) : 0;
    }

    public static int getCaterpillar() {
        String str = prop.getProperty("Caterpillar");
        return str != null ? Integer.parseInt(str) : 0;
    }

    public static int getDeer() {
        String str = prop.getProperty("Deer");
        return str != null ? Integer.parseInt(str) : 0;
    }

    public static int getDuck() {
        String str = prop.getProperty("Duck");
        return str != null ? Integer.parseInt(str) : 0;
    }

    public static int getGoat() {
        String str = prop.getProperty("Goat");
        return str != null ? Integer.parseInt(str) : 0;
    }

    public static int getHorse() {
        String str = prop.getProperty("Horse");
        return str != null ? Integer.parseInt(str) : 0;
    }

    public static int getMouse() {
        String str = prop.getProperty("Mouse");
        return str != null ? Integer.parseInt(str) : 0;
    }

    public static int getSheep() {
        String str = prop.getProperty("Sheep");
        return str != null ? Integer.parseInt(str) : 0;
    }

    public static int getBear() {
        String str = prop.getProperty("Bear");
        return str != null ? Integer.parseInt(str) : 0;
    }

    public static int getBoa() {
        String str = prop.getProperty("Boa");
        return str != null ? Integer.parseInt(str) : 0;
    }

    public static int getEagle() {
        String str = prop.getProperty("Eagle");
        return str != null ? Integer.parseInt(str) : 0;
    }

    public static int getFox() {
        String str = prop.getProperty("Fox");
        return str != null ? Integer.parseInt(str) : 0;
    }

    public static int getWolf() {
        String str = prop.getProperty("Wolf");
        return str != null ? Integer.parseInt(str) : 0;
    }


}
