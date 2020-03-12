package com.example.individualprojectcsc490;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReferencesPage extends AppCompatActivity {

    private Button booksButton;
    private Button blogsButton;
    private Button videosButton;
    private Button toolsButton;

    private TextView referencesTextArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_references_page);

        initUI();

        //Change text to books
        blogsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Change text to Blogs
        blogsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Change text to Videos
        videosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //Change text to Tools
        toolsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void initUI() {
        booksButton        = findViewById(R.id.booksButton);
        blogsButton        = findViewById(R.id.blogsButton);
        videosButton       = findViewById(R.id.videosButton);
        toolsButton        = findViewById(R.id.toolsButton);

        referencesTextArea = findViewById(R.id.referencesTextArea);
    }
}
