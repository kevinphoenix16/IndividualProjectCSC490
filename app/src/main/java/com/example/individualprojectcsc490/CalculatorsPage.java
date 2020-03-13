package com.example.individualprojectcsc490;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.individualprojectcsc490.Calculators.*;

public class CalculatorsPage extends AppCompatActivity {

    private Button retireEarlyButton;
    private Button savingsRateButton;
    private Button yearlySpendingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators_page);

        initUI();

        //RetireEarly Button
        changeActivity(retireEarlyButton, RetireEarlyPage.class);

        //SavingsRate Button
        changeActivity(savingsRateButton, SavingsRatePage.class);

        //YearlySpending Button
        changeActivity(yearlySpendingButton, YearlySpendingPage.class);
    }

    //Sets local fields
    private void initUI() {
        retireEarlyButton    = findViewById(R.id.retireEarlyButton);
        savingsRateButton    = findViewById(R.id.savingsRateButton);
        yearlySpendingButton = findViewById(R.id.yearlySpendingButton);
    }

    /**
     *
     * @param button - button that is clicked on Main Page
     * @param page - the new activity to change to
     */
    private void changeActivity(Button button, final Class<? extends Activity> page){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), page);
                startActivity(intent);
            }
        });
    }
}
