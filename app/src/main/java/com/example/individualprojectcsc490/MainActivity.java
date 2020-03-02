package com.example.individualprojectcsc490;

import androidx.appcompat.app.AppCompatActivity;

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

        //Calculators Button
        calculatorsButton = (Button) findViewById(R.id.calculatorsButton);
        calculatorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculatorsPage();
            }
        });

        //Budgeting Button
        budgetingButton = (Button) findViewById(R.id.budgetingButton);
        budgetingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBudgetingPage();
            }
        });

        //References Button
        referencesButton = (Button) findViewById(R.id.referencesButton);
        referencesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReferencesPage();
            }
        });
    }

    //Switches to CalculatorsPage Activity
    public void openCalculatorsPage(){
        Intent intent = new Intent(this, CalculatorsPage.class);
        startActivity(intent);
    }

    //Switches to BudgetingPage Activity
    public void openBudgetingPage(){
        Intent intent = new Intent(this, BudgetingPage.class);
        startActivity(intent);
    }

    //Switches to ReferencesPage Activity
    public void openReferencesPage(){
        Intent intent = new Intent(this, ReferencesPage.class);
        startActivity(intent);
    }
}
