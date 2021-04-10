package com.example.currencyconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public void Convert(View view){
        EditText text = (EditText) findViewById(R.id.editText);
        double d= Double.parseDouble(text.getText().toString());
        double curr = d*75.83;
        String total2 = Double.toString(curr);
        Log.i("Amount in dollars:",total2);
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
