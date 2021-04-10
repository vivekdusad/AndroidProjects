package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase myDatabase = this.openOrCreateDatabase("Events",MODE_PRIVATE,null);
        myDatabase.execSQL("CREATE TABLE IF NOT EXISTS events(name VARCHAR,year INT(4))");
//        myDatabase.execSQL("INSERT INTO events(name,year) VALUES ('BIRTHDAY PARTY',2001)");
//        myDatabase.execSQL("INSERT INTO events(name,year) VALUES ('SHAADI',2015)");
        Cursor c = myDatabase.rawQuery("SELECT * FROM events",null);
        int nameIndex = c.getColumnIndex("name");
        int yearIndex = c.getColumnIndex("year");
        c.moveToFirst();
        while(c!=null){
            Log.i("Database Events",c.getString(nameIndex)+" "+c.getString(yearIndex));
//            Log.i("Database Events years",c.getString(yearIndex));
            c.moveToNext();
        }


    }
}
