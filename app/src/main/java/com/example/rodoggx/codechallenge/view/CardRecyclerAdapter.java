package com.example.rodoggx.codechallenge.view;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.rodoggx.codechallenge.R;
import com.example.rodoggx.codechallenge.model.Cards;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.example.rodoggx.codechallenge.utils.CardViewType.TYPE_IMAGE;
import static com.example.rodoggx.codechallenge.utils.CardViewType.TYPE_TEXT;
import static com.example.rodoggx.codechallenge.utils.CardViewType.TYPE_TITLE;

public class CardRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Cards> cards;

    public CardRecyclerAdapter(List<Cards> cards) {
        this.cards = cards;
    }

    @Override
    public int getItemViewType(int position) {
        super.getItemViewType(position);
        switch (cards.get(position).getCardType()) {
            case "title_description":
                return TYPE_TITLE;
            case "image_title_description":
                return TYPE_IMAGE;
            default:
                return TYPE_TEXT;
        }
    }

    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case TYPE_TITLE:
                View titleDescView = inflater.inflate(R.layout.titledescription_item, parent, false);
                viewHolder = new CardTitleDescriptionViewHolder(titleDescView);
                break;
            case TYPE_IMAGE:
                View imageTitleDescView = inflater.inflate(R.layout.imagetitledescription_item, parent, false);
                viewHolder = new CardImageTitleDescriptionViewHolder(imageTitleDescView);
                break;
            default:
                View text = inflater.inflate(R.layout.text_item, parent, false);
                viewHolder = new CardTextViewHolder(text);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Cards card = cards.get(position);
        switch (getItemViewType(position)) {
            case TYPE_TITLE:
                CardTitleDescriptionViewHolder titleViewHolder = (CardTitleDescriptionViewHolder) holder;
                bindCardTitleDescriptionViewHolder(titleViewHolder, card);
                break;
            case TYPE_IMAGE:
                CardImageTitleDescriptionViewHolder imageTitleViewHolder = (CardImageTitleDescriptionViewHolder) holder;
                bindCardImageTitleDescriptionViewHolder(imageTitleViewHolder, card);
                break;
            default:
                CardTextViewHolder viewHolder = (CardTextViewHolder) holder;
                bindTextViewHolder(viewHolder, card);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return cards != null ? cards.size() : 0;
    }

    public void updateCards(List<Cards> cards) {
        this.cards = cards;
        notifyDataSetChanged();
    }

    private void bindCardTitleDescriptionViewHolder(CardTitleDescriptionViewHolder viewHolder, Cards card) {
        viewHolder.title.setText(card.getCard().getTitle().getValue());
        viewHolder.title.setTextSize(card.getCard().getTitle().getAttributes().getFont().getSize());
        viewHolder.title.setTextColor(Color.parseColor(card.getCard().getTitle().getAttributes().getTextColor()));

        viewHolder.description.setText(card.getCard().getDescription().getValue());
        viewHolder.description.setTextSize(card.getCard().getDescription().getAttributes().getFont().getSize());
        viewHolder.description.setTextColor(Color.parseColor(card.getCard().getDescription().getAttributes().getTextColor()));
    }

    private void bindCardImageTitleDescriptionViewHolder(CardImageTitleDescriptionViewHolder viewHolder, Cards card) {
        viewHolder.title.setText(card.getCard().getTitle().getValue());
        viewHolder.title.setTextSize(card.getCard().getTitle().getAttributes().getFont().getSize());
        viewHolder.title.setTextColor(Color.parseColor(card.getCard().getTitle().getAttributes().getTextColor()));

        viewHolder.description.setText(card.getCard().getDescription().getValue());
        viewHolder.description.setTextSize(card.getCard().getDescription().getAttributes().getFont().getSize());
        viewHolder.description.setTextColor(Color.parseColor(card.getCard().getDescription().getAttributes().getTextColor()));

        Picasso.get().load(card.getCard().getImage().getUrl()).into(viewHolder.image);
    }

    private void bindTextViewHolder(CardTextViewHolder viewHolder, Cards card) {
        viewHolder.text.setText(card.getCard().getValue());
        viewHolder.text.setTextSize(card.getCard().getAttributes().getFont().getSize());
        viewHolder.text.setTextColor(Color.parseColor(card.getCard().getAttributes().getTextColor()));
    }
}
