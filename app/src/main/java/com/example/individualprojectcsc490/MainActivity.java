package com.example.individualprojectcsc490;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button calculatorsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorsButton = (Button) findViewById(R.id.calculatorsButton);
        calculatorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculatorsPage();
            }
        });
    }

    public void openCalculatorsPage(){
        Intent intent = new Intent(this, CalculatorsPage.class);
        startActivity(intent);
    }
}
