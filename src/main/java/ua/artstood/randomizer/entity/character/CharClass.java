package ua.artstood.randomizer.entity.character;

import java.util.HashMap;
import java.util.List;

public class CharClass {
    private final String className;
    private final String majorStat;
    private final String secondaryStat;


    public CharClass(String className, String majorStat, String secondaryStat) {
        this.className = className;
        this.majorStat = majorStat;
        this.secondaryStat = secondaryStat;
    }

    public String getClassName() {
        return className;
    }


    public String getMajorStat() {
        return majorStat;
    }


    public String getSecondaryStat() {
        return secondaryStat;
    }

    @Override
    public String toString() {
        return "CharClass{" +
                "className='" + className + '\'' +
                ", majorStat='" + majorStat + '\'' +
                ", secondaryStat='" + secondaryStat + '\'' +
                '}';
    }
}

