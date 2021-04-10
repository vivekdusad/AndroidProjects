package com.example.parseproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnKeyListener {
    EditText username;
    EditText password;
    String PASSWORD;
    String USERNAME;
    TextView textView;
    Boolean SignupButtonactive = true;
    Button signupButton;


    public void showUserList()
    {
        Intent intent = new Intent(this,userActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
            signIn(v);
        }

        return false;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.switchid){
            if(SignupButtonactive){
                SignupButtonactive = false;
                signupButton.setText("Login in");
                textView.setText("or,Sign in ");

            }
            else{
                SignupButtonactive = true;
                signupButton.setText("Sign in ");
                textView.setText("or,Login in");
            }

        }
        else if(v.getId() == R.id.layout){
            InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);


        }

    }
   public void signIn(View view){
       if(username.getText()!= null&& password.getText() != null){
            PASSWORD = password.getText().toString();
            USERNAME = username.getText().toString();
            if(SignupButtonactive) {
                ParseUser parseUser = new ParseUser();
                parseUser.setUsername(USERNAME);
                parseUser.setPassword(PASSWORD);
                parseUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(MainActivity.this, "Sign UP succesfully", Toast.LENGTH_SHORT).show();
                            showUserList();
                        } else {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
            else{
                ParseUser.logInInBackground(USERNAME, PASSWORD, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(e ==  null) {
                            Toast.makeText(MainActivity.this, "Login succesfully", Toast.LENGTH_SHORT).show();
                            showUserList();
                        }
                        else {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                }

                });
            }



       }

   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(ParseUser.getCurrentUser() != null){
            showUserList();
        }
        username = (EditText)findViewById(R.id.usernameText);
        ConstraintLayout layout = findViewById(R.id.layout);
        layout.setOnClickListener(this);
        password = (EditText) findViewById(R.id.passwordText);
        signupButton = (Button)findViewById(R.id.SignInButton);
        password.setOnKeyListener(this);
        textView = findViewById(R.id.switchid);
        textView.setOnClickListener(this);
        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }


}
