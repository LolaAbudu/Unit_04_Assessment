package org.pursuit.unit_04_assessment.model;

public class Animal {

    private String animal;
    private String image;
    private String wiki;

    public Animal() {}

    public Animal(String animal, String image, String wiki) {
        this.animal = animal;
        this.image = image;
        this.wiki = wiki;
    }

    public String getAnimal() {
        return animal;
    }

    public String getImage() {
        return image;
    }

    public String getWiki() {
        return wiki;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }
}
