package com.wrathspectre.test_11;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class VocabularyFrgment extends Fragment {

    RecyclerView recyclerView;
    VocabularyCardAdapter vocabularyCardAdapter;

    List<VocabularyCard> vocabularyCards;
    List<String> topicList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.content_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vocabularyCards = new ArrayList<>();

        recyclerView = view.findViewById(R.id.database_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        topicList = new ArrayList<>();

        try {

            String a;
            FileInputStream fileInputStream = getContext().openFileInput("ffffff.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            while((a = bufferedReader.readLine()) != null) {
                topicList.add(a);
                System.out.println(a);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!topicList.isEmpty()) {
            for(String topic: topicList) {
                vocabularyCards.add(new VocabularyCard(topic, 24, 8, 4));
            }
        }

        vocabularyCardAdapter = new VocabularyCardAdapter(getContext(), vocabularyCards);

        recyclerView.setAdapter(vocabularyCardAdapter);

        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddVocabularyActivity.class);
                        startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1 && resultCode == RESULT_OK) {
            try {
                FileOutputStream fileOutputStream = getContext().openFileOutput("ffffff.txt", Context.MODE_APPEND);
                fileOutputStream.write((data.getStringExtra("title") + "\n").getBytes());
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                vocabularyCards.add(new VocabularyCard(data.getStringExtra("title"), 24, 8, 4));
            }

            vocabularyCardAdapter = new VocabularyCardAdapter(getContext(), vocabularyCards);
            vocabularyCardAdapter.notifyDataSetChanged();

            recyclerView.setAdapter(vocabularyCardAdapter);
        }
    }
}
