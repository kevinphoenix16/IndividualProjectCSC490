package com.example.individualprojectcsc490;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
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

    private double incomeValue;
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
        percentageSumValue.setText(numberFormat.format(sumCategories())); //Need to get this to update with any number change

        updatePercentageSum(foodFieldValue);
        updatePercentageSum(housingFieldValue);
        updatePercentageSum(transportationFieldValue);
        updatePercentageSum(utilitiesFieldValue);
        updatePercentageSum(insuranceFieldValue);
        updatePercentageSum(healthMedicalFieldValue);
        updatePercentageSum(otherFieldValue);

        createBudgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incomeValue = validFieldValue(incomeFieldValue);

                //pass variables to another screen
                Intent i = new Intent(BudgetingPage.this, CreatedBudgetPage.class);
                setupIntent(i);

                i.putExtra("otherValue", CalculateBudgetedValue(otherValue));

                startActivity(i);
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
     * Updates the value of textview percentageSumValue when a field is updated
     * @param fieldValue - the textview being change to cause the page update
     */
    private void updatePercentageSum(TextView fieldValue) {
        fieldValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPercentageSum = sumCategories();
                percentageSumValue.setText(numberFormat.format(currentPercentageSum));

                if(currentPercentageSum <= 100) {
                    percentageSumValue.setTextColor(Color.GREEN);
                } else {
                    percentageSumValue.setTextColor(Color.RED);
                }
            }
        });
    }

    /**
     * Sets variables to be passed to CreatedBudgetPage
     * @param i - intent to add the budgeted value to
     */
    private void setupIntent(Intent i) {
        i.putExtra("incomeValue", CalculateBudgetedValue(incomeValue));

        i.putExtra("foodValue", CalculateBudgetedValue(foodValue));
        i.putExtra("housingValue", CalculateBudgetedValue(housingValue));
        i.putExtra("transportationValue", CalculateBudgetedValue(transportationValue));
        i.putExtra("utilitiesValue", CalculateBudgetedValue(utilitiesValue));
        i.putExtra("insuranceValue", CalculateBudgetedValue(insuranceValue));
        i.putExtra("healthMedicalValue", CalculateBudgetedValue(healthMedicalValue));
        i.putExtra("otherValue", CalculateBudgetedValue(otherValue));
        i.putExtra("leftoverValue", CalculateBudgetedValue(100 -  sumCategories()));
    }

    /**
     *
     * @param value - the field to calculate the income allocation of
     * @return - a Double breakdown of the income and percent allocated to that field
     */
    private Double CalculateBudgetedValue(Double value){
        return (incomeValue * value)/100;
    }
}
