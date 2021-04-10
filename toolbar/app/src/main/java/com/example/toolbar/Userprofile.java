package com.example.toolbar;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseUser;

public class Userprofile extends Fragment {
    TextView textView;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.userprofile_fragment, container, false);
        textView = view.findViewById(R.id.LogoutTextview);
        ParseUser user = ParseUser.getCurrentUser();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.logOut();
                Intent i = new Intent(getContext(),MainActivity.class);
                startActivity(i);
            }
        });

        return view;


    }
}


