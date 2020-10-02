package ua.artstood.randomizer.entity.character;

//import android.content.res.Resources;
//
//import ua.artstood.randomizer.R;

import static ua.artstood.randomizer.entity.utility_classes.RandomizeUtils.rand;

public class Alignment {

    private String type;

    public Alignment(){
        String[] prefix = {"Lawful", "True", "Chaotic"};// Resources.getSystem().getStringArray(R.array.alignment_prefix);
        String[] suffix = {"Good", "Neutral", "Evil"};//Resources.getSystem().getStringArray(R.array.alignment_suffix);

        StringBuilder newAlignment = new StringBuilder();
        newAlignment.append(prefix[rand(0, prefix.length-1)])
                .append(" ")
                .append(suffix[rand(0, prefix.length-1)]);
        this.type = newAlignment.toString();
    }

    public Alignment(String[] prefix, String[] suffix){

        StringBuilder newAlignment = new StringBuilder();
        newAlignment.append(prefix[rand(0, prefix.length)])
                .append(" ")
                .append(suffix[rand(0, prefix.length)]);
        this.type = newAlignment.toString();
    }

    public String getAlignment(){
        return this.type;
    }
}
