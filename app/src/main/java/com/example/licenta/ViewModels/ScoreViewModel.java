package com.example.licenta.ViewModels;

import androidx.databinding.BaseObservable;

public class ScoreViewModel extends BaseObservable {
    public int scoreA =0 ;
    public int scoreB =0 ;

    public int getScoreA() {
        return scoreA;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }
}
