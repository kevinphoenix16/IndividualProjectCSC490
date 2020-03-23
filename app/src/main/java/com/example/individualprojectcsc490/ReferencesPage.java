package com.example.individualprojectcsc490;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ReferencesPage extends AppCompatActivity {

    private Button booksButton;
    private Button blogsButton;
    private Button videosButton;
    private Button toolsButton;

    private ListView referencedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_references_page);

        initUI();

        //Change text to books
        changeTextDisplayed(booksButton, R.array.books);

        //Change text to Blogs
        changeTextDisplayed(blogsButton, R.array.blogs);

        //Change text to Videos
        changeTextDisplayed(videosButton, R.array.videos);

        //Change text to Tools
        changeTextDisplayed(toolsButton, R.array.tools);
    }

    /**
     *
     * @param button - button that is clicked on References Page
     * @param ID - the ID of the array-list to display
     */
    private void changeTextDisplayed(Button button, final int ID) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<String> booksAdapter = new ArrayAdapter<>(ReferencesPage.this,
                        R.layout.custom_list, getResources().getStringArray(ID));
                booksAdapter.setDropDownViewResource(R.layout.custom_list);
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
