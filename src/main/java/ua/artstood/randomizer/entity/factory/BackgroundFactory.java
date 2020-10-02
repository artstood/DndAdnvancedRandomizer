package ua.artstood.randomizer.entity.factory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ua.artstood.randomizer.entity.character.Background;
import ua.artstood.randomizer.entity.character.Feature;
import ua.artstood.randomizer.entity.builder.BackgroundBuilder;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ua.artstood.randomizer.entity.utility_classes.RandomizeUtils.*;

public class BackgroundFactory {
    private List<BackgroundBuilder> buildingInstructions;
    private static final String path="src/main/resources/original_backgrounds.json";
    public BackgroundFactory(){
        //todo расширить feature
        //todo сделать влияние на мировозрение
        buildingInstructions = new ArrayList<>();
        JSONParser parser = new JSONParser();



        try {
            Object obj = parser.parse(new FileReader(path));
            JSONArray backgroundList = (JSONArray) obj;

            backgroundList.forEach(background->parseBackground((JSONObject) background));


        }catch (ParseException e){
            e.printStackTrace();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e ){
            e.printStackTrace();
        }
    }

    public Background createBackground(){
        return buildingInstructions.get(rand(0, buildingInstructions.size()-1)).build();
    }

    private void parseBackground(JSONObject json) {
        BackgroundBuilder builder = new BackgroundBuilder();

        JSONObject background = (JSONObject) json.get("background");

        JSONArray nameArray = (JSONArray) background.get("name");
        nameArray.forEach(name->builder.addName((String) name));

        JSONArray specialityArray = (JSONArray) background.get("speciality");
        specialityArray.forEach(speciality->builder.addSpeciality((String) speciality));

        builder.setFeature(new Feature((String) background.get("feature")));

        JSONArray proficienciesArray = (JSONArray) background.get("proficiencies");
        proficienciesArray.forEach(prof->builder.addSkillProficiencies((String)prof));

        JSONArray traitArray = (JSONArray) background.get("trait");
        traitArray.forEach(trait->builder.addTrait((String) trait));

        JSONArray idealArray = (JSONArray) background.get("ideal");
        idealArray.forEach(ideal->builder.addIdeal((String) ideal));

        JSONArray bondArray = (JSONArray) background.get("bond");
        bondArray.forEach(bond->builder.addBond((String) bond));

        JSONArray flawArray = (JSONArray) background.get("flaw");
        flawArray.forEach(flaw->builder.addFlaw((String) flaw));

        buildingInstructions.add(builder);

    }
}
