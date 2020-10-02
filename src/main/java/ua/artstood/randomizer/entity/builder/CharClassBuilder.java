package ua.artstood.randomizer.entity.builder;

import java.util.ArrayList;
import java.util.List;

import ua.artstood.randomizer.entity.character.CharClass;

import static ua.artstood.randomizer.entity.utility_classes.RandomizeUtils.rand;

public class CharClassBuilder {
    private String className;
    private List<String> majorStat;
    private List<String> secondaryStat;


    public CharClassBuilder(){
        majorStat= new ArrayList<>();
        secondaryStat = new ArrayList<>();
    }

    public CharClassBuilder setClassName(String className) {
        this.className = className;
        return this;
    }

    public CharClassBuilder addMajorStat(String majorStat) {
        this.majorStat.add(majorStat);
        return this;
    }

    public CharClassBuilder addSecondaryStat(String secondaryStat) {
        this.secondaryStat.add(secondaryStat);
        return this;
    }

    public CharClass build(){
        return new CharClass(className,
                majorStat.get(rand(0, majorStat.size()-1)),
                secondaryStat.get(rand(0, secondaryStat.size()-1)));
    }
}
