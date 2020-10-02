package ua.artstood.randomizer.entity.singleton;

import ua.artstood.randomizer.entity.builder.CharacterBuilder;
import ua.artstood.randomizer.entity.character.Alignment;
import ua.artstood.randomizer.entity.factory.BackgroundFactory;
import ua.artstood.randomizer.entity.factory.CharClassFactory;
import ua.artstood.randomizer.entity.factory.RaceFactory;
import ua.artstood.randomizer.entity.character.Character;

public class CharacterInit {
    private static CharacterInit instance;
    private CharClassFactory classFactory;
    private RaceFactory raceFactory;
    private BackgroundFactory backgroundFactory;

    private CharacterInit(){
        classFactory = new CharClassFactory();
        raceFactory = new RaceFactory();
        backgroundFactory = new BackgroundFactory();
    }

    public static CharacterInit getInstance(){
        if(instance == null){
            instance = new CharacterInit();
        }
        return instance;
    }

    public Character createRandomCharacter(){
        CharacterBuilder builder = new CharacterBuilder()
                .setAlignment(new Alignment())
                .setBackground(backgroundFactory.createBackground())
                .setRace(raceFactory.createRace())
                .setCharClass(classFactory.createChar());
        return builder.build();
    }
}
