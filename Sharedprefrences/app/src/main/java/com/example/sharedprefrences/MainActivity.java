package com.example.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> username = new ArrayList<>();
        username.add("vivek");
        username.add("swagatRaj");
        username.add("suryanshdiwadi");

        SharedPreferences sharedPreferences = this.getSharedPreferences("package com.example.sharedprefrences", Context.MODE_PRIVATE);
        try {
            sharedPreferences.edit().putString("username",ObjectSerializer.serialize(username)).apply();
            ArrayList<String> usernames = new ArrayList<>();
             usernames = (ArrayList)ObjectSerializer.deserialize(sharedPreferences.getString("username",ObjectSerializer.serialize(new ArrayList<String>())));
            Log.i("This is username",usernames.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
