package com.example.individualprojectcsc490.Calculators;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.individualprojectcsc490.R;

import java.text.DecimalFormat;

public class YearlySpendingPage extends AppCompatActivity {

    private final int ANNUALLY = 1;
    private final int MONTHLY = 12;
    private final int WEEKLY = 52;

    private Spinner paymentPeriodSpinner;
    private Button compute;
    private DecimalFormat numberFormat;

    private TextView yearlySpendingValue;
    private TextView foodFieldValue;
    private TextView housingFieldValue;
    private TextView transportationFieldValue;
    private TextView utilitiesFieldValue;
    private TextView insuranceFieldValue;
    private TextView healthMedicalFieldValue;
    private TextView otherFieldValue;

    private double foodValue;
    private double housingValue;
    private double transportationValue;
    private double utilitiesValue;
    private double insuranceValue;
    private double healthMedicalValue;
    private double otherValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yearly_spending_page);

        setupUI();
        setupSpinner();

        //Compute Button
        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double subTotal = sumCategories();
                String paymentPeriod = paymentPeriodSpinner.getSelectedItem().toString();

                numberFormat = new DecimalFormat("$#,##0.00");
                if(paymentPeriod.equals("Monthly")){
                    yearlySpendingValue.setText(numberFormat.format(subTotal * MONTHLY));
                } else if(paymentPeriod.equals("Annually")) {
                    yearlySpendingValue.setText(numberFormat.format(subTotal * ANNUALLY));
                } else if(paymentPeriod.equals("Weekly")) {
                    yearlySpendingValue.setText(numberFormat.format(subTotal * WEEKLY));
                }
            }
        });
    }

    //Sets up local variables
    private void setupUI() {
        paymentPeriodSpinner     = (Spinner) findViewById(R.id.paymentPeriodSpinnerSpending);
        compute                  = (Button) findViewById(R.id.computeButtonSpending);

        yearlySpendingValue      = (TextView) findViewById(R.id.yearlySpendingValue);
        foodFieldValue           = (TextView) findViewById(R.id.foodFieldValue);
        housingFieldValue        = (TextView) findViewById(R.id.housingFieldValue);
        transportationFieldValue = (TextView) findViewById(R.id.transportationFieldValue);
        utilitiesFieldValue      = (TextView) findViewById(R.id.utilitiesFieldValue);
        insuranceFieldValue      = (TextView) findViewById(R.id.insuranceFieldValue);
        healthMedicalFieldValue  = (TextView) findViewById(R.id.healthMedicalFieldValue);
        otherFieldValue          = (TextView) findViewById(R.id.otherFieldValue);
    }

    //Sets up the drop-down Spinner container
    private void setupSpinner() {
        ArrayAdapter<String> paymentPeriodAdapter = new ArrayAdapter<String>(YearlySpendingPage.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.paymentPeriodOptions));
        paymentPeriodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paymentPeriodSpinner.setAdapter(paymentPeriodAdapter);
    }

    //Adds up all categories of spending
    private double sumCategories(){
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
