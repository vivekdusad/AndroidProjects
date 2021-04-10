package com.example.audio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MediaPlayer music;
    AudioManager audioManager;

    public void play(View view){
        music.start();
    }
    public void pause(View view){
        music.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        music = MediaPlayer.create(this,R.raw.bensound);
        int max_Volume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int current_volume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        SeekBar volumeControl = (SeekBar) findViewById(R.id.seekBar);
        final SeekBar songState = (SeekBar) findViewById(R.id.seekBar2);
        volumeControl.setProgress(current_volume);
        volumeControl.setMax(max_Volume);
        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        songState.setMax(music.getDuration());
        songState.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                music.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                music.pause();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                music.start();

            }
        });
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                songState.setProgress(music.getCurrentPosition());

            }
        },0,1000);


    }
}
