package com.example.log;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {



    public void clickFunction(View view)
    {
        EditText myTextFeild = (EditText) findViewById(R.id.myTextFeild);
        Log.i("vivek","myTextFeild.getText().toString()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
