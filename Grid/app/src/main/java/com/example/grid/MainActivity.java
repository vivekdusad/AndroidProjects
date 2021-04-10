package com.example.grid;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MediaPlayer music;
    public void plainsong(View view)
    {
//
        Button play = (Button) view;
        int tg = Integer.parseInt(view.getTag().toString());
        String lgtg = Integer.toString(tg);
        

        if(tg == 1)
        {
            music.start();
            Log.i("Button",lgtg.toString());

        }
        if(tg == 2)
        {
            music.start();
            Log.i("Button",lgtg.toString());

        }
        if(tg == 3)
        {
            music.start();
            Log.i("Button",lgtg.toString());

        }
        if(tg == 4)
        {
            music.start();
            Log.i("Button",lgtg.toString());

        }
        if(tg == 5)
        {
            music.start();
            Log.i("Button",lgtg.toString());

        }
        if(tg == 6)
        {
            music.start();
            Log.i("Button",lgtg.toString());

        }
        if(tg == 7)
        {
            music.start();
            Log.i("Button",lgtg.toString());

        }
        if(tg == 8)
        {
            music.start();
            Log.i("Button",lgtg.toString());

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music = MediaPlayer.create(this,R.raw.bensound);
    }
}
