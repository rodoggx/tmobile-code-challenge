package com.example.rodoggx.codechallenge.view;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rodoggx.codechallenge.R;

public class CardTextViewHolder extends RecyclerView.ViewHolder {

    TextView text;

    public CardTextViewHolder(@NonNull View itemView) {
        super(itemView);
        text = itemView.findViewById(R.id.text);
    }
}
