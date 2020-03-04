package com.example.individualprojectcsc490;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.individualprojectcsc490.Calculators.*;

public class CalculatorsPage extends AppCompatActivity {

    private Button FIRENumberButton;
    private Button savingsRateButton;
    private Button averageSpendingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators_page);

        //FIRENumber Button
        FIRENumberButton = (Button) findViewById(R.id.FIRENumberButton);
        FIRENumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFIRENumberPage();
            }
        });

        //SavingsRate Button
        savingsRateButton = (Button) findViewById(R.id.savingsRateButton);
        savingsRateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSavingsRatePage();
            }
        });

        //AverageSpending Button
        averageSpendingButton = (Button) findViewById(R.id.averageSpendingButton);
        averageSpendingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAverageSpendingPage();
            }
        });
    }

    //Switches to FIRENumberPage Activity
    public void openFIRENumberPage(){
        Intent intent = new Intent(this, FIRENumberPage.class);
        startActivity(intent);
    }

    //Switches to SavingsRatePage Activity
    public void openSavingsRatePage(){
        Intent intent = new Intent(this, SavingsRatePage.class);
        startActivity(intent);
    }

    //Switches to SavingsRatePage Activity
    public void openAverageSpendingPage(){
        Intent intent = new Intent(this, AverageSpendingPage.class);
        startActivity(intent);
    }
}
