package com.example.individualprojectcsc490;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button calculatorsButton;
    private Button budgetingButton;
    private Button referencesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        //Calculators Button
        changeActivity(calculatorsButton, CalculatorsPage.class);

        //Budgeting Button
        changeActivity(budgetingButton, BudgetingPage.class);

        //References Button
        changeActivity(referencesButton, ReferencesPage.class);
    }

    //Sets local fields
    private void initUI() {
        calculatorsButton = findViewById(R.id.calculatorsButton);
        budgetingButton   = findViewById(R.id.budgetingButton);
        referencesButton  = findViewById(R.id.referencesButton);
    }

    /**
     *
     * @param button - button that is clicked on Main Page
     * @param page - the new activity to change to
     */
    private void changeActivity(Button button, final Class<? extends Activity> page) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), page);
                startActivity(intent);
            }
        });
    }
}
