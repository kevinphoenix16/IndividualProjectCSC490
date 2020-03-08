package com.example.individualprojectcsc490.Calculators;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.individualprojectcsc490.R;

public class SavingsRatePage extends AppCompatActivity {

    private final int ANNUALLY = 1;
    private final int MONTHLY = 12;

    private Spinner paymentPeriodSpinnerSavings;
    private Button compute;

    private TextView savingsRateFieldValue;
    private TextView incomeFieldValue;
    private TextView taxesFieldValue;
    private TextView spendingFieldValue;

    private double incomeValue;
    private double taxesValue;
    private double spendingValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings_rate_page);

        initUI();
        setupSpinner();

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String paymentPeriod = paymentPeriodSpinnerSavings.getSelectedItem().toString();

                if(paymentPeriod.equals("Monthly")){
                    //based off monthly values
                } else if(paymentPeriod.equals("Annually")) {
                    //based off yearly values
                }
            }
        });
    }

    //Sets up local variables
    private void initUI() {
        paymentPeriodSpinnerSavings = (Spinner) findViewById(R.id.paymentPeriodSpinnerSavings);
        compute                     = (Button) findViewById(R.id.computeButtonSaving);

        savingsRateFieldValue       = (TextView) findViewById(R.id.savingsRateFieldValue);
        incomeFieldValue            = (TextView) findViewById(R.id.incomeFieldValue);
        taxesFieldValue             = (TextView) findViewById(R.id.taxesFieldValue);
        spendingFieldValue          = (TextView) findViewById(R.id.spendingFieldValue);
    }

    //Sets up the drop-down Spinner container
    private void setupSpinner() {
        ArrayAdapter<String> paymentPeriodAdapter = new ArrayAdapter<String>(SavingsRatePage.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.paymentPeriodOptions));
        paymentPeriodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paymentPeriodSpinnerSavings.setAdapter(paymentPeriodAdapter);
    }
}
