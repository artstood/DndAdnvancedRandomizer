package ua.artstood.randomizer.entity.factory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ua.artstood.randomizer.entity.character.Race;
import ua.artstood.randomizer.entity.builder.RaceBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ua.artstood.randomizer.entity.utility_classes.RandomizeUtils.rand;

public class RaceFactory {
    private List<RaceBuilder> buildingInstructions;
    private static final String path="src/main/resources/original_races.json";
    public RaceFactory(){
        //todo разобраться с под-рассами
        //TODO проверить правильность json
        buildingInstructions = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(path));
            JSONArray raceList = (JSONArray) obj;

            raceList.forEach(race->parseRace((JSONObject) race));
        }catch (ParseException e){
            e.printStackTrace();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e ){
            e.printStackTrace();
        }

    }

    public Race createRace(){
        return buildingInstructions.get(rand(0, buildingInstructions.size()-1)).build();
    }
    private void parseRace(JSONObject json) {
        RaceBuilder builder = new RaceBuilder();

        JSONObject race = (JSONObject) json.get("race");

        builder.setName((String)race.get("raceName"));

        JSONArray statBuff = (JSONArray) race.get("improvedStats");

        statBuff.forEach(stat->builder.addStatImprovement((String)stat));

        buildingInstructions.add(builder);

    }


}
