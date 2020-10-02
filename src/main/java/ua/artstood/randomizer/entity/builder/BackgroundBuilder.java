package ua.artstood.randomizer.entity.builder;

import ua.artstood.randomizer.entity.character.Background;
import ua.artstood.randomizer.entity.character.Feature;

import java.util.ArrayList;
import java.util.List;

import static ua.artstood.randomizer.entity.utility_classes.RandomizeUtils.*;

public class BackgroundBuilder {
    private List<String> name;
    private List<String> skillProficiencies;
    private Feature feature;

    private List<String> speciality;
    private List<String> personalityTrait;
    private List<String> ideal;
    private List<String> bond;
    private List<String> flaw;

    public BackgroundBuilder(){
        name = new ArrayList<>();
        skillProficiencies = new ArrayList<>();
        speciality = new ArrayList<>();
        personalityTrait= new ArrayList<>();
        ideal = new ArrayList<>();
        bond = new ArrayList<>();
        flaw = new ArrayList<>();
    }

    public BackgroundBuilder addName(String name){
        this.name.add(name);
        return this;
    }

    public BackgroundBuilder addSkillProficiencies(String proficiencies){
        this.skillProficiencies.add(proficiencies);
        return this;
    }

    public BackgroundBuilder setFeature(Feature feature) {
        this.feature = feature;
        return this;
    }

    public BackgroundBuilder addSpeciality(String speciality){
        this.speciality.add(speciality);
        return this;
    }

    public BackgroundBuilder addTrait(String trait){
        this.personalityTrait.add(trait);
        return this;
    }

    public BackgroundBuilder addIdeal(String ideal){
        this.ideal.add(ideal);
        return this;
    }

    public BackgroundBuilder addBond(String bond){
        this.bond.add(bond);
        return this;
    }

    public BackgroundBuilder addFlaw(String flaw){
        this.flaw.add(flaw);
        return this;
    }



    public Background build(){
        String name = getRandomString(this.name);
        String speciality = getRandomString(this.speciality);

        List<String> traits = getTwoRandomStrings(this.personalityTrait);
        String ideal = getRandomString(this.ideal);
        String bond = getRandomString(this.bond);
        String flaw = getRandomString(this.flaw);

        return new Background(
                name,
                this.skillProficiencies,
                this.feature,
                speciality,
                traits,
                ideal,
                bond,
                flaw
        );

    }
}
