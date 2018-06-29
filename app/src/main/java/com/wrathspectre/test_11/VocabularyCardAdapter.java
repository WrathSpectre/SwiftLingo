package com.wrathspectre.test_11;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class VocabularyCardAdapter extends RecyclerView.Adapter<VocabularyCardAdapter.VocabularyCardViewHolder> {

    private Context context;
    private List<VocabularyCard> vocabularyCards;
    private MainActivity mainActivity;

    public VocabularyCardAdapter(Context context, List<VocabularyCard> vocabularyCards) {
        this.context = context;
        this.vocabularyCards = vocabularyCards;

        mainActivity = (MainActivity) context;
    }

    @Override
    public VocabularyCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new VocabularyCardViewHolder(inflater.inflate(R.layout.database_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(VocabularyCardViewHolder holder, int position) {
        VocabularyCard vocabularyCard = vocabularyCards.get(position);

        holder.titleText.setText(vocabularyCard.getTitle());
        holder.wordsText.setText(String.format("%d", vocabularyCard.getWords()));
        holder.learnedText.setText(String.format("%d", vocabularyCard.getLearned()));
        holder.markedText.setText(String.format("%d", vocabularyCard.getMarked()));

        holder.linearLayout.setBackgroundColor(VocabularyCard.getColor());
    }

    @Override
    public int getItemCount() {
        return vocabularyCards.size();
    }

    class VocabularyCardViewHolder extends RecyclerView.ViewHolder {

        TextView titleText, wordsText, learnedText, markedText;
        CoordinatorLayout linearLayout;

        public VocabularyCardViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View inflaterView = mainActivity.getLayoutInflater().inflate(R.layout.app_bar_main, null, false);

                    Fragment fragment = new VocabularyFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("data", "Health and style");

                    bundle.putInt("color", VocabularyCard.getColor());

                    fragment.setArguments(bundle);
                    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(inflaterView.findViewById(R.id.fragment_layout).getId(), fragment).commit();
                }
            });

            titleText = itemView.findViewById(R.id.title);
            wordsText = itemView.findViewById(R.id.words);
            learnedText = itemView.findViewById(R.id.learned);
            markedText = itemView.findViewById(R.id.marked);

            linearLayout = itemView.findViewById(R.id.database_item_layout);
        }
    }
}
