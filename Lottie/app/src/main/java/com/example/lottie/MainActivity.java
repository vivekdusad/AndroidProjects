package com.example.lottie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    boolean saved = true;
    boolean liked = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LottieAnimationView lottieAnimationView = findViewById(R.id.animationView);
        final LottieAnimationView likeAnimationView = findViewById(R.id.like);
        lottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(saved){
                    lottieAnimationView.setSpeed((float) -0.5);
                    lottieAnimationView.playAnimation();
                    Toast.makeText(MainActivity.this, "Dissaved", Toast.LENGTH_SHORT).show();
                    saved  = false;
                }
                else{
                    lottieAnimationView.setSpeed((float) 0.5);
                    lottieAnimationView.playAnimation();
                    Toast.makeText(MainActivity.this, "saved", Toast.LENGTH_SHORT).show();
                    saved = true;
                }

            }
        });
        likeAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(liked){
                    likeAnimationView.setSpeed((float) 0.5);
                    likeAnimationView.playAnimation();
                    Toast.makeText(MainActivity.this, "liked", Toast.LENGTH_SHORT).show();
                    liked  = false;
                }
                else{
                    likeAnimationView.setSpeed((float) -0.5);
                    likeAnimationView.playAnimation();
                    Toast.makeText(MainActivity.this, "Disliked", Toast.LENGTH_SHORT).show();
                    liked = true;
                }

            }
        });
    }
}
