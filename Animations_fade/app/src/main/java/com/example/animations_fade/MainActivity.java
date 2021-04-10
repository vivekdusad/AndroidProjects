package com.example.animations_fade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
   boolean bartisShowing = true;
    public void bart(View view)
    {
        ImageView imagebart = (ImageView) findViewById(R.id.bartImageview);

        ImageView imagehomer = (ImageView) findViewById(R.id.homerImageview);


        if(bartisShowing){
            bartisShowing = false;
            imagebart.animate().alpha(0).setDuration(2000);
            imagehomer.animate().alpha(1).setDuration(2000);
        }
        else
        {
            bartisShowing = true;
            imagebart.animate().alpha(1).setDuration(2000);
            imagehomer.animate().alpha(0).setDuration(2000);


        }



    }
//    public void homer(View view)
//    {
//        ImageView imagebart = (ImageView) findViewById(R.id.bartImageview);
//
//        ImageView imagehomer = (ImageView) findViewById(R.id.homerImageview);
//
//        imagehomer.animate().alpha(0).setDuration(4000);
//        imagebart.animate().alpha(1).setDuration(4000);
//
//        ImageView imagehomer = (ImageView) findViewById(R.id.homerImageview);
//        imagehomer.animate().alpha(0).setDuration(2000);
//        ImageView imagebart = (ImageView) findViewById(R.id.bartImageview);
//        imagebart.animate().alpha(1).setDuration(2000);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imagebart = (ImageView) findViewById(R.id.bartImageview);
        imagebart.animate().translationXBy(-1000).scaleX(0.5f);
        imagebart.animate().rotation(360).translationXBy(1000).scaleX(1f).setDuration(2000);

    }
}
