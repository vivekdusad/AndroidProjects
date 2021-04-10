package com.example.jsondata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    public class downloadJson extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                String result = "";
                while(data != -1 ){
                    result += (char)data;
                }
                return result;
            }catch (Exception e){
                return null;

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String string ;
        try {
            downloadJson task = new downloadJson();

            string = task.execute("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02").get();
            Pattern p = Pattern.compile("https://(.*?)/data/2.5");
            Matcher m = p.matcher(string);
            while(m.find()){
                System.out.println(m.group());
            }
        }
        catch (Exception e){
            e.printStackTrace();

        }

    }
}
