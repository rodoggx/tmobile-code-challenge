package com.example.rodoggx.codechallenge.view;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rodoggx.codechallenge.R;
import com.example.rodoggx.codechallenge.di.DaggerCardsComponent;
import com.example.rodoggx.codechallenge.model.Cards;
import com.example.rodoggx.codechallenge.model.PageResponse;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import javax.inject.Inject;

public class CardActivity extends AppCompatActivity implements CardContract.View {

    @Inject
    CardPresenter cardPresenter;
    private ConnectivityManager connectivityManager;
    private RecyclerView recyclerView;
    private CardRecyclerAdapter adapter;
    private Handler cardHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupDaggerComponent();
        cardPresenter.attachView(this);
        setupRecyclerView();
        connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.rvCards);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new CardRecyclerAdapter(new ArrayList<Cards>(0));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void setupDaggerComponent() {
        DaggerCardsComponent.create().inject(this);
    }

    @Override
    public void onDataReceived(PageResponse pageResponse) {
        cardHandler.post(() -> adapter.updateCards(pageResponse.getPageResponse().getCards()));
    }

    @Override
    public void showError(String errorMessage) {
        toastMessage(errorMessage);
    }

    private void toastMessage(String message) {
        cardHandler.post(() -> Toast.makeText(CardActivity.this, message, Toast.LENGTH_SHORT).show());
    }

    @Override
    public void emptyCache() {
        toastMessage(getString(R.string.empty_cache));
    }

    public void onCardsRequest(View view) {
        if (hasNetwork())
            cardPresenter.getCards();
        else
            cardPresenter.getOfflineCards();
    }

    @Override
    public WeakReference<Context> getActivityContext() {
        return new WeakReference<>(this);
    }

    public boolean hasNetwork() {
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }
        if (networkInfo != null) {
            return networkInfo.isConnected();
        } else {
            return false;
        }
    }
}
