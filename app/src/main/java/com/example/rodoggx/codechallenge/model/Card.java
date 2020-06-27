package com.example.rodoggx.codechallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Card {
    @Expose
    private String value;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @Expose
    private Title title;
    @Expose
    private Description description;
    @Expose
    private Image image;

    public String getValue() {
        return value;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public Title getTitle() {
        return title;
    }

    public Description getDescription() {
        return description;
    }

    public Image getImage() {
        return image;
    }
}
