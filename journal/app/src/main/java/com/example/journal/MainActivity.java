package com.example.journal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import Adapter.firebaseAdapter;
import model.classesModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Calendar sCalendar = Calendar.getInstance();
    String dayLongName = sCalendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());
    private FirebaseDatabase mDB = FirebaseDatabase.getInstance();
    private DatabaseReference mRef= mDB.getReference().child("Monday");
    List<classesModel> list;
    classesModel model;
    firebaseAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        setUpRecyclerView();



    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    private void setUpRecyclerView() {
        FirebaseRecyclerOptions<classesModel> options = new FirebaseRecyclerOptions.Builder<classesModel>().setQuery(mRef,classesModel.class).build();
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        adapter = new firebaseAdapter(options,this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setOnButtonClik(new firebaseAdapter.onButtonClick() {
            @Override
            public void buttonClick(int position) {
                String url = adapter.getItem(position).getLink();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

}

//mRef.child("Monday").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
//                     model= dataSnapshot.getValue(classesModel.class);
//                    list.add(model);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//        Log.i(TAG,String.valueOf(list.size()));