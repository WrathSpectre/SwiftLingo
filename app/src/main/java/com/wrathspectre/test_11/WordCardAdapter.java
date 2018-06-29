package com.wrathspectre.test_11;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WordCardAdapter extends RecyclerView.Adapter<WordCardAdapter.WordCardViewHolder> {

    private Context context;
    private List<WordCard> wordCards;

    public WordCardAdapter(Context context, List<WordCard> wordCards) {
        this.context = context;
        this.wordCards = wordCards;
    }

    @Override
    public WordCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new WordCardViewHolder(inflater.inflate(R.layout.word_card, parent, false));
    }

    @Override
    public void onBindViewHolder(WordCardViewHolder holder, int position) {
        WordCard wordCard = wordCards.get(position);

        holder.nativeWord.setText(wordCard.getNativeWord());
        holder.translatedWord.setText(wordCard.getTranslatedWord());
    }

    @Override
    public int getItemCount() {
        return wordCards.size();
    }

    class WordCardViewHolder extends RecyclerView.ViewHolder {
        TextView nativeWord, translatedWord;

        public WordCardViewHolder(View itemView) {
            super(itemView);

            nativeWord = itemView.findViewById(R.id.native_word);
            translatedWord = itemView.findViewById(R.id.translated_word);
        }
    }
}
