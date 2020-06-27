package com.example.rodoggx.codechallenge.data;

import com.example.rodoggx.codechallenge.model.PageResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RemoteService {

    @GET("test/home")
    Call<PageResponse> getResponse();
}
