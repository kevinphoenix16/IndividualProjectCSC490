package com.example.individualprojectcsc490;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CalculatorsPage extends AppCompatActivity {

    private Button FIRENumberButton;
    private Button savingsRateButton;
    private Button averageSpendingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculators_page);

        //FIRENumber Button
        FIRENumberButton = (Button) findViewById(R.id.FIRENumberButton);
        FIRENumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFIRENumberPage();
            }
        });
    }

    //Switches to FIRENumberPage Activity
    public void openFIRENumberPage(){
        Intent intent = new Intent(this, CalculatorsPage.class);
        startActivity(intent);
    }
}
