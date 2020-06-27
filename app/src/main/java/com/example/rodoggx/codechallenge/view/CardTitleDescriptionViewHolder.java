package com.example.rodoggx.codechallenge.view;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rodoggx.codechallenge.R;

public class CardTitleDescriptionViewHolder extends RecyclerView.ViewHolder {

    TextView title;
    TextView description;

    public CardTitleDescriptionViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        description = itemView.findViewById(R.id.description);
    }
}
