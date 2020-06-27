package com.example.rodoggx.codechallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes {
    @SerializedName("text_color")
    @Expose
    private String textColor;
    @Expose
    private Font font;

    public String getTextColor() {
        return textColor;
    }

    public Font getFont() {
        return font;
    }
}
