package com.example.individualprojectcsc490.Calculators;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.individualprojectcsc490.R;

import java.text.DecimalFormat;

public class SavingsRatePage extends AppCompatActivity {

    private Button compute;
    private DecimalFormat numberFormat;

    private TextView savingsRateFieldValue;
    private TextView incomeFieldValue;
    private TextView taxesFieldValue;
    private TextView expensesFieldValue;

    private double savingsRate;
    private double incomeValue;
    private double taxesValue;
    private double expensesValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings_rate_page);

        initUI();

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savingsRate = computeSavingsRate();
                numberFormat = new DecimalFormat("#,##0.00%");

                if(!Double.isNaN(savingsRate)) {
                    if (savingsRate >= 0) {
                        savingsRateFieldValue.setText(numberFormat.format(savingsRate));
                        savingsRateFieldValue.setTextColor(Color.GREEN);
                    } else {
                        savingsRateFieldValue.setText(numberFormat.format(savingsRate));
                        savingsRateFieldValue.setTextColor(Color.RED);
                    }
                } else {
                    savingsRateFieldValue.setText(numberFormat.format(0.0));
                }
            }
        });
    }

    //Sets up local variables
    private void initUI() {
        compute               = findViewById(R.id.computeButtonSaving);

        savingsRateFieldValue = findViewById(R.id.savingsRateFieldValue);
        incomeFieldValue      = findViewById(R.id.incomeFieldValue);
        taxesFieldValue       = findViewById(R.id.taxesFieldValue);
        expensesFieldValue    = findViewById(R.id.expensesFieldValue);
    }

    //Gets values from TextViews and returns the savings rate
    private Double computeSavingsRate() {
        incomeValue   = validFieldValue(incomeFieldValue);
        taxesValue    = validFieldValue(taxesFieldValue);
        expensesValue = validFieldValue(expensesFieldValue);

        if(incomeValue-taxesValue == 0){
            return 0.0;
        } else {
            return ((incomeValue - taxesValue) - expensesValue) / Math.abs(incomeValue - taxesValue);
        }
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

}
