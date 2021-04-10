package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {
    MediaPlayer music;
    SeekBar timerSeek;
    TextView textView;
    Button start;
    int times ;
    CountDownTimer count_down;
    boolean songState =false;
    public void Start(View view){
          start = (Button) findViewById(R.id.button);


        if(songState){

            songState =true;

            count_down.cancel();
            textView.setText("00:00");


        }
        else{

         count_down = new CountDownTimer(timerSeek.getProgress() * 1000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                times = (int) millisUntilFinished/1000;
                updateTimer(times);
                start.setText("stop");
            }

            @Override
            public void onFinish() {
                music.start();
                start.setText("start");

            }
        };
         songState = false;


        }
    }
    public void updateTimer(int i)
    {
        int minutes = i/60;
        int seconds = i - minutes*60;
        String secondStirng = Integer.toString(seconds);
        textView = (TextView) findViewById(R.id.timerView);
        if(seconds<=9){
            secondStirng  = "0"+Integer.toString(seconds);
        }
        String time = Integer.toString(minutes) + ":" +secondStirng;
        textView.setText(time);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music = MediaPlayer.create(this,R.raw.bensound);
        timerSeek = (SeekBar) findViewById(R.id.seekBar);
        timerSeek.setMax(600);
        timerSeek.setProgress(30);
        timerSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
