package com.example.yzbkaka.a8;

import android.Manifest;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button start;

    private EditText hour;

    private EditText minute;

    private String hourTime;

    private String minuteTime;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = (Button)findViewById(R.id.start);
        hour = (EditText)findViewById(R.id.hour);
        minute = (EditText)findViewById(R.id.minute);



        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hourTime = hour.getText().toString();
                minuteTime = minute.getText().toString();
                Calendar calendar = Calendar.getInstance();
                int systemHour = calendar.get(Calendar.HOUR_OF_DAY);
                int systemMinute = calendar.get(Calendar.MINUTE);

                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                int time = (Integer.valueOf(hourTime) - systemHour) * 60 * 60 +(Integer.valueOf(minuteTime) - systemMinute) * 60;
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0,intent,0);
                alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,time,pi);
                Toast.makeText(MainActivity.this, "闹钟设置成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
