package com.example.rockpaperscrissors;

import androidx.appcompat.app.AppCompatActivity;

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
    private ImageView imagePC, imagePlayer;
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
        }
        else if (pcChoice.equals("rock") && playersChoice.equals("scissors"))
        {
            pointsPC++;
            text = "Rock breaks scissors!";
        }
        else if (pcChoice.equals("paper") && playersChoice.equals("rock"))
        {
            pointsPC++;
            text = "Paper is better!";
        }
        else if (pcChoice.equals("paper")&& playersChoice.equals("scissors"))
        {
            pointsPlayer++;
            text = "Scissors cuts paper!";
        }
        else if (pcChoice.equals("scissors") && playersChoice.equals("rock"))
        {
            pointsPlayer++;
            text = "Rock breaks scissors!";
        }
        else if (pcChoice.equals("scissors") && playersChoice.equals("paper"))
        {
            pointsPC++;
            text = "Scissors cuts paper!";
        }
        else if (pcChoice.equals(playersChoice))
        {
            text = "Both chose the same thing!";
        }
        standing.setText(String.format("Computer %d | %d Player",pointsPC,pointsPlayer));
        result.setText(text);
    }
}
