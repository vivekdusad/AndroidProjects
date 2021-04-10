package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;//class

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view){
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        Log.i("Info","button pressed");
        Toast.makeText(this,"hi! there "+ editText2.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
