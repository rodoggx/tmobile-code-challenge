package com.example.rodoggx.codechallenge.di;

import com.example.rodoggx.codechallenge.view.PostActivity;

import dagger.Component;


@Component(modules = PostModule.class)
public interface PostComponent {

    void inject(PostActivity postActivity);


}
