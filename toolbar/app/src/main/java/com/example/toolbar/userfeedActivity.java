package com.example.toolbar;

import android.content.Intent;
import android.os.Bundle;




import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.parse.ParseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.MenuItem;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class userfeedActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView cameraImageView;
    ImageView ChatImageView;
    TextView LogoutTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_userfeed);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        cameraImageView = toolbar.findViewById(R.id.imageViewCamera);
        ChatImageView = toolbar.findViewById(R.id.imageView2);






        BottomNavigationView navView = findViewById(R.id.nav_view);
        final homeFragment homefragment = new homeFragment();
        final searchFragment searchfragment = new searchFragment();
        final Userprofile userfragment = new Userprofile();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment,homefragment);
        fragmentTransaction.commit();
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.navigation_home){
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment,homefragment);
                    fragmentTransaction.commit();
                }
                else if(item.getItemId() == R.id.navigation_search){
                    FragmentTransaction Transaction = getSupportFragmentManager().beginTransaction();
                    Transaction.replace(R.id.fragment,searchfragment);
                    Transaction.commit();
                }
                else if(item.getItemId() == R.id.navigation_profile){
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment,userfragment);
                    transaction.commit();
                }
                return true;
            }
        });

        cameraImageView.setOnClickListener(this);
        ChatImageView.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.imageViewCamera){
            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,camera.class);
            startActivity(intent);
        }
        else if(v.getId() == R.id.imageView2){
            Intent intent1 = new Intent(this,ChatActivity.class);
            startActivity(intent1);
        }

    }
}
