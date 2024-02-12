package com.example.valentines;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private ImageView diceImageView1, diceImageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        diceImageView1 = findViewById(R.id.diceImageView1);
        diceImageView2 = findViewById(R.id.diceImageView2);
    }

    public void onColorButtonClick(View view) {
        Button clickedButton = (Button) view;
        String selectedColor = clickedButton.getText().toString();
        // Do something with the selected color
        resultTextView.setText("Selected color: " + selectedColor);
    }

    public void onRollButtonClick(View view) {
        // Generate two random numbers between 1 and 6 (inclusive) to simulate rolling two dice
        Random random = new Random();
        int diceResult1 = random.nextInt(6) + 1;
        int diceResult2 = random.nextInt(6) + 1;

        // Display the dice results
        diceImageView1.setImageResource(getDiceImageResource(diceResult1));
        diceImageView1.setVisibility(View.VISIBLE);
        diceImageView2.setImageResource(getDiceImageResource(diceResult2));
        diceImageView2.setVisibility(View.VISIBLE);

        // Display the result text
        resultTextView.setText("Dice rolled: " + diceResult1 + " and " + diceResult2);
    }

    // Method to get the corresponding dice image resource based on the dice result
    private int getDiceImageResource(int diceResult) {
        switch (diceResult) {
            case 1:
                return R.drawable.dice_1;
            case 2:
                return R.drawable.dice_2;
            case 3:
                return R.drawable.dice_3;
            case 4:
                return R.drawable.dice_4;
            case 5:
                return R.drawable.dice_5;
            case 6:
                return R.drawable.dice_6;
            default:
                return R.drawable.dice_1; // Default image if the result is invalid
        }
    }
}
