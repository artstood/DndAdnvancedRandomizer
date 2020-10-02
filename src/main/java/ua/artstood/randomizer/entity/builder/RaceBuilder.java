package ua.artstood.randomizer.entity.builder;

import ua.artstood.randomizer.entity.character.Race;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static ua.artstood.randomizer.entity.utility_classes.RandomizeUtils.rand;

public class RaceBuilder {
    private String name;
    private HashMap<String, Integer> statImprovement;
    private int freePoints;

    public RaceBuilder() {
        statImprovement = new HashMap<>();
        statImprovement.put("STR",0);
        statImprovement.put("DEX",0);
        statImprovement.put("CON",0);
        statImprovement.put("INT",0);
        statImprovement.put("WIS",0);
        statImprovement.put("CHA",0);
        freePoints=0;
    }

    public RaceBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public RaceBuilder addStatImprovement(String stat, Integer value) {
        statImprovement.put(stat, value);
        return this;
    }

    public RaceBuilder addStatImprovement(String stat){
        if(stat.equals("RAND")){
            freePoints++;
        }else {
            Integer temp = statImprovement.get(stat)+1;
            statImprovement.put(stat, temp);
        }
        return this;
    }
    public Race build(){
        if(freePoints>0){
            List<String> keyList = new ArrayList<>(statImprovement.keySet()) ;
            while(freePoints>0){
                String randKey = keyList.get(rand(0,keyList.size()-1));
                if(statImprovement.get(randKey) == 0){
                    statImprovement.put(randKey, 1);
                    freePoints--;
                }
            }

        }
        return new Race(name, statImprovement);
    }

}
