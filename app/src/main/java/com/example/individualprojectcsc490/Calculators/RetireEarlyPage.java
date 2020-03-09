package com.example.individualprojectcsc490.Calculators;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.individualprojectcsc490.R;

public class RetireEarlyPage extends AppCompatActivity {

    private Button compute;

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
    private double yearsToRetire;
    private double netWorth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retire_early);

        initUI();

    }

    //Sets up local variables
    private void initUI() {
        compute                  = (Button) findViewById(R.id.computeButtonSaving);

        savingsRateFieldValue    = (TextView) findViewById(R.id.savingsRateFieldValue);
        incomeFieldValue         = (TextView) findViewById(R.id.incomeFieldValue);
        portfolioFieldValue      = (TextView) findViewById(R.id.portfolioFieldValue);
        annualReturnFieldValue   = (TextView) findViewById(R.id.annualReturnFieldValue);
        withdrawalRateFieldValue = (TextView) findViewById(R.id.withdrawalRateFieldValue);
        yearsToRetireFieldValue  = (TextView) findViewById(R.id.yearsToRetireFieldValue);
        netWorthFieldValue       = (TextView) findViewById(R.id.netWorthFieldValue);
    }

    //Sets the values of Doubles from the TextViews once the compute button is pressed
    private void setValues() {
        savingsRateValue    = Double.parseDouble(savingsRateFieldValue.getText().toString());
        incomeValue         = Double.parseDouble(incomeFieldValue.getText().toString());
        portfolioValue      = Double.parseDouble(portfolioFieldValue.getText().toString());
        annualReturnValue   = Double.parseDouble(annualReturnFieldValue.getText().toString());
        withdrawalRateValue = Double.parseDouble(withdrawalRateFieldValue.getText().toString());
    }

    //Calculates Years to Retire
    private void computeYearsToRetireField() {
        yearsToRetire = portfolioValue + annualReturnValue + withdrawalRateValue + netWorth;

        yearsToRetireFieldValue.setText(Double.toString(yearsToRetire));
    }

    //Calculates Net Worth at Retirement
    private void computeNetWorthField() {
        netWorth = incomeValue * (1.00 - (savingsRateValue)/100);

        netWorthFieldValue.setText(Double.toString(netWorth));
    }
}
