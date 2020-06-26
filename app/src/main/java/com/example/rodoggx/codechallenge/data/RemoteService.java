package com.example.rodoggx.codechallenge.data;

import com.example.rodoggx.codechallenge.model.Page;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RemoteService {

    @GET("page")
    Call<Page> getResponse();
}
