package ua.artstood.randomizer.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import ua.artstood.randomizer.entity.character.Character;
import ua.artstood.randomizer.entity.singleton.CharacterInit;

public class MainController {
    //todo сделать кнопку генерации
    //todo сделать разные языки

    public Label raceField;
    public Label classField;
    public Label alignmentField;

    public Label strValue;
    public Label dexValue;
    public Label conValue;
    public Label intValue;
    public Label wisValue;
    public Label chaValue;

    public Label strMod;
    public Label dexMod;
    public Label conMod;
    public Label intMod;
    public Label wisMod;
    public Label chaMod;

    public Label backType;
    public Label specName;
    public Label featName;
    public TextArea traitField;
    public TextArea idealField;
    public TextArea bondField;
    public TextArea flawField;



    private Character currentChar;

    public void initialize(){
        CharacterInit init = CharacterInit.getInstance();
        currentChar = init.createRandomCharacter();
        setupCharacter(currentChar);
    }
    private void setupCharacter(Character currentChar){


        raceField.setText(currentChar.getRace().getName());
        classField.setText(currentChar.getCharClass().getClassName());
        alignmentField.setText(currentChar.getAlignment().getAlignment());

        //todo переписать под мапу
        strValue.setText(String.valueOf(currentChar.getStats().getMainStats().get("STR").getValue()));
        dexValue.setText(String.valueOf(currentChar.getStats().getMainStats().get("DEX").getValue()));
        conValue.setText(String.valueOf(currentChar.getStats().getMainStats().get("CON").getValue()));
        intValue.setText(String.valueOf(currentChar.getStats().getMainStats().get("INT").getValue()));
        wisValue.setText(String.valueOf(currentChar.getStats().getMainStats().get("WIS").getValue()));
        chaValue.setText(String.valueOf(currentChar.getStats().getMainStats().get("CHA").getValue()));

        strMod.setText(String.valueOf(currentChar.getStats().getMainStats().get("STR").getModifier()));
        dexMod.setText(String.valueOf(currentChar.getStats().getMainStats().get("DEX").getModifier()));
        conMod.setText(String.valueOf(currentChar.getStats().getMainStats().get("CON").getModifier()));
        intMod.setText(String.valueOf(currentChar.getStats().getMainStats().get("INT").getModifier()));
        wisMod.setText(String.valueOf(currentChar.getStats().getMainStats().get("WIS").getModifier()));
        chaMod.setText(String.valueOf(currentChar.getStats().getMainStats().get("CHA").getModifier()));

        //todo сделать скилы
        backType.setText(currentChar.getBackground().getName());
        specName.setText(currentChar.getBackground().getSpeciality());
        featName.setText(currentChar.getBackground().getFeature().getName());

        String traitMessage = currentChar.getBackground().getPersonalityTrait().get(0) +
                "\n" +
                currentChar.getBackground().getPersonalityTrait().get(1);

        traitField.setText(traitMessage);

        idealField.setText(currentChar.getBackground().getIdeal());
        bondField.setText(currentChar.getBackground().getBond());
        flawField.setText(currentChar.getBackground().getFlaw());


    }

    public void recreate(ActionEvent actionEvent) {
        CharacterInit init = CharacterInit.getInstance();
        currentChar = init.createRandomCharacter();
        setupCharacter(currentChar);
    }

    public void saveCharacter(ActionEvent actionEvent) {
        //todo
    }

    public void loadCharacter(ActionEvent actionEvent) {
        //todo
    }
}
