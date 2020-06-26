package com.example.rodoggx.codechallenge.di;

import com.example.rodoggx.codechallenge.view.PostPresenter;

import dagger.Module;
import dagger.Provides;


@Module
public class PostModule {

    @Provides
    PostPresenter providerPostPresenter(){
        return new PostPresenter();
    }
}
