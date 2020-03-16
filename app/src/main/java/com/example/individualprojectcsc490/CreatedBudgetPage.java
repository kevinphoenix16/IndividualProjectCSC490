package com.example.individualprojectcsc490;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class CreatedBudgetPage extends AppCompatActivity {

    private Double incomeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_created_budget_page);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            incomeValue = extras.getDouble("incomeValue");
        }

        Toast.makeText(this, "" + incomeValue, Toast.LENGTH_SHORT).show();
    }
}
