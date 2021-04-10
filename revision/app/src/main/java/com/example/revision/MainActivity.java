package com.example.revision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    int []numbers = {1,2,3,4,5,6,7,8,9,10};
ListView content;
    public void generatetimetable(int timestable)
    {
        ArrayList<String> display = new ArrayList<String>();

        for(int i=0;i<=9;i++){
            display.add(Integer.toString((i+1)*timestable));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,display);
        content.setAdapter(arrayAdapter);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timestableSeekbar = findViewById(R.id.seekBar2);
         content = findViewById(R.id.contentListView);
        timestableSeekbar.setMax(20);
        timestableSeekbar.setProgress(10);
        timestableSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timestable;
                if(progress<min){
                    timestable = min;

                }

                else{
                    timestable = progress;
                }
                generatetimetable(timestable);


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
