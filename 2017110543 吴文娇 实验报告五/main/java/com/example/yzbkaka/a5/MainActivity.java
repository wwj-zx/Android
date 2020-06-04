package com.example.yzbkaka.a5;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    private int progress = 0;

    private TextView progressText;

    public static final int UPDATE_TEXT = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressText = (TextView)findViewById(R.id.progress_text);
        DownLoadTask downLoadTask = (DownLoadTask) new DownLoadTask(this).execute();
    }

}
