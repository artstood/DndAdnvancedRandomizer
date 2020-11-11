package ua.artstood.randomizer.entity.character;

public class Character {
    private Race race;
    private CharClass charClass;
    private Alignment alignment;
    private Background background;
    private Stats stats;

    public Character(Race race, CharClass charClass, Alignment alignment, Background background, Stats stats) {
        this.race = race;
        this.charClass = charClass;
        this.alignment = alignment;
        this.background = background;
        this.stats = stats;
    }

    //todo удалить
    public void printToConsole(){
        System.out.println(colorG("Race: ") + race.getName());
        System.out.println(colorR("Stat Bonus:"));
        race.getStatImprovement().forEach((key, value) -> System.out.println(colorR(key) + ": " + value));
        System.out.println();
        System.out.println(colorG("class: ")+ charClass.getClassName());
        System.out.println(colorR("Primal Stats: ")+ charClass.getMajorStat()+" "+ charClass.getSecondaryStat());
        System.out.println();
        System.out.println(colorG("Stats:"));
        stats.getMainStats().forEach((key, value)-> System.out.println(colorG(key)+": " + value.getValue() + " "+value.getModifier()));
        System.out.println();
        System.out.println(colorG("Skills:"));
        stats.getSkills().forEach((key, value)-> System.out.println(colorG(key)+": " + value.getValue()+" "+ value.isProficient()));
        System.out.println();
        System.out.println(colorG("Alignment: ") + alignment.getAlignment());
        printBack(background);
    }

    private String colorG(String str){
        return "\u001B[32m" + str + "\u001B[0m";
    }
    private String colorR(String str){
        return "\u001B[31m" + str + "\u001B[0m";
    }

    private void printBack(Background background){
        System.out.println("background: ");
        System.out.println(colorG("name: ")+background.getName());
        System.out.println(colorG("speciality: ") + background.getSpeciality());
        System.out.println(colorG("feature: ")+ background.getFeature().getName());
        System.out.println(colorG("proficiency: ") +background.getSkillProficiencies().get(0)+" " + background.getSkillProficiencies().get(1));
        System.out.println(colorG("trait: "));
        System.out.println(background.getPersonalityTrait().get(0));
        System.out.println(background.getPersonalityTrait().get(1));
        System.out.println(colorG("ideal: "));
        System.out.println(background.getIdeal());
        System.out.println(colorG("bond: "));
        System.out.println(background.getBond());
        System.out.println(colorG("flaw: "));
        System.out.println(background.getFlaw());
    }

    public Race getRace() {
        return race;
    }

    public CharClass getCharClass() {
        return charClass;
    }

    public Alignment getAlignment() {
        return alignment;
    }

    public Background getBackground() {
        return background;
    }

    public Stats getStats() {
        return stats;
    }
}


