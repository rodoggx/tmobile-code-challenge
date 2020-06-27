package com.example.rodoggx.codechallenge.view;

import com.example.rodoggx.codechallenge.data.RemoteDataSource;
import com.example.rodoggx.codechallenge.data.db.CacheData;
import com.example.rodoggx.codechallenge.data.db.CacheDatabase;
import com.example.rodoggx.codechallenge.model.PageResponse;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;

public class CardPresenter implements CardContract.Presenter {

    private CardContract.View view;
    private Gson gsonConvertor = new Gson();

    @Override
    public void attachView(CardContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void getCards() {

        RemoteDataSource.getResponse().enqueue(new Callback<PageResponse>() {
            @Override
            public void onResponse(Call<PageResponse> call, retrofit2.Response<PageResponse> response) {
                view.onDataReceived(response.body());
                saveToCache(gsonConvertor.toJson(response.body()));
            }

            @Override
            public void onFailure(Call<PageResponse> call, Throwable t) {
                view.showError(t.toString());
            }
        });
    }

    private void saveToCache(String cacheJson) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                String date = new SimpleDateFormat("MM/dd/yyyy HH:mmaa", Locale.US).format(new Date());
                CacheDatabase.getInstance(view.getActivityContext().get()).getCacheDao().insertCacheInfo(new CacheData(cacheJson, date));
            }
        }.start();
    }

    @Override
    public void getOfflineCards() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                List<CacheData> cacheDataList = CacheDatabase.getInstance(view.getActivityContext().get()).getCacheDao().getAllCache();

                if (!cacheDataList.isEmpty()) {
                    try {
                        PageResponse cachedResponse = gsonConvertor.fromJson(cacheDataList.get(0).getjSonString(), PageResponse.class);
                        view.onDataReceived(cachedResponse);
                    } catch (Exception e) {
                        view.showError(e.getMessage());
                    }
                } else {
                    view.emptyCache();
                }
            }
        }.start();
    }
}
