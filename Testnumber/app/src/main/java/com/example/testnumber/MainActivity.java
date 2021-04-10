package com.example.testnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    class Testnumber {
        int number;

        public boolean isTringular() {
            int n = 0;
            int tringNum = 0;
            while (tringNum <= number) {
                tringNum = n * (n + 1) / 2;
                if (tringNum == number) {
                    return true;
                }
                n++;


            }
            return false;
        }

        public boolean isSquare() {
            double sq = Math.sqrt(number);
            if (sq == (int) sq) {
                return true;
            } else {
                return false;
            }
        }
    }
    public void Test(View view)
    {
        String message;
        Testnumber testnumber = new Testnumber();
//        testnumber.number=14;
        EditText editText = (EditText) findViewById(R.id.testnum);
        int num = Integer.parseInt(editText.getText().toString());
        testnumber.number = num;
        message = editText.getText().toString();
        if(testnumber.isTringular()&&testnumber.isSquare())
        {
//            System.out.println("given no. is tringular and square");
            message += " is tringular and square no.";

        }
        else if(testnumber.isSquare())
        {
//            System.out.println("given no. is square");
            message +=" is a Square no.";
        }
        else if(testnumber.isTringular()){
//            System.out.println("given no. is tringular");
            message +=" is a tringular no.";
        }
        else {
//            System.out.println("given no. is not tringular nor square");
            message +=" is not tringular nor square no.";
        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }



        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
