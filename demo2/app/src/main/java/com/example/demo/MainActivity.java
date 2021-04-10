package com.example.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FirebaseDatabase database;
    DatabaseReference myRef;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListner;
    String Email;
    EditText emailText;
    EditText passwordText;
    String PASSWORD;
    TextView statusView;
    ProgressBar progressBar;
    Button verifyEmail;
    Button SignInButton;
    Button SignOutButton;
    Button ReloadButton;
    public void showProgressBar(){
        if(progressBar != null){
            progressBar.setVisibility(View.VISIBLE);
        }
    }
    public void hideProgressBar(){
        if(progressBar != null){
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        statusView = findViewById(R.id.textStatus);
        verifyEmail = (Button) findViewById(R.id.buttonVeify);
        emailText = (EditText) findViewById(R.id.editTextTextPersonName);
        passwordText = (EditText) findViewById(R.id.editTextTextPassword);
        verifyEmail.setOnClickListener(this);
        SignInButton = findViewById(R.id.button);
        SignOutButton = findViewById(R.id.button2);
        ReloadButton = findViewById(R.id.button3);
        SignOutButton.setOnClickListener(this);
        SignInButton.setOnClickListener(this);
        ReloadButton.setOnClickListener(this);
    }

    @Override
    public void onStart() {

        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);

    }
    public void createAccount(String email,String password){
        showProgressBar();
        if(!validateForm()){
            return;
        }
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    Toast.makeText(MainActivity.this, "User created", Toast.LENGTH_SHORT).show();
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                }
                else{
                    Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
                hideProgressBar();
            }
        });
    }
    public void signIn(String email,String password){
        if(!validateForm()){
            return;
        }
        showProgressBar();
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Sign in succesfully", Toast.LENGTH_SHORT).show();
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                }
                else{
                    Toast.makeText(MainActivity.this, "Signed in succesfully", Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
                if( !task.isSuccessful()){
                    statusView.setText("Failed");

                }
                hideProgressBar();
            }
        });
    }
    public void signOut(){
        mAuth.signOut();
        updateUI(null);
    }
    private void sendEmailVerification(){
        verifyEmail.setEnabled(false);
        showProgressBar();
        FirebaseUser user = mAuth.getCurrentUser();
        user.sendEmailVerification().addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Send succesfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
                }
                hideProgressBar();
            }
        });

    }
    public void reload(){
        mAuth.getCurrentUser().reload().addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "reloaded", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    private void updateUI(FirebaseUser User) {




    }
    private boolean validateForm() {
        boolean valid = true;
        Email = emailText.getText().toString();
        PASSWORD = passwordText.getText().toString();
        if(Email.equals("")){
            emailText.setError("Required");
            valid = false;
        }
        else{
            emailText.setError(null);
        }
        if(PASSWORD.equals("")){
            passwordText.setError("Required");
            valid = false;
        }
        else{
            passwordText.setError(null);
        }
    return valid;
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button){
            //Sign in
            signIn(emailText.getText().toString(),passwordText.getText().toString());
        }
        else if(v.getId() == R.id.button2){
            signOut();
        }
        else if(v.getId() == R.id.button3){
            reload();
        }
        else{
            sendEmailVerification();
        }

    }
}
