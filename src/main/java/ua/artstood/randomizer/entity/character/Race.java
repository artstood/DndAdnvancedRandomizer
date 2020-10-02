package ua.artstood.randomizer.entity.character;

import java.util.HashMap;
import java.util.List;

public class Race {
    private String name;
    private HashMap<String, Integer> StatImprovement;


    public Race(String name, HashMap<String, Integer> statImprovement) {
        this.name = name;
        StatImprovement = statImprovement;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Integer> getStatImprovement() {
        return StatImprovement;
    }
}
