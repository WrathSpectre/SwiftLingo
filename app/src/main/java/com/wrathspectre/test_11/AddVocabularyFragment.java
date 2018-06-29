package com.wrathspectre.test_11;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class AddVocabularyFragment extends Fragment {

    RecyclerView recyclerView;
    WordCardAdapter wordCardAdapter;

    List<WordCard> wordCards;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.vocabulary_intent, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Spinner spinner = view.findViewById(R.id.spinner);
        List<String> items = new ArrayList<>();
        items.add("Alphabetically");
        items.add("Date");
        items.add("Learned");
        items.add("Not learned");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.spinner_item, items);
        spinner.setAdapter(adapter);

        wordCards = new ArrayList<>();

        recyclerView = view.findViewById(R.id.word_items);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        wordCards.add(new WordCard("Transparent", "Przezrocysty", "fff", false));
        wordCards.add(new WordCard("Undoublty", "Niewatpliwie", "fff", false));
        wordCards.add(new WordCard("Pliers", "Kombinierki", "fff", false));
        wordCards.add(new WordCard("Harbour", "Port", "fff", false));
        wordCards.add(new WordCard("Perpedicular", "Prostopadly", "fff", false));
        wordCards.add(new WordCard("Chewing gum", "Guma", "fff", false));
        wordCards.add(new WordCard("Light bulb", "Zarowka", "fff", false));
        wordCards.add(new WordCard("Unaltered", "Niezmienieny", "fff", false));
        wordCards.add(new WordCard("Transparent", "Przezrocysty", "fff", false));
        wordCards.add(new WordCard("Undoublty", "Niewatpliwie", "fff", false));
        wordCards.add(new WordCard("Pliers", "Kombinierki", "fff", false));
        wordCards.add(new WordCard("Harbour", "Port", "fff", false));
        wordCards.add(new WordCard("Perpedicular", "Prostopadly", "fff", false));
        wordCards.add(new WordCard("Chewing gum", "Guma", "fff", false));
        wordCards.add(new WordCard("Light bulb", "Zarowka", "fff", false));
        wordCards.add(new WordCard("Unaltered", "Niezmienieny", "fff", false));

        wordCardAdapter = new WordCardAdapter(getContext(), wordCards);
        recyclerView.setAdapter(wordCardAdapter);

    }
}
