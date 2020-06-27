package com.example.rodoggx.codechallenge.model;

import com.google.gson.annotations.Expose;

public class Image {
    @Expose
    private String url;
    @Expose
    private Size size;

    public String getUrl() {
        return url;
    }

    public Size getSize() {
        return size;
    }
}

