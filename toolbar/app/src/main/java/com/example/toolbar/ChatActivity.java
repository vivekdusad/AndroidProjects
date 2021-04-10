package com.example.toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    RecyclerView recyclerView;
     private RecyclerView.Adapter adapter;
    List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat2);
        recyclerView = findViewById(R.id.recyclarView);
//        adapter = new AdapterClass(this,);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();
        for(int i =0;i<10;i++){
            ListItem item = new ListItem("Disha"+(i+1));
            listItems.add(item);
        }
        adapter = new AdapterClass(this, listItems);
        recyclerView.setAdapter(adapter);


    }
}
