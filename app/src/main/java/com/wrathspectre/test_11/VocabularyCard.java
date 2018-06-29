package com.wrathspectre.test_11;

import android.graphics.Color;

public class VocabularyCard {
    private String title;
    private int words;
    private int learned;
    private int marked;

    private static int index = 0;

    public VocabularyCard(String title, int words, int learned, int marked) {
        this.title = title;
        this.words = words;
        this.learned = learned;
        this.marked = marked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public int getLearned() {
        return learned;
    }

    public void setLearned(int learned) {
        this.learned = learned;
    }

    public int getMarked() {
        return marked;
    }

    public void setMarked(int marked) {
        this.marked = marked;
    }

    public static int getColor() {
        Integer[] color = {Color.parseColor("#F64C73"),
                           Color.parseColor("#20D2BB"),
                           Color.parseColor("#C873F4"),
                           Color.parseColor("#FF8C00")};

        if(index < 3)
            index++;
        else
            index = 0;

        return color[index];
    }


}
