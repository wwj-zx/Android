package com.example.yzbkaka.a1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView cardText;

    private LinearLayout cardLayout;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cardText = (TextView)findViewById(R.id.card_text);
        cardText.setTextColor(Color.RED);
        cardLayout = (LinearLayout)findViewById(R.id.card_layout);
        cardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count % 2 == 0){
                    cardText.setText("红桃A");
                    cardText.setTextColor(Color.RED);
                }else {
                    cardText.setText("黑桃B");
                    cardText.setTextColor(Color.GRAY);
                }
                count++;
            }
        });
    }
}
