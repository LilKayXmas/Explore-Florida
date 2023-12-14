package com.example.exploreflorida;

public class TouristLocation {
    private final String name;
    private final String description;
    private final int imageResource;

    public TouristLocation(String name, String description, int imageResource) {
        this.name = name;
        this.description = description;
        this.imageResource = imageResource;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageResource;
    }
}
