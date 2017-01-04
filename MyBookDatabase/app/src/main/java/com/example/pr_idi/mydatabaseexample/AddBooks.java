package com.example.pr_idi.mydatabaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class AddBooks extends AppCompatActivity {
    private BookData bookData;
    private Button mButton;
    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_books);
        bookData = new BookData(this);
        bookData.open();

        mButton = (Button)findViewById(R.id.addBookToDB);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText title = (EditText)findViewById(R.id.textAddTitle);
                EditText author = (EditText)findViewById(R.id.textAddAuthor);
                EditText publisher = (EditText)findViewById(R.id.textAddPublisher);
                EditText year = (EditText)findViewById(R.id.textAddYear);
                Spinner category = (Spinner)findViewById(R.id.spinAddCategory);
                Spinner rating = (Spinner)findViewById(R.id.spinAddPuntuation);

                if (isEmpty(title) || isEmpty(author) || isEmpty(publisher) || isEmpty(year)) {
                    Toast toast = Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    book = bookData.createBook(title.getText().toString(), author.getText().toString(),
                            publisher.getText().toString(), Integer.parseInt(year.getText().toString()),
                            category.getSelectedItem().toString(), rating.getSelectedItem().toString());
                    finish();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        bookData.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        bookData.close();
        super.onPause();
    }

    private boolean isEmpty(EditText field) {
        if (field.getText().toString().isEmpty()) return true;
        else return false;
    }

}