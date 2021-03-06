package com.example.rodoggx.codechallenge.utils;

public interface BasePresenter<V extends BaseView> {

    void attachView(V v);
    void detachView();
}
