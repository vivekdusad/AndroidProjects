package com.example.toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username;
    EditText password;
    boolean singnInState = true;
    TextView Switchbutton;
    public void showUserList()
    {
        Intent intent = new Intent(this,userfeedActivity.class);
        startActivity(intent);

    }
    public void SignIn(View view ){
        String USERNAME = username.getText().toString();
        String PASSWORD = username.getText().toString();
        if(singnInState) {
            ParseUser user = new ParseUser();
            user.setUsername(USERNAME);
            user.setPassword(PASSWORD);
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {

                        Toast.makeText(MainActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                        Intent inSignup = new Intent(getApplicationContext(),userfeedActivity.class);
                        startActivity(inSignup);

                    }
                    else{
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else{
            ParseUser.logInInBackground(USERNAME, PASSWORD, new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    Toast.makeText(MainActivity.this, "logined succesfully", Toast.LENGTH_SHORT).show();
                    Intent inLogin = new Intent(getApplicationContext(),userfeedActivity.class);
                    startActivity(inLogin);
                }
            });
        }

    }
    public void Onclick(View view){
        if(view.getId() == R.id.switchId){
            if(singnInState){
                Switchbutton.setText("Register");
                singnInState = false;
            }
            else{
                Switchbutton.setText("Login");
                singnInState = true;
            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         username = (EditText)findViewById(R.id.UsernameEditText);
        password = (EditText)findViewById(R.id.Password);
        Switchbutton = findViewById(R.id.switchId);
        Switchbutton.setOnClickListener(this);
//        if(ParseUser.getCurrentUser() != null){
//            showUserList();
//        }
        ParseAnalytics.trackAppOpenedInBackground(getIntent());

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.switchId){
            if(singnInState){
                Switchbutton.setText("Register");
                singnInState = false;

            }
            else{
                Switchbutton.setText("Login");
                singnInState = true;
            }
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
