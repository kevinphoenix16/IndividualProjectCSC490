package com.example.individualprojectcsc490;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class ReferencesPage extends AppCompatActivity {

    private Button booksButton;
    private Button blogsButton;
    private Button videosButton;
    private Button toolsButton;

    private ListView referencedList;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_references_page);

        initUI();

        //Change text to books
        booksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<String> booksAdapter = new ArrayAdapter<String>(ReferencesPage.this,
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.books));
                booksAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                referencedList.setAdapter(booksAdapter);
            }
        });

        //Change text to Blogs
        blogsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<String> booksAdapter = new ArrayAdapter<String>(ReferencesPage.this,
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.blogs));
                booksAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                referencedList.setAdapter(booksAdapter);
            }
        });

        //Change text to Videos
        videosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<String> booksAdapter = new ArrayAdapter<String>(ReferencesPage.this,
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.videos));
                booksAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                referencedList.setAdapter(booksAdapter);
            }
        });

        //Change text to Tools
        toolsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<String> booksAdapter = new ArrayAdapter<String>(ReferencesPage.this,
                        android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.tools));
                booksAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
                referencedList.setAdapter(booksAdapter);
            }
        });

    }

    private void initUI() {
        booksButton    = findViewById(R.id.booksButton);
        blogsButton    = findViewById(R.id.blogsButton);
        videosButton   = findViewById(R.id.videosButton);
        toolsButton    = findViewById(R.id.toolsButton);

        referencedList = findViewById(R.id.referencedList);
    }
}
