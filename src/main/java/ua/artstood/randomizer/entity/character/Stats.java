package ua.artstood.randomizer.entity.character;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import ua.artstood.randomizer.entity.utility_classes.Pair;

import static ua.artstood.randomizer.entity.utility_classes.RandomizeUtils.*;

public class Stats {
    //todo вінести генерацию в отдельній класс
    private HashMap<String, StatValue> mainStats;
    private HashMap<String, SkillValue> skills;

    public Stats() {
        mainStats = new HashMap<>();
        skills = new HashMap<>();

        mainStats.put("STR", new StatValue(0));
        mainStats.put("DEX", new StatValue(0));
        mainStats.put("CON", new StatValue(0));
        mainStats.put("INT", new StatValue(0));
        mainStats.put("WIS", new StatValue(0));
        mainStats.put("CHA", new StatValue(0));

        //STR
        skills.put("Athletics",new SkillValue("STR"));
        //DEX
        skills.put("Acrobatics",new SkillValue("DEX"));
        skills.put("Sleight of Hand",new SkillValue("DEX"));
        skills.put("Stealth",new SkillValue("DEX"));
        //INT
        skills.put("Arcana",new SkillValue("INT"));
        skills.put("History",new SkillValue("INT"));
        skills.put("Investigation",new SkillValue("INT"));
        skills.put("Nature",new SkillValue("INT"));
        skills.put("Religion",new SkillValue("INT"));
        //WIS
        skills.put("Animal Handling",new SkillValue("WIS"));
        skills.put("Insight",new SkillValue("WIS"));
        skills.put("Medicine",new SkillValue("WIS"));
        skills.put("Perception",new SkillValue("WIS"));
        skills.put("Survival",new SkillValue("WIS"));
        //CHA
        skills.put("Deception",new SkillValue("CHA"));
        skills.put("Intimidation",new SkillValue("CHA"));
        skills.put("Performance",new SkillValue("CHA"));
        skills.put("Persuasion",new SkillValue("CHA"));

    }

    public void generateStats(String biggestStatKey, String secondStatKey) {
        List<Integer> rawStats = new ArrayList<>();
        for(int i = 0; i <mainStats.size() ; i++){
            rawStats.add(statRoll(6,4));//todo добавить 2 рола, выбрать с наибольшлй суммой
        }

        Pair<Integer, Integer> max = findTwoGreatestStats(rawStats);

        mainStats.put(biggestStatKey, new StatValue(max.first));
        mainStats.put(secondStatKey, new StatValue(max.second));
        int i = 0;
        for(String key : mainStats.keySet()){
            if(!key.equals(biggestStatKey) && !key.equals(secondStatKey)){
                mainStats.put(key, new StatValue(rawStats.get(i)));
                i++;
            }
        }
        //refreshSkills();
    }

    public HashMap<String, StatValue> getMainStats() {
        return mainStats;
    }
    public HashMap<String, SkillValue> getSkills() {
        return skills;
    }

    private Pair<Integer, Integer> findTwoGreatestStats(List<Integer> rawStats){
        int max1=Integer.MIN_VALUE, max2=max1;
        for(int i =0; i<rawStats.size(); i++) {
            if (rawStats.get(i) > max1) {
                max2 = max1;
                max1 = rawStats.get(i);
            }
            else if (rawStats.get(i) > max2) {
                    max2 = rawStats.get(i);
            }
        }

        rawStats.remove(Integer.valueOf(max1));
        rawStats.remove(Integer.valueOf(max2));

        return new Pair<>(max1,max2);
    }

    public void refreshSkills(){
        for(Map.Entry<String, SkillValue> entry : skills.entrySet()){
            entry.getValue().setValue(mainStats);
        }
    }

    public void addStat(String key, Integer value){
        mainStats.put(key, new StatValue(value));
    }

    public class StatValue {
        private int value;
        private int modifier;

        public StatValue(int value) {
            this.value = value;
            this.modifier = calculateModifier(value);
        }

        public int getValue() {
            return value;
        }

        public int getModifier() {
            return modifier;
        }

        public void setValue(int value) {
            this.value = value;
            this.modifier = calculateModifier(value);
        }

        private int calculateModifier(int number) {
            return (int)Math.floor((number - 10) / 2.);
        }

    }

    public class SkillValue{
        private final String statDependency;
        private Integer value;
        private boolean isProficient;
        private static final int PROFICIENT_BONUS=2;

        SkillValue (String statDependency){
            this.statDependency = statDependency;
            this.value=0;
            this.isProficient=false;
        }

        public void setValue(HashMap<String, StatValue> stats) {
            this.value = stats.get(statDependency).getModifier();
        }

        public void setProficient(boolean proficient){
            this.isProficient=proficient;
        }

        public Integer getValue(){
            return isProficient?
                    value+PROFICIENT_BONUS
                    :
                    value;
        }



        public boolean isProficient() {
            return isProficient;
        }
    }


}

