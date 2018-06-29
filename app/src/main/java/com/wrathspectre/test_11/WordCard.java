package com.wrathspectre.test_11;

public class WordCard {
    private String nativeWord;
    private String translatedWord;
    private String exampleSentence;
    private boolean marked;

    public WordCard(String nativeWord, String translatedWord, String exampleSentence, boolean marked) {
        this.nativeWord = nativeWord;
        this.translatedWord = translatedWord;
        this.exampleSentence = exampleSentence;
        this.marked = marked;
    }

    public String getNativeWord() {
        return nativeWord;
    }

    public void setNativeWord(String nativeWord) {
        this.nativeWord = nativeWord;
    }

    public String getTranslatedWord() {
        return translatedWord;
    }

    public void setTranslatedWord(String translatedWord) {
        this.translatedWord = translatedWord;
    }

    public String getExampleSentence() {
        return exampleSentence;
    }

    public void setExampleSentence(String exampleSentence) {
        this.exampleSentence = exampleSentence;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}
