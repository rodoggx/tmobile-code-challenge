package com.example.rodoggx.codechallenge.model;

import com.google.gson.annotations.Expose;

public class Title {
    @Expose
    private String value;
    @Expose
    private Attributes attributes;

    public String getValue() {
        return value;
    }

    public Attributes getAttributes() {
        return attributes;
    }
}
