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
        compute                  = (Button) findViewById(R.id.computeButtonRetire);

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
        double yearsToRetire = 0;           //portfolioValue + annualReturnValue + withdrawalRateValue + netWorth;




        numberFormat = new DecimalFormat("#.00 Years");
        yearsToRetireFieldValue.setText(numberFormat.format(yearsToRetire));
    }

    //Calculates Net Worth at Retirement
    private void computeNetWorthField() {
        netWorth = incomeValue * (1.00 - (savingsRateValue)/100) * 25;


        numberFormat = new DecimalFormat("$###,###.00");
        netWorthFieldValue.setText(numberFormat.format(netWorth));
    }
}
