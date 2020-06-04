package com.example.yzbkaka.cardreversal;

/**
 * Created by yzbkaka on 20-4-16.
 */

public class CardMatch {
    private int score = 0;
    private Card card1;
    private Card card2;
    public CardMatch(){}
    public CardMatch(Card card1,Card card2){
        this.card1 = card1;
        this.card2 = card2;
    }

    public boolean isMatch(){
        if(this.card1 == this.card2){
            score++;
            return true;
        }else {
            return false;
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
