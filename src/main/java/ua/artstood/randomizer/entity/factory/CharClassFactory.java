package ua.artstood.randomizer.entity.factory;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ua.artstood.randomizer.entity.character.CharClass;
import ua.artstood.randomizer.entity.builder.CharClassBuilder;

import static ua.artstood.randomizer.entity.utility_classes.RandomizeUtils.rand;


public class CharClassFactory {
    private List<CharClassBuilder> buildingInstructions ;
    private static String path ="D:\\projects\\other\\DndTest\\src\\main\\resources\\original_char_classes.json";
    private static String path2 ="src/main/resources/original_char_classes.json";
    private static String path3 = "original_char_classes.json";

//    @RequiresApi(api = Build.VERSION_CODES.N)
    public CharClassFactory() {
        //todo Разобраться с ресурсами
        buildingInstructions = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(path2));


            JSONArray charList = (JSONArray) obj;
            charList.forEach( charClass ->
                    parseCharacterClass((JSONObject) charClass)
            );
        }catch (FileNotFoundException e ){
            e.printStackTrace();
        }catch (IOException e ){
            e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }
//todo https://howtodoinjava.com/java/library/json-simple-read-write-json-examples/#:~:text=Read%20JSON%20from%20file%20in%20Java%20with%20json%2Dsimple&text=First%20of%20all%2C%20we%20will,type%20i.e.%20JSONArray%20and%20JSONObject%20.
/*
//        tempBuilder.setClassName("barbarian_class")
//        .addMajorStat("STR")
//        .addSecondaryStat("CON");
//        buildingInstructions.add(tempBuilder);
//
//        tempBuilder= new CharClassBuilder();
//        tempBuilder.setClassName(appContext.getResources().getString(R.string.cleric_class))//"Resources.getSystem().getResourceName(R.string.cleric_class)")
//                .addMajorStat("WIS")
//                .addSecondaryStat("CON").addSecondaryStat("STR");
//        buildingInstructions.add(tempBuilder);
//
//        tempBuilder= new CharClassBuilder();
//        tempBuilder.setClassName("Resources.getSystem().getResourceName(R.string.druid_class)")
//                .addMajorStat("WIS")
//                .addSecondaryStat("CON");
//        buildingInstructions.add(tempBuilder);
//
//        tempBuilder= new CharClassBuilder();
//        tempBuilder.setClassName("Resources.getSystem().getResourceName(R.string.bard_class)")
//                .addMajorStat("CHA")
//                .addSecondaryStat("DEX");
//        buildingInstructions.add(tempBuilder);
//
//        tempBuilder= new CharClassBuilder();
//        tempBuilder.setClassName("Resources.getSystem().getResourceName(R.string.fighter_class)")
//                .addMajorStat("DEX").addMajorStat("STR")
//                .addSecondaryStat("CON").addSecondaryStat("INT");
//        buildingInstructions.add(tempBuilder);
//
//        tempBuilder= new CharClassBuilder();
//        tempBuilder.setClassName("Resources.getSystem().getResourceName(R.string.monk_class)")
//                .addMajorStat("DEX")
//                .addSecondaryStat("WIS");
//        buildingInstructions.add(tempBuilder);
//
//        tempBuilder= new CharClassBuilder();
//        tempBuilder.setClassName("Resources.getSystem().getResourceName(R.string.paladin_class)")
//                .addMajorStat("STR")
//                .addSecondaryStat("CHA");
//        buildingInstructions.add(tempBuilder);
//
//        tempBuilder= new CharClassBuilder();
//        tempBuilder.setClassName("Resources.getSystem().getResourceName(R.string.ranger_class)")
//                .addMajorStat("STR").addMajorStat("DEX")
//                .addSecondaryStat("WIS");
//        buildingInstructions.add(tempBuilder);
//
//        tempBuilder= new CharClassBuilder();
//        tempBuilder.setClassName("Resources.getSystem().getResourceName(R.string.rogue_class)")
//                .addMajorStat("DEX")
//                .addSecondaryStat("WIS").addSecondaryStat("CHA");
//        buildingInstructions.add(tempBuilder);
//
//        tempBuilder= new CharClassBuilder();
//        tempBuilder.setClassName("Resources.getSystem().getResourceName(R.string.sorcerer_class)")
//                .addMajorStat("CHA")
//                .addSecondaryStat("CON");
//        buildingInstructions.add(tempBuilder);
//
//        tempBuilder= new CharClassBuilder();
//        tempBuilder.setClassName("Resources.getSystem().getResourceName(R.string.warlock_class)")
//                .addMajorStat("CHA")
//                .addSecondaryStat("CON");
//        buildingInstructions.add(tempBuilder);
//
//        tempBuilder= new CharClassBuilder();
//        tempBuilder.setClassName("Resources.getSystem().getResourceName(R.string.wizard_class)")
//                .addMajorStat("INT")
//                .addSecondaryStat("CON").addSecondaryStat("DEX").addSecondaryStat("CHA");
//        buildingInstructions.add(tempBuilder);
*/

        }

    public CharClass createChar(int id){
        return buildingInstructions.get(id).build();
    }

    public CharClass createChar(){
        return buildingInstructions.get(rand(0,buildingInstructions.size()-1)).build();
    }

    private void parseCharacterClass(JSONObject json) {
        CharClassBuilder builder = new CharClassBuilder();
        JSONObject classBuilderObject = (JSONObject) json.get("template");

        builder.setClassName((String) classBuilderObject.get("className"));

        JSONArray majorStat =(JSONArray) classBuilderObject.get("majorStat");
        JSONArray secondaryStat = (JSONArray)classBuilderObject.get("secondaryStat");

        majorStat.forEach(stat->builder.addMajorStat((String) stat));

        secondaryStat.forEach(stat->builder.addSecondaryStat((String) stat));

        buildingInstructions.add(builder);
    }
}
