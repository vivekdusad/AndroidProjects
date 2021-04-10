package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void sendnow(View view){
        Toast.makeText(this, "+ operation is going on", Toast.LENGTH_SHORT).show();
    }
    public void clearing(View view){
        Toast.makeText(this, "clearing text from calculator", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
