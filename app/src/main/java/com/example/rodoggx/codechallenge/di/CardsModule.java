package com.example.rodoggx.codechallenge.di;

import com.example.rodoggx.codechallenge.view.CardPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class CardsModule {

    @Provides
    CardPresenter providerCardPresenter(){
        return new CardPresenter();
    }
}
