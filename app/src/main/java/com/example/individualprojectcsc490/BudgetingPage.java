package com.example.individualprojectcsc490;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BudgetingPage extends AppCompatActivity {

    private Button createBudgetButton;
    private DecimalFormat numberFormat;

    private TextView incomeFieldValue;
    private TextView foodFieldValue;
    private TextView housingFieldValue;
    private TextView transportationFieldValue;
    private TextView utilitiesFieldValue;
    private TextView insuranceFieldValue;
    private TextView healthMedicalFieldValue;
    private TextView otherFieldValue;
    private TextView percentageSumValue;

    private double foodValue;
    private double housingValue;
    private double transportationValue;
    private double utilitiesValue;
    private double insuranceValue;
    private double healthMedicalValue;
    private double otherValue;
    private double currentPercentageSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budgeting_page);

        initUI();

        numberFormat = new DecimalFormat("#,##0.00");
        percentageSumValue.setText(numberFormat.format( sumCategories())); //Need to get this to update with any number change

        createBudgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Change to another activity --> that has $'s in each field and a chart breakdown
            }
        });
    }

    //Sets local fields
    private void initUI() {
        incomeFieldValue         = findViewById(R.id.incomeFieldValue);
        foodFieldValue           = findViewById(R.id.foodFieldValue);
        housingFieldValue        = findViewById(R.id.housingFieldValue);
        transportationFieldValue = findViewById(R.id.transportationFieldValue);
        utilitiesFieldValue      = findViewById(R.id.utilitiesFieldValue);
        insuranceFieldValue      = findViewById(R.id.insuranceFieldValue);
        healthMedicalFieldValue  = findViewById(R.id.healthMedicalFieldValue);
        otherFieldValue          = findViewById(R.id.otherFieldValue);
        percentageSumValue       = findViewById(R.id.percentageSumValue);

        createBudgetButton       = findViewById(R.id.createBudgetButton);
    }

    //Adds up all percentages of categories
    private double sumCategories() {
        foodValue           = Double.parseDouble(foodFieldValue.getText().toString());
        housingValue        = Double.parseDouble(housingFieldValue.getText().toString());
        transportationValue = Double.parseDouble(transportationFieldValue.getText().toString());
        utilitiesValue      = Double.parseDouble(utilitiesFieldValue.getText().toString());
        insuranceValue      = Double.parseDouble(insuranceFieldValue.getText().toString());
        healthMedicalValue  = Double.parseDouble(healthMedicalFieldValue.getText().toString());
        otherValue          = Double.parseDouble(otherFieldValue.getText().toString());

        return foodValue + housingValue + transportationValue + utilitiesValue
                + insuranceValue + healthMedicalValue + otherValue;
    }
}
