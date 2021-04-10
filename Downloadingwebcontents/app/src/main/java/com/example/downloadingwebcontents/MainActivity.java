package com.example.downloadingwebcontents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    public class DownloadingTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            URL url;
            HttpURLConnection urlConnection = null;
            String result = "";

            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();

                while (data!= -1) {
                    char current = (char) data;
                    result += current;
                }
                return  result;



            } catch (IOException e) {
                e.printStackTrace();
                return "failed";
            }


            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DownloadingTask task = new DownloadingTask();
        String result = null;
        try {
            result = task.execute("https://www.google.co.in/?gfe_rd=cr&ei=H-6ZU6bDMZGCoAOMu4HQAQ&gws_rd=ssl").get();
            Log.i("html",result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
