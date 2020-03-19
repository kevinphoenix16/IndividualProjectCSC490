package com.example.individualprojectcsc490.Calculators;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.individualprojectcsc490.R;

import java.text.DecimalFormat;

public class RetireEarlyPage extends AppCompatActivity {

    private Button compute;
    private DecimalFormat numberFormat;

    private TextView savingsRateFieldValue;
    private TextView incomeFieldValue;
    private TextView portfolioFieldValue;
    private TextView annualReturnFieldValue;
    private TextView withdrawalRateFieldValue;
    private TextView yearsToRetireFieldValue;
    private TextView netWorthFieldValue;

    private double savingsRateValue;
    private double incomeValue;
    private double portfolioValue;
    private double annualReturnValue;
    private double withdrawalRateValue;
    private double netWorth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retire_early);

        initUI();

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setValues();
                computeYearsToRetireField();
                computeNetWorthField();
            }
        });
    }

    //Sets up local variables
    private void initUI() {
        compute                  = findViewById(R.id.computeButtonRetire);

        savingsRateFieldValue    = findViewById(R.id.savingsRateFieldValue);
        incomeFieldValue         = findViewById(R.id.incomeFieldValue);
        portfolioFieldValue      = findViewById(R.id.portfolioFieldValue);
        annualReturnFieldValue   = findViewById(R.id.annualReturnFieldValue);
        withdrawalRateFieldValue = findViewById(R.id.withdrawalRateFieldValue);
        yearsToRetireFieldValue  = findViewById(R.id.yearsToRetireFieldValue);
        netWorthFieldValue       = findViewById(R.id.netWorthFieldValue);
    }

    //Sets the values of Doubles from the TextViews once the compute button is pressed
    private void setValues() {
        savingsRateValue    = validFieldValue(savingsRateFieldValue) / 100;
        incomeValue         = validFieldValue(incomeFieldValue);
        portfolioValue      = validFieldValue(portfolioFieldValue);
        annualReturnValue   = validFieldValue(annualReturnFieldValue) / 100;
        withdrawalRateValue = validFieldValue(withdrawalRateFieldValue) / 100;
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

    //Calculates Years to Retire
    //Source of formula: https://networthify.com/calculator/earlyretirement
    private void computeYearsToRetireField() {
        double numeratorPart1 = ((annualReturnValue * (1 - savingsRateValue) * incomeValue) / withdrawalRateValue) + (savingsRateValue * incomeValue);
        double numeratorPart2 = (annualReturnValue * portfolioValue) + (savingsRateValue * incomeValue);

        double numerator = Math.log10(numeratorPart1 / numeratorPart2);
        double denominator = Math.log10(1 + annualReturnValue);

        double yearsToRetire = numerator / denominator;

        numberFormat = new DecimalFormat("#,##0.00 Years");
        yearsToRetireFieldValue.setText(numberFormat.format(yearsToRetire));
    }

    //Calculates Net Worth at Retirement
    private void computeNetWorthField() {
        netWorth = incomeValue * (1.00 - (savingsRateValue)) * 25;

        numberFormat = new DecimalFormat("$#,##0.00");
        netWorthFieldValue.setText(numberFormat.format(netWorth));
    }
}
