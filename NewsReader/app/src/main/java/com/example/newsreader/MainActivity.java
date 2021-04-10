package com.example.newsreader;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> titles = new ArrayList<>();
    ArrayList<String> Urls = new ArrayList<>();
    SQLiteDatabase newsDatabase;
    ArrayAdapter arrayAdapter;
    public class JsonApiDownloader extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... urls) {
            String result = " ";

            try{
                URL url;
                HttpsURLConnection urlConnection = null;

                url = new URL(urls[0]);
                 urlConnection = (HttpsURLConnection)url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while(data!=  -1){
                    char current = (char)data;
                    result = result+current;
                    data = reader.read();

                }
                JSONArray jsonArray = new JSONArray(result);
                int numberofItems = 10;
                newsDatabase.execSQL("DELETE FROM NEWS");
                if(jsonArray.length()<10){
                    numberofItems = jsonArray.length();

                }

                for(int i = 0;i<numberofItems;i++) {
                    String ArticleInfo = "";
                    String articleid = jsonArray.getString(i);
                    url = new URL("https://hacker-news.firebaseio.com/v0/item/"+articleid+".json?print=pretty");
                    urlConnection = (HttpsURLConnection)url.openConnection();
                     in = urlConnection.getInputStream();
                     reader = new InputStreamReader(in);
                     data = reader.read();
                    while(data!=  -1){
                        char current = (char)data;
                        ArticleInfo = ArticleInfo+current;
                        data = reader.read();

                    }
                    Log.i("api",ArticleInfo);
                    JSONObject jsonObject = new JSONObject(ArticleInfo);
                    if(!jsonObject.isNull("title")&&!jsonObject.isNull("url")&&!jsonObject.isNull("url") ){
                        String titleofNews = jsonObject.getString("title");
                        String urlofNews = jsonObject.getString("url");

                        url = new URL(urlofNews);
                        urlConnection = (HttpsURLConnection)url.openConnection();
                        in = urlConnection.getInputStream();
                        reader = new InputStreamReader(in);
                        data = reader.read();
                        String HtMl = "";
                        while(data!=  -1){
                            char current = (char)data;
                            HtMl = HtMl+current;
                            data = reader.read();

                        }
                        Log.i("HTML",HtMl);
                        String sqlStatement = "INSERT INTO NEWS (title,content) VALUES (?,?)";
                        SQLiteStatement statement = newsDatabase.compileStatement(sqlStatement);


//                        statement.bindString(1,articleid);
                        statement.bindString(1,titleofNews);
                        statement.bindString(2,HtMl);
                        statement.execute();




                    }





                }
                return result;
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }


        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            updateListView();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         newsDatabase = this.openOrCreateDatabase("News",MODE_PRIVATE,null);
        newsDatabase.execSQL("CREATE  TABLE IF NOT EXISTS NEWS (title VARCHAR,content VARCHAR)");
        updateListView();

        listView = findViewById(R.id.listview);

        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,titles);
        listView.setAdapter(arrayAdapter);
        JsonApiDownloader downloader = new JsonApiDownloader();
          downloader.execute("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty");




    }
    public void updateListView() {
        Cursor c = newsDatabase.rawQuery("SELECT * FROM NEWS", null);

        int columnIndex = c.getColumnIndex("title");
        int rowIndex = c.getColumnIndex("content");

        if (c.moveToFirst()) {
            titles.clear();
            Urls.clear();

            do {
                titles.add(c.getString(columnIndex));
                Urls.add(c.getString(rowIndex));
            }
            while (c.moveToFirst());
            {
                arrayAdapter.notifyDataSetChanged();
            }
        }
    }
}

