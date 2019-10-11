package com.example.rockpaperscrissors;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnR, btnP, btnS;
    private TextView result, standing;
    private ImageView imagePC, imagePlayer, PC1, PC2, PC3, Player1, Player2, Player3;
    private Random rnd;
    private int pointsPC, pointsPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnR.setOnClickListener(this);
        btnP.setOnClickListener(this);
        btnS.setOnClickListener(this);


    }

    public void init()
    {
        btnR = findViewById(R.id.btnR);
        btnP = findViewById(R.id.btnp);
        btnS = findViewById(R.id.btns);
        result = findViewById(R.id.TextResult);
        standing = findViewById(R.id.TextStanding);
        imagePC = findViewById(R.id.ImagePC);
        imagePlayer = findViewById(R.id.ImagePlayer);
        PC1 = findViewById(R.id.PC1);
        PC2 = findViewById(R.id.PC2);
        PC3 = findViewById(R.id.PC3);
        Player1 = findViewById(R.id.Player1);
        Player2 = findViewById(R.id.Player2);
        Player3 = findViewById(R.id.Player3);

        rnd = new Random();
        pointsPC = 0;
        pointsPlayer = 0;
    }

    @Override
    public void onClick(View v) {
        String playersChoice = "";
        switch (v.getId())
        {
            case R.id.btnR:
                playersChoice = "rock";
                imagePlayer.setImageResource(R.drawable.rock);
                break;
            case R.id.btnp:
                playersChoice = "paper";
                imagePlayer.setImageResource(R.drawable.paper);
                break;
            case R.id.btns:
                playersChoice = "scissors";
                imagePlayer.setImageResource(R.drawable.scissors);
                break;
        }
        int random = rnd.nextInt(3);
        String pcChoice = "";
        switch (random)
        {
            case 0:
                pcChoice = "rock";
                imagePC.setImageResource(R.drawable.rock);
                break;
            case 1:
                pcChoice = "paper";
                imagePC.setImageResource(R.drawable.paper);
                break;
            case 2:
                pcChoice = "scissors";
                imagePC.setImageResource(R.drawable.scissors);
                break;
        }
        String text = "";


        if (pcChoice.equals("rock") && playersChoice.equals("paper"))
        {
            pointsPlayer++;
            text = "Paper is better!";
            PCHP();
        }
        else if (pcChoice.equals("rock") && playersChoice.equals("scissors"))
        {
            pointsPC++;
            text = "Rock breaks scissors!";
            PlayerHP();
        }
        else if (pcChoice.equals("paper") && playersChoice.equals("rock"))
        {
            pointsPC++;
            text = "Paper is better!";
            PlayerHP();
        }
        else if (pcChoice.equals("paper")&& playersChoice.equals("scissors"))
        {
            pointsPlayer++;
            text = "Scissors cuts paper!";
            PCHP();
        }
        else if (pcChoice.equals("scissors") && playersChoice.equals("rock"))
        {
            pointsPlayer++;
            text = "Rock breaks scissors!";
            PCHP();
        }
        else if (pcChoice.equals("scissors") && playersChoice.equals("paper"))
        {
            pointsPC++;
            text = "Scissors cuts paper!";
            PlayerHP();
        }
        else if (pcChoice.equals(playersChoice))
        {
            text = "Both chose the same thing!";
        }
        standing.setText(String.format("Computer %d | %d Player",pointsPC,pointsPlayer));
        result.setText(text);
    }
    public void PCHP()
    {
        if (pointsPlayer == 1)
        {
            PC1.setImageResource(R.drawable.hp_lost);
        }
        if (pointsPlayer == 2)
        {
            PC2.setImageResource(R.drawable.hp_lost);
        }
        if (pointsPlayer == 3)
        {
            PC3.setImageResource(R.drawable.hp_lost);
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Congratulations");
            alertDialog.setMessage("You won the game! Do you want to play one more?");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "PLAY AGAIN",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Intent main_activity = new Intent(MainActivity.this,MainActivity.class);
                            finish();
                            startActivity(main_activity);
                        }
                    });
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "EXIT",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                            System.exit(0);
                        }
                    });
            alertDialog.show();
        }


    }
    public void PlayerHP()
    {
        if (pointsPC == 1)
        {
            Player1.setImageResource(R.drawable.hp_lost);
        }
        if (pointsPC == 2)
        {
            Player2.setImageResource(R.drawable.hp_lost);
        }
        if (pointsPC == 3)
        {
            Player3.setImageResource(R.drawable.hp_lost);
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("GAME OVER");
            alertDialog.setMessage("The computer beat you! Do you want to try again?");
            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "PLAY AGAIN",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Intent main_activity = new Intent(MainActivity.this,MainActivity.class);
                            finish();
                            startActivity(main_activity);
                        }
                    });
            alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "EXIT",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                            System.exit(0);
                        }
                    });
            alertDialog.show();
        }


    }
}
