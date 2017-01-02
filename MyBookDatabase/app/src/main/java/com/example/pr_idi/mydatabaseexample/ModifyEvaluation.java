package com.example.pr_idi.mydatabaseexample;

import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ModifyEvaluation extends AppCompatActivity {

    private BookData bookData;
    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_evaluation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bookData = new BookData(this);
        bookData.open();

        List<Book> values = bookData.getAllBooks();
        ListView list = (ListView) findViewById(R.id.list_item);

        // use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<Book> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, values);
        list.setAdapter(adapter);

        ArrayAdapter<Book> adapter = (ArrayAdapter<Book>) list.getAdapter();

        while ()

        book = bookData.createBook(newBook[nextInt*2], newBook[nextInt*2 + 1]);
        // After I get the book data, I add it to the adapter
        adapter.add(book);










    }

}
