package ua.artstood.randomizer.entity.character;

import java.util.List;

public class Background {
    //https://www.dndbeyond.com/backgrounds?filter-name=&filter-source-category=1&filter-source=1
    private final String name;
    private final List<String> skillProficiencies;
    private final Feature feature;

    private final String speciality;
    private final List<String> personalityTrait;
    private final String ideal;
    private final String bond;
    private final String flaw;

    public Background(String name, List<String> skillProficiencies,
                      Feature feature, String speciality, List<String> personalityTrait,
                      String ideal, String bond, String flaw) {

        this.name = name;
        this.skillProficiencies = skillProficiencies;
        this.feature = feature;
        this.speciality = speciality;
        this.personalityTrait = personalityTrait;
        this.ideal = ideal;
        this.bond = bond;
        this.flaw = flaw;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkillProficiencies() {
        return skillProficiencies;
    }

    public Feature getFeature() {
        return feature;
    }

    public List<String> getPersonalityTrait() {
        return personalityTrait;
    }

    public String getIdeal() {
        return ideal;
    }

    public String getBond() {
        return bond;
    }

    public String getFlaw() {
        return flaw;
    }

    public String getSpeciality(){
        return speciality;
    }
}
