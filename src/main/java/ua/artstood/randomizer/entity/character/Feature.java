package ua.artstood.randomizer.entity.character;

public class Feature{
    private String name;
    private String description;

    public Feature(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Feature(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}