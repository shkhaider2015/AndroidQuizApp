package com.example.quizapp;

public class DataModel {
    private String mQuestion;
    private String mOptionOne;
    private String mOptionTwo;
    private String mOptionThree;
    private String mOptionFour;
    private String mCorrectOption;

    public DataModel(String mQuestion, String mOptionOne, String mOptionTwo, String mOptionThree, String mOptionFour, String mCorrectOption) {
        this.mQuestion = mQuestion;
        this.mOptionOne = mOptionOne;
        this.mOptionTwo = mOptionTwo;
        this.mOptionThree = mOptionThree;
        this.mOptionFour = mOptionFour;
        this.mCorrectOption = mCorrectOption;
    }

    public String getmQuestion() {
        return mQuestion;
    }

    public String getmOptionOne() {
        return mOptionOne;
    }

    public String getmOptionTwo() {
        return mOptionTwo;
    }

    public String getmOptionThree() {
        return mOptionThree;
    }

    public String getmOptionFour() {
        return mOptionFour;
    }

    public String getmCorrectOption() {
        return mCorrectOption;
    }
}
