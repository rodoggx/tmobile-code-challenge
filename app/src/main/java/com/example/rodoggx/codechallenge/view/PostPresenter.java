package com.example.rodoggx.codechallenge.view;

import com.example.rodoggx.codechallenge.data.RemoteDataSource;
import com.example.rodoggx.codechallenge.model.Page;

import retrofit2.Call;
import retrofit2.Callback;


public class PostPresenter implements PostContract.Presenter {

    PostContract.View view;

    @Override
    public void attachView(PostContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void getPosts() {
        RemoteDataSource.getResponse().enqueue(new Callback<Page>() {
            @Override
            public void onResponse(Call<Page> call, retrofit2.Response<Page> response) {
                view.onPostReceived(response.body());
            }

            @Override
            public void onFailure(Call<Page> call, Throwable t) {
                view.showError(t.toString());
            }
        });
    }
}
