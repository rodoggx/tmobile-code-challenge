package com.example.rodoggx.codechallenge.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Page {
    @Expose
    private List<Cards> cards;

    public List<Cards> getCards() {
        return cards;
    }
}
