package ua.artstood.randomizer;

import org.junit.Test;
import ua.artstood.randomizer.entity.character.*;
import ua.artstood.randomizer.entity.factory.BackgroundFactory;
import ua.artstood.randomizer.entity.factory.CharClassFactory;
import ua.artstood.randomizer.entity.factory.RaceFactory;
import ua.artstood.randomizer.entity.singleton.CharacterInit;

import java.util.Map;
import java.util.logging.Logger;

public class MainActivityTest {
    CharClassFactory classFactory = new CharClassFactory();
    RaceFactory raceFactory = new RaceFactory();
    BackgroundFactory backgroundFactory = new BackgroundFactory();
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    private static Logger log = Logger.getLogger(String.valueOf(MainActivityTest.class));

    private void printBack(Background background){
        System.out.println(ANSI_GREEN+ "name: "+ANSI_RESET+background.getName());
        System.out.println(ANSI_GREEN+"speciality: "+ ANSI_RESET + background.getSpeciality());
        System.out.println(ANSI_GREEN+ "feature: "+ANSI_RESET+ background.getFeature().getName());
        System.out.println(ANSI_GREEN+ "proficiencies "+ ANSI_RESET +background.getSkillProficiencies().get(0)+" " + background.getSkillProficiencies().get(1));
        System.out.println(ANSI_GREEN+ "trait: "+ ANSI_RESET);
        System.out.println(background.getPersonalityTrait().get(0));
        System.out.println(background.getPersonalityTrait().get(1));
        System.out.println(ANSI_GREEN+ "ideal"+ ANSI_RESET);
        System.out.println(background.getIdeal());
        System.out.println(ANSI_GREEN+ "bond"+ ANSI_RESET);
        System.out.println(background.getBond());
        System.out.println(ANSI_GREEN+"flaw"+ANSI_RESET);
        System.out.println(background.getFlaw());
    }

    @Test
    public void name() {
        log.info(classFactory.createChar().toString());

    }


    @Test
    public void characterBuild() {
        CharClass clazz = classFactory.createChar();
        Stats stats = new Stats();
        stats.generateStats(clazz.getMajorStat(), clazz.getSecondaryStat());
        //вывод класса
        System.out.println(clazz.getClassName()+" "+clazz.getMajorStat()+" "+clazz.getSecondaryStat());
        System.out.println();
        //
        //вывод статов
        for (Map.Entry<String, Stats.StatValue> entry : stats.getMainStats().entrySet()) {
            System.out.println(entry.getKey()+": "+ entry.getValue().getValue()+" "+ entry.getValue().getModifier());

        }
        System.out.println();
        //вывод скилов
        System.out.println();
        for (Map.Entry<String, Stats.SkillValue> entry : stats.getSkills().entrySet()) {
            System.out.println(entry.getKey()+": "+ entry.getValue().getValue());

        }
        System.out.println();
        //вывод рассы
        Race race = raceFactory.createRace();
        System.out.println(race.getName());
        System.out.println();
        for(Map.Entry<String, Integer> entry: race.getStatImprovement().entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
        System.out.println();
        //вывод мировозрения
        Alignment alignment = new Alignment();
        System.out.println(alignment.getAlignment());

        System.out.println();
        Background background = backgroundFactory.createBackground();

        printBack(background);
    }

    @Test
    public void testRaceFactory() {
        Race race = raceFactory.createRace();
        System.out.println(race.getName());
        for(Map.Entry<String, Integer> entry: race.getStatImprovement().entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }

    @Test
    public void testBackgroundFactory(){
        Background background = backgroundFactory.createBackground();
        printBack(background);
    }


    @Test
    public void charCreation() {
        CharacterInit init = CharacterInit.getInstance();

        init.createRandomCharacter().printToConsole();
        System.out.println();
        CharacterInit init1 = CharacterInit.getInstance();

        init1.createRandomCharacter().printToConsole();

    }
}