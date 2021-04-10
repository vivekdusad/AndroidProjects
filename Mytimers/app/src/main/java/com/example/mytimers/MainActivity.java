package com.example.mytimers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView  display ;
    SeekBar seekBar ;
    Button button;

    boolean timerStatus = true;
    public void displaytime(int seconds)
    {

        int minutes = seconds/60;
        String secondSeconds;
        int second = seconds-(minutes*60);
        if(second<=9)
        {
            secondSeconds = "0"+Integer.toString(second);
        }
        else{
            secondSeconds = Integer.toString(second);
        }
        display.setText(Integer.toString(minutes)+":"+secondSeconds);




    }
    public void clicked(View view) {

        CountDownTimer timer;


            button.setText("stop");
             timer = new CountDownTimer(seekBar.getProgress() * 1000 , 1000) {
                @Override
                public void onTick(long millisUntilFinished) {


                    displaytime((int) millisUntilFinished / 1000);
                    seekBar.setEnabled(false);
                }

                @Override
                public void onFinish() {
                    seekBar.setEnabled(true);
                    seekBar.setProgress(30);
                    button.setText("start again!");
                    display.setText("00:30");


                }
            };
             if(timerStatus){
                 timer.start();
                 button.setText("stop");
                 timerStatus = false;

        }
        else{
            timerStatus = true;
            button.setText("start");
            timer.cancel();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView)findViewById(R.id.textView);
         button = (Button)findViewById(R.id.button);
        button.setText("start");
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(600);
        seekBar.setProgress(30);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                displaytime(progress);


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
