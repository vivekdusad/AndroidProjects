package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int player = 0;//0 : yellow ; 1 : red ; 2 : empty;
    int[] checkcolour = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] wins = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {0, 4, 8}, {2, 4, 6},};
    boolean gamestate = true;
    String winning;

    public void click(View view) {
        TextView winningmessage = (TextView) findViewById(R.id.WinningtextView);


        Button plyagain = (Button) findViewById(R.id.playagain);
        plyagain.setVisibility(View.INVISIBLE);
        winningmessage.setVisibility(View.INVISIBLE);


        int tg = Integer.parseInt(view.getTag().toString());
        Log.i("tag", view.getTag().toString());
        if (checkcolour[tg] == 2&&gamestate==true) {
            checkcolour[tg] = player;


            ImageView imageView = (ImageView) view;

            if (player == 0) {
                imageView.setImageResource(R.drawable.yellow);
                player = 1;
            } else {
                imageView.setImageResource(R.drawable.red);
                player = 0;
            }

//        imageView.animate().translationYBy(1000).setDuration(3000);
//        System.out.println(checkcolour[wins[1]]);
            for (int i = 0; i < 6; i++) {
                if (checkcolour[wins[i][0]] == checkcolour[wins[i][1]] && checkcolour[wins[i][1]] == checkcolour[wins[i][2]]) {
                    for (int j = 0; j < 3; j++) {
                        if (checkcolour[wins[i][j]] != 2) {
                            if (player == 1) {
                                 winning = "Yellow";
                                gamestate = false;
                                winningmessage.setText(winning+" has won the game");

                                plyagain.setVisibility(View.VISIBLE);
                                winningmessage.setVisibility(View.VISIBLE);
                            } else {
                                 winning = "Red";
                                gamestate = false;
                                winningmessage.setText(winning+" has won the game");

                                plyagain.setVisibility(View.VISIBLE);
                                winningmessage.setVisibility(View.VISIBLE);
                            }




                        }
                    }
                }

            }
        }

    }
    public void playAgain(View view){
        TextView winningmessage = (TextView) findViewById(R.id.WinningtextView);

        winningmessage.setVisibility(View.INVISIBLE);
        Button plyagain = (Button) findViewById(R.id.playagain);
        plyagain.setVisibility(View.INVISIBLE);
        GridLayout grid = (GridLayout) findViewById(R.id.gridLayout);

        for(int i=0;i<grid.getChildCount();i++){
            ImageView imageView = (ImageView) grid.getChildAt(i);
            imageView.setImageDrawable(null);
        }
         for(int i=0;i<8;i++)
         {
             checkcolour[i] = 2;
         }
         player = 0;
        gamestate = true;

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

