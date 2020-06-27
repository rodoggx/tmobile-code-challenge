package com.example.rodoggx.codechallenge.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rodoggx.codechallenge.R;

public class CardImageTitleDescriptionViewHolder extends RecyclerView.ViewHolder {

    ImageView image;
    TextView title;
    TextView description;

    public CardImageTitleDescriptionViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        title = itemView.findViewById(R.id.title);
        description = itemView.findViewById(R.id.description);
    }
}
