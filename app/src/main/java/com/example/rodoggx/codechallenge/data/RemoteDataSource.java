package com.example.rodoggx.codechallenge.data;

import com.example.rodoggx.codechallenge.model.Page;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RemoteDataSource {
    public static final String BASE_URL = "https://private-8ce77c-tmobiletest.apiary-mock.com/test/home/";

    public static Retrofit create() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Call<Page> getResponse() {
        Retrofit retrofit = create();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService.getResponse();
    }
}
