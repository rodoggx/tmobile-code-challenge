package com.example.rodoggx.codechallenge.view;

import com.example.rodoggx.codechallenge.model.Page;
import com.example.rodoggx.codechallenge.utils.BasePresenter;
import com.example.rodoggx.codechallenge.utils.BaseView;


public interface PostContract {

    //implement in activity
    interface View extends BaseView {
        void onPostReceived(Page postList);
    }

    //call from activity
    interface Presenter extends BasePresenter<View> {
        void getPosts();
    }
}
