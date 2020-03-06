package com.example.individualprojectcsc490.Calculators;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.individualprojectcsc490.R;

public class AverageSpendingPage extends AppCompatActivity {

    private final int ANNUAL = 1;
    private final int MONTHLY = 12;

    private Button compute;
    private TextView averageSpendingValue;

    private TextView foodFieldValue;


    private double foodValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_spending_page);

        setupUI();

        //Compute Button
        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* TO-DO:
                * Decide if using annual or monthly
                * InProgress - Get all values from text fields
                * Combine all values with multiplier
                * Done - Update averageSpendingValue
                */
                double subTotal = sumCategories();

                averageSpendingValue.setText(Double.toString(subTotal));
            }
        });


    }

    //Sets up local variables
    private void setupUI() {
        compute              = (Button) findViewById(R.id.computeButton);
        foodFieldValue       = (TextView) findViewById(R.id.foodFieldValue);
        averageSpendingValue = (TextView) findViewById(R.id.averageSpendingValue);
    }

    //Adds up all categories of spending
    private double sumCategories(){
        foodValue = Double.parseDouble(foodFieldValue.getText().toString());

        return foodValue;
    }

}
