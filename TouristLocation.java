package com.example.exploreflorida;

public class TouristLocation {
    private String name;
    private String description;
    private int imageResource;

    public TouristLocation(String name, String description, int imageResource) {
        this.name = name;
        this.description = description;
        this.imageResource = imageResource;
    }

    // Add getters if needed
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }
}
