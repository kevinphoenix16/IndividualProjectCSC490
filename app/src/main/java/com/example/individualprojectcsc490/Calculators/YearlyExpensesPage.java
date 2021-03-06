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

public class YearlyExpensesPage extends AppCompatActivity {

    private final int ANNUALLY = 1;
    private final int MONTHLY = 12;
    private final int WEEKLY = 52;

    private Spinner paymentPeriodSpinner;
    private Button compute;
    private DecimalFormat numberFormat;

    private TextView yearlyExpensesValue;
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
        setContentView(R.layout.activity_yearly_expenses_page);

        setupUI();
        setupSpinner();

        //Compute Button
        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double subTotal = sumCategories();
                String paymentPeriod = paymentPeriodSpinner.getSelectedItem().toString();
                setExpensesValue(paymentPeriod, subTotal);
            }
        });
    }

    //Sets up local variables
    private void setupUI() {
        paymentPeriodSpinner     = findViewById(R.id.paymentPeriodSpinnerExpenses);
        compute                  = findViewById(R.id.computeButtonExpenses);

        yearlyExpensesValue      = findViewById(R.id.yearlyExpensesValue);
        foodFieldValue           = findViewById(R.id.foodFieldValue);
        housingFieldValue        = findViewById(R.id.housingFieldValue);
        transportationFieldValue = findViewById(R.id.transportationFieldValue);
        utilitiesFieldValue      = findViewById(R.id.utilitiesFieldValue);
        insuranceFieldValue      = findViewById(R.id.insuranceFieldValue);
        healthMedicalFieldValue  = findViewById(R.id.healthMedicalFieldValue);
        otherFieldValue          = findViewById(R.id.otherFieldValue);
    }

    //Sets up the drop-down Spinner container
    private void setupSpinner() {
        ArrayAdapter<String> paymentPeriodAdapter = new ArrayAdapter<>(YearlyExpensesPage.this,
                R.layout.custom_spinner,getResources().getStringArray(R.array.paymentPeriodOptions));
        paymentPeriodAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        paymentPeriodSpinner.setAdapter(paymentPeriodAdapter);
    }

    //Adds up all categories of expenses
    private double sumCategories() {
        foodValue           = validFieldValue(foodFieldValue);
        housingValue        = validFieldValue(housingFieldValue);
        transportationValue = validFieldValue(transportationFieldValue);
        utilitiesValue      = validFieldValue(utilitiesFieldValue);
        insuranceValue      = validFieldValue(insuranceFieldValue);
        healthMedicalValue  = validFieldValue(healthMedicalFieldValue);
        otherValue          = validFieldValue(otherFieldValue);

        return foodValue + housingValue + transportationValue + utilitiesValue
                         + insuranceValue + healthMedicalValue + otherValue;
    }

    /**
     * Checks to see if the value of the textview is valid
     * @param valueToCheck - the textview to check
     * @return - 0.0 is the field is empty or the value in it if it is not
     */
    private double validFieldValue(TextView valueToCheck){
        if(valueToCheck.getText().toString().matches("")) {
            return 0.0;
        } else {
            return Double.parseDouble(valueToCheck.getText().toString());
        }
    }


    /**
     *
     * @param paymentPeriod - period selected from spinner
     * @param subTotal - total of fields before the period multiplier is applied
     */
    private void setExpensesValue(String paymentPeriod, double subTotal) {
        numberFormat = new DecimalFormat("$#,##0.00");

        switch (paymentPeriod) {
            case "Monthly":
                yearlyExpensesValue.setText(numberFormat.format(subTotal * MONTHLY));
                break;
            case "Annually":
                yearlyExpensesValue.setText(numberFormat.format(subTotal * ANNUALLY));
                break;
            case "Weekly":
                yearlyExpensesValue.setText(numberFormat.format(subTotal * WEEKLY));
                break;
        }
    }

}
