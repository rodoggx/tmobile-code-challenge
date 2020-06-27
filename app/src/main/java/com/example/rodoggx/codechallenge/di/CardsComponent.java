package com.example.rodoggx.codechallenge.di;

import com.example.rodoggx.codechallenge.view.CardActivity;

import dagger.Component;

@Component(modules = CardsModule.class)
public interface CardsComponent {

    void inject(CardActivity cardActivity);
}
