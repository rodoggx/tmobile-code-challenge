package com.example.rodoggx.codechallenge.model;

import com.google.gson.annotations.Expose;

public class Size {
    @Expose
    private Integer width;
    @Expose
    private Integer height;

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }
}