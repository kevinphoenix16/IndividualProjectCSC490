package com.example.individualprojectcsc490;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CreatedBudgetPage extends AppCompatActivity {

    private final int ANNUALLY = 1;
    private final int MONTHLY = 12;
    private final int WEEKLY = 52;

    private Double incomeValue;
    private DecimalFormat numberFormat;
    private Spinner paymentPeriodSpinnerBudget;

    private double foodValue;
    private double housingValue;
    private double transportationValue;
    private double utilitiesValue;
    private double insuranceValue;
    private double healthMedicalValue;
    private double otherValue;
    private double leftoverValue;

    private TextView incomeFieldValue;
    private TextView foodFieldValue;
    private TextView housingFieldValue;
    private TextView transportationFieldValue;
    private TextView utilitiesFieldValue;
    private TextView insuranceFieldValue;
    private TextView healthMedicalFieldValue;
    private TextView otherFieldValue;
    private TextView leftoverFieldValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_created_budget_page);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            getExtras(extras);
        }

        initUI();
        setupSpinner();
        calculateFromSpinner();

        //Checks for updates from Spinner
        paymentPeriodSpinnerBudget.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calculateFromSpinner();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Needed for listener but no code is necessary
            }
        });

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
        leftoverValue       = extras.getDouble("leftoverValue");

    }

    //Sets local fields references
    private void initUI() {
        incomeFieldValue           = findViewById(R.id.incomeFieldValue);
        paymentPeriodSpinnerBudget = findViewById(R.id.paymentPeriodSpinnerBudget);

        foodFieldValue             = findViewById(R.id.foodFieldValue);
        housingFieldValue          = findViewById(R.id.housingFieldValue);
        transportationFieldValue   = findViewById(R.id.transportationFieldValue);
        utilitiesFieldValue        = findViewById(R.id.utilitiesFieldValue);
        insuranceFieldValue        = findViewById(R.id.insuranceFieldValue);
        healthMedicalFieldValue    = findViewById(R.id.healthMedicalFieldValue);
        otherFieldValue            = findViewById(R.id.otherFieldValue);
        leftoverFieldValue         = findViewById(R.id.leftoverFieldValue);
    }

    //Sets up the drop-down Spinner container
    private void setupSpinner() {
        ArrayAdapter<String> paymentPeriodAdapter = new ArrayAdapter<>(CreatedBudgetPage.this,
                R.layout.custom_spinner,getResources().getStringArray(R.array.paymentPeriodOptions));
        paymentPeriodAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        paymentPeriodSpinnerBudget.setAdapter(paymentPeriodAdapter);
    }

    //Gets the value selected from the spinner and sets the UI's values
    private void calculateFromSpinner() {
        String paymentPeriod = paymentPeriodSpinnerBudget.getSelectedItem().toString();
        switch (paymentPeriod) {
            case "Monthly":
                setUI(MONTHLY);
                break;
            case "Annually":
                setUI(ANNUALLY);
                break;
            case "Weekly":
                setUI(WEEKLY);
                break;
        }
    }

    /**
     * Sets local fields values
     * @param paymentPeriod - the period selected from the spinner
     */
    private void setUI(int paymentPeriod) {
        numberFormat = new DecimalFormat("$#,##0.00");

        foodFieldValue.setText(numberFormat.format(foodValue/paymentPeriod));
        housingFieldValue.setText(numberFormat.format(housingValue/paymentPeriod));
        transportationFieldValue.setText(numberFormat.format(transportationValue/paymentPeriod));
        utilitiesFieldValue.setText(numberFormat.format(utilitiesValue/paymentPeriod));
        insuranceFieldValue.setText(numberFormat.format(insuranceValue/paymentPeriod));
        healthMedicalFieldValue.setText(numberFormat.format(healthMedicalValue/paymentPeriod));
        otherFieldValue.setText(numberFormat.format(otherValue/paymentPeriod));

        leftoverFieldValue.setText(numberFormat.format(leftoverValue/paymentPeriod));

    }
}
