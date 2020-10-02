package ua.artstood.randomizer.entity.builder;

import ua.artstood.randomizer.entity.character.*;
import ua.artstood.randomizer.entity.character.Character;

public class CharacterBuilder {
    private Race race;
    private CharClass charClass;
    private Alignment alignment;
    private Background background;
    private Stats stats;


    public CharacterBuilder(){
        stats = new Stats();
    };

    public CharacterBuilder setRace(Race race) {
        this.race = race;
        return this;
    }

    public CharacterBuilder setCharClass(CharClass charClass) {
        this.charClass = charClass;
        return this;
    }

    public CharacterBuilder setAlignment(Alignment alignment) {
        this.alignment = alignment;
        return this;
    }

    public CharacterBuilder setBackground(Background background) {
        this.background = background;
        return this;
    }

//    public CharacterBuilder setStats(Stats stats) {
//        this.stats = stats;
//        return this;
//    }
    private void generateStats(){
        stats.generateStats(charClass.getMajorStat(), charClass.getSecondaryStat());

    }
    private void addStatBonus(){

        for (String key : stats.getMainStats().keySet()) {
            Integer result = stats.getMainStats().get(key).getValue() + race.getStatImprovement().get(key);
            stats.addStat(key, result);

        }
        stats.refreshSkills();
    }
    private void addProficiency(){
        for(String proficiency: background.getSkillProficiencies()){
            stats.getSkills().get(proficiency).setProficient(true);
        }
    }
    public Character build(){
        generateStats();
        addStatBonus();
        addProficiency();

        return new Character(race, charClass, alignment, background, stats);
    }


}
