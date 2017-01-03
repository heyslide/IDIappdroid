package com.example.pr_idi.mydatabaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Random;

public class AddBooks extends AppCompatActivity {
    private BookData bookData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_books);
        bookData = new BookData(this);
        bookData.open();
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

    public void onClick(View view) {
        //@SuppressWarnings("unchecked");
        Book book;
        switch (view.getId()) {
            case R.id.addBookToDB:
                EditText title = (EditText)findViewById(R.id.textAddTitle);
                EditText author = (EditText)findViewById(R.id.textAddAuthor);
                EditText publisher = (EditText)findViewById(R.id.textAddPublisher);
                EditText year = (EditText)findViewById(R.id.textAddYear);
                Spinner category = (Spinner)findViewById(R.id.spinAddCategory);
                Spinner rating = (Spinner)findViewById(R.id.spinAddPuntuation);
                // save the new book to the database


                book = bookData.createBook(title.getText().toString(), author.getText().toString(),
                        publisher.getText().toString(), Integer.parseInt(year.getText().toString()),
                        category.getSelectedItem().toString(), rating.getSelectedItem().toString());

                //passar dades a carlota o algo?

                break;
        }

    }
}
