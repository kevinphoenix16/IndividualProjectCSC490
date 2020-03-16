package com.example.individualprojectcsc490;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CreatedBudgetPage extends AppCompatActivity {

    private Double incomeValue;
    private DecimalFormat numberFormat;

    private double foodValue;
    private double housingValue;
    private double transportationValue;
    private double utilitiesValue;
    private double insuranceValue;
    private double healthMedicalValue;
    private double otherValue;

    private TextView incomeFieldValue;
    private TextView foodFieldValue;
    private TextView housingFieldValue;
    private TextView transportationFieldValue;
    private TextView utilitiesFieldValue;
    private TextView insuranceFieldValue;
    private TextView healthMedicalFieldValue;
    private TextView otherFieldValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_created_budget_page);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            getExtras(extras);
        }

        initUI();

        setUI();
    }

    //Gets the values passed in from BudgetingPage
    private void getExtras(Bundle extras) {
        incomeValue         = extras.getDouble("incomeValue");

        foodValue           = extras.getDouble("foodValue");
        housingValue        = extras.getDouble("housingValue");
        transportationValue = extras.getDouble("transportationValue");
        utilitiesValue      = extras.getDouble("utilitiesValue");
        insuranceValue      = extras.getDouble("insuranceValue");
        healthMedicalValue  = extras.getDouble("healthMedicalValue");
        otherValue          = extras.getDouble("otherValue");
    }

    //Sets local fields references
    private void initUI() {
        incomeFieldValue         = findViewById(R.id.incomeFieldValue);

        foodFieldValue           = findViewById(R.id.foodFieldValue);
        housingFieldValue        = findViewById(R.id.housingFieldValue);
        transportationFieldValue = findViewById(R.id.transportationFieldValue);
        utilitiesFieldValue      = findViewById(R.id.utilitiesFieldValue);
        insuranceFieldValue      = findViewById(R.id.insuranceFieldValue);
        healthMedicalFieldValue  = findViewById(R.id.healthMedicalFieldValue);
        otherFieldValue          = findViewById(R.id.otherFieldValue);
    }

    //Sets local fields values
    private void setUI() {
        numberFormat = new DecimalFormat("$#,##0.00");

        foodFieldValue.setText(numberFormat.format(foodValue));
        housingFieldValue.setText(numberFormat.format(housingValue));
        transportationFieldValue.setText(numberFormat.format(transportationValue));
        utilitiesFieldValue.setText(numberFormat.format(utilitiesValue));
        insuranceFieldValue.setText(numberFormat.format(insuranceValue));
        healthMedicalFieldValue.setText(numberFormat.format(healthMedicalValue));
        otherFieldValue.setText(numberFormat.format(otherValue));

    }
}
