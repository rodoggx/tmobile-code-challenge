package com.example.rodoggx.codechallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cards {
    @Expose
    private Card card;

    @SerializedName("card_type")
    @Expose
    private String cardType;

    public Card getCard() {
        return card;
    }

    public String getCardType() {
        return cardType;
    }
}
