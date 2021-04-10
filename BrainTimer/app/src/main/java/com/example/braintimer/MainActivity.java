package com.example.braintimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView2;
    TextView textView;

    public void go(View view){
        Button button = (Button)findViewById(R.id.button);
        button.setVisibility(View.INVISIBLE);

        textView.setVisibility(View.VISIBLE);

        textView2.setVisibility(View.VISIBLE);
        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);
        gridLayout.setVisibility(View.VISIBLE);
        CountDownTimer timer = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int)millisUntilFinished);
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Game over", Toast.LENGTH_SHORT).show();

            }
        }.start();


    }
    public void updateTimer(int seconds){
        int second = seconds/1000;
        textView2.setText(Integer.toString(second));

    }
    public void changeQuestion(){
        textView.setText("10+10");

    }
    public void click(View view) {
        Button button1 = (Button) view;
        int tag = Integer.parseInt(view.getTag().toString());
        if (tag == 4) {
            Toast.makeText(this, "Correct answer", Toast.LENGTH_SHORT).show();
            changeQuestion();

        } else if (tag != 0) {
            Toast.makeText(this, "wrong answer", Toast.LENGTH_SHORT).show();
            changeQuestion();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView2 = findViewById(R.id.textView2);
        textView= findViewById(R.id.textView);
    }
}
