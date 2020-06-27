package com.example.rodoggx.codechallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PageResponse {
    @SerializedName("page")
    @Expose
    private Page page;

    public Page getPageResponse() {
        return page;
    }
}
