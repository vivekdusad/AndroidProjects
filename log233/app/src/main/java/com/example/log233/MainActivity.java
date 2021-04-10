package com.example.log233;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void clickedButton(View view){
        EditText myEditText = (EditText) findViewById(R.id.myEditText);
        EditText myEditTextPassword = (EditText) findViewById(R.id.myEditTextPassword);
        Log.i("Info",myEditText.getText().toString());
        Log.i("Info",myEditTextPassword.getText().toString());
        Toast.makeText(this, myEditText.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
