package com.example.pr_idi.mydatabaseexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class ByAuthor extends AppCompatActivity {

    private BookData bookData;
    private Button mFindButton;
    private Book book;
    private static final String TAG = "ByAuthor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_author);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final String nomautor = ((EditText)findViewById(R.id.nomautorinsertat)).getText().toString();

        Toast.makeText(ByAuthor.this, nomautor, Toast.LENGTH_SHORT).show();

        bookData = new BookData(this);
        bookData.open();
        final List<Book> values = bookData.getBooksAuthor(nomautor);
        final ListView list = (ListView) findViewById(R.id.list_autor);

        final ArrayAdapter<Book> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, values);
        adapter.clear();
        list.setAdapter(adapter);

        mFindButton = (Button)findViewById(R.id.boto);
        mFindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<Book> adapter = (ArrayAdapter<Book>) list.getAdapter();
                boolean trobat = false;
                int index = 0;

                String[] newBook = new String[] {
                        "Miguel Strogoff",
                        "Jules Verne",
                        "Ulysses",
                        "James Joyce",
                        "Don Quijote",
                        "Miguel de Cervantes",
                        "Metamorphosis",
                        "Kafka"
                };


                while(!trobat && index < newBook.length) {
                    if (nomautor.equals(newBook[index])) {
                        trobat = true;
                    }
                    else {
                        ++index;
                    }
                }

                Toast.makeText(ByAuthor.this, nomautor, Toast.LENGTH_SHORT).show();

                if (trobat) {
                    // save the new book to the database
                    book = bookData.createBook(newBook[index-1], newBook[index]);
                    // After I get the book data, I add it to the adapter
                    adapter.add(book);
                }

                else {
                    Toast.makeText(ByAuthor.this, "Author doesn't exist", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}