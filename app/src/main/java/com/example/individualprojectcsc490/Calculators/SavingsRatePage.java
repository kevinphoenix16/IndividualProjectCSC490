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
    private TextView spendingFieldValue;

    private double savingsRate;
    private double incomeValue;
    private double taxesValue;
    private double spendingValue;

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

                if(savingsRate >= 0){
                    savingsRateFieldValue.setText(numberFormat.format(savingsRate));
                    savingsRateFieldValue.setTextColor(Color.GREEN);
                } else {
                    savingsRateFieldValue.setText(numberFormat.format(savingsRate));
                    savingsRateFieldValue.setTextColor(Color.RED);
                }
            }
        });
    }

    //Sets up local variables
    private void initUI() {
        compute               = (Button) findViewById(R.id.computeButtonSaving);

        savingsRateFieldValue = (TextView) findViewById(R.id.savingsRateFieldValue);
        incomeFieldValue      = (TextView) findViewById(R.id.incomeFieldValue);
        taxesFieldValue       = (TextView) findViewById(R.id.taxesFieldValue);
        spendingFieldValue    = (TextView) findViewById(R.id.spendingFieldValue);
    }


    //Gets values from TextViews and returns the savings rate
    private Double computeSavingsRate() {
        incomeValue   = Double.parseDouble(incomeFieldValue.getText().toString());
        taxesValue    = Double.parseDouble(taxesFieldValue.getText().toString());
        spendingValue = Double.parseDouble(spendingFieldValue.getText().toString());

        return ((incomeValue-taxesValue)-spendingValue)/(incomeValue-taxesValue);
    }
}
