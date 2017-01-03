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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ByAuthor extends AppCompatActivity {

    private BookData bookData;
    private Button mFindButton;
    private ListView mlist;
    private static final String TAG = "ByAuthor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_author);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mFindButton = (Button)findViewById(R.id.boto);
        mFindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bookData = new BookData(ByAuthor.this);
                bookData.open();
                final String nomautor = ((EditText)findViewById(R.id.nomautorinsertat)).getText().toString();
                final List<Book> values = bookData.getBooksAuthor(nomautor);
                mlist = (ListView) findViewById(R.id.list_autor);
                // Llenar la lista con los valores de values, el adapter sirve para decir tienes
                // que mostrar estas cosas(Autor, titulo, etc..)

                /*AdapterIDI adapterIDI = new AdapterIDI(getApplicationContext(), values);
                mlist.setAdapter(adapterIDI);*/

                ArrayAdapter<Book> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, values);
                mlist.setAdapter(adapter);

                if (adapter.isEmpty()){
                    Toast.makeText(ByAuthor.this, "The Author "+ nomautor + " is not at the DataBase", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}