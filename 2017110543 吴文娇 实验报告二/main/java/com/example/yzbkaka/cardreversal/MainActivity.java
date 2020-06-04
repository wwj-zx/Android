package com.example.yzbkaka.cardreversal;

import android.graphics.Canvas;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView cardText1;

    private LinearLayout cardLayout1;

    private TextView frontBack1;

    private TextView cardText2;

    private LinearLayout cardLayout2;

    private TextView frontBack2;

    private PlayingDeck playingDeck;

    private int count1 = 0;

    private int count2 = 0;

    private int score = 0;

    private TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardText1 = (TextView)findViewById(R.id.card_text1);
        cardLayout1 = (LinearLayout) findViewById(R.id.card_layout1);
        frontBack1 = (TextView)findViewById(R.id.front_back1);

        cardText2 = (TextView)findViewById(R.id.card_text2);
        cardLayout2 = (LinearLayout) findViewById(R.id.card_layout2);
        frontBack2 = (TextView)findViewById(R.id.front_back2);
        playingDeck = new PlayingDeck();
        scoreText = (TextView)findViewById(R.id.score);

        final CardMatch cardMatch = new CardMatch();

        cardLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count1 % 2 == 0){
                    cardText1.setVisibility(View.INVISIBLE);
                    frontBack1.setText("反面");
                }else{
                    cardText1.setVisibility(View.VISIBLE);
                    Card card = playingDeck.drawRandomCard();
                    if(card != null) cardText1.setText(card.getContents());
                    frontBack1.setText("正面");
                    if(cardText1.getText().equals(cardText2.getText())) {
                        cardMatch.setScore(++score);
                        scoreText.setText(cardMatch.getScore());
                    }
                }
                count1++;
            }
        });

        cardLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count2 % 2 == 0){
                    cardText2.setVisibility(View.INVISIBLE);
                    frontBack2.setText("反面");
                }else{
                    cardText2.setVisibility(View.VISIBLE);
                    Card card = playingDeck.drawRandomCard();
                    if(card != null) cardText2.setText(card.getContents());
                    frontBack2.setText("正面");
                    if(cardText1.getText().equals(cardText2.getText())) {
                        cardMatch.setScore(++score);
                        scoreText.setText(cardMatch.getScore());
                    }
                }
                count2++;
            }
        });
    }
}
