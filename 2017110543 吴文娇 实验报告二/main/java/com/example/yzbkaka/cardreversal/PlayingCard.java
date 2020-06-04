package com.example.yzbkaka.cardreversal;

import com.example.yzbkaka.cardreversal.Card;

import java.util.Arrays;

/**
 * Created by yzbkaka on 20-4-16.
 */

public class PlayingCard extends Card{

    private String suit;

    private int rank;

    public String getSuit() {
        return suit;
    }

    public void setSuit(String aSuit){
        if (Arrays.asList(PlayingCard.validSuits()).contains(aSuit)){
            suit = aSuit;
        }
    }

    public static String[] validSuits(){
        return new String[]{"♠︎","♣︎","♥︎","♦︎"};
    }

    public int getRank(){ return rank; }
    public void setRank(int aRank){
        if(aRank <= PlayingCard.maxRank()){
            rank = aRank;
        }
    }

    private static String[] rankStrings(){
        return new String[]{"?","A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    }

    public static int maxRank(){
        return PlayingCard.rankStrings().length - 1;
    }

    @Override
    public String getContents(){
        return PlayingCard.rankStrings()[rank] + suit;
    }
}
