package com.example.rodoggx.codechallenge.view;

import android.content.Context;

import com.example.rodoggx.codechallenge.model.PageResponse;
import com.example.rodoggx.codechallenge.utils.BasePresenter;
import com.example.rodoggx.codechallenge.utils.BaseView;

import java.lang.ref.WeakReference;

public interface CardContract {

    interface View extends BaseView {
        void onDataReceived(PageResponse pageResponse);
        WeakReference<Context> getActivityContext();
        void emptyCache();
    }

    interface Presenter extends BasePresenter<View> {
        void getCards();
        void getOfflineCards();
    }
}