package animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ChanceToEat {
    BEAR(Arrays.asList(
            "Boa=80",
            "Horse=40",
            "Deer=80",
            "Bunny=80",
            "Mouse=80",
            "Goat=70",
            "Sheep=70",
            "Boar=50",
            "Buffalo=20",
            "Duck=10")),
    BOA(Arrays.asList(
            "Fox=15",
            "Bunny=20",
            "Mouse=40",
            "Duck=10"
    )),
    EAGLE(Arrays.asList(
            "Fox=10",
            "Bunny=90",
            "Mouse=90",
            "Duck=80"
    )),
    FOX(Arrays.asList(
            "Bunny=70",
            "Mouse=90",
            "Duck=60",
            "Caterpillar=40"
    )),
    WOLF(Arrays.asList(
            "Hourse=10",
            "Deer=15",
            "Bunny=60",
            "Mouse=80",
            "Goat=70",
            "Sheep=70",
            "Boar=15",
            "Buffalo=10",
            "Duck=40"
    )),
    MOUSE(Arrays.asList("Cateprillar=90")),
    BOAR(Arrays.asList("Mouse=50", "Caterpillar=90")),
    DUCK(Arrays.asList("Caterpillar=90"));

    private List<String> chance;
    public List<String> getChance(){
        return chance;
    };

    ChanceToEat(List<String> chance) {
        this.chance = chance;
    }

}
