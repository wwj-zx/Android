package com.example.yzbkaka.cardreversal;

/**
 * Created by yzbkaka on 20-4-16.
 */

public abstract class Card {

    private boolean chosen;

    private boolean matched;

    public abstract String getContents();

    public boolean isChosen() { return chosen; }

    public boolean isMatched() { return matched; }

}
