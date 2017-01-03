package com.example.pr_idi.mydatabaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.app.ListActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private BookData bookData;
    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bookData = new BookData(this);
        bookData.open();

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

        int i = 0;
        int entra = 0;

        while (entra < 4) {
            book = bookData.createBook(newBook[i], newBook[i + 1]);
            i += 2;
            ++entra;
        }

        List<Book> values = bookData.getAllBooks();
        ListView list = (ListView) findViewById(R.id.list_item);

        // use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<Book> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);
        list.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        ListView list = (ListView) findViewById(R.id.list_item);

        ArrayAdapter<Book> adapter = (ArrayAdapter<Book>) list.getAdapter();

        if (id == R.id.nav_afegir) {
            // Handle the camera action

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
            int nextInt = new Random().nextInt(4);
            // save the new book to the database
            book = bookData.createBook(newBook[nextInt*2], newBook[nextInt*2 + 1]);
            // After I get the book data, I add it to the adapter
            adapter.add(book);

        } else if (id == R.id.nav_registrar) {

        } else if (id == R.id.nav_esborrarprimer) {
            if (list.getAdapter().getCount() > 0) {
                book = (Book) list.getAdapter().getItem(0);
                bookData.deleteBook(book);
                adapter.remove(book);
            }

        } else if (id == R.id.nav_autor) {

            Intent i = new Intent(this, ByAuthor.class);
            startActivity(i);

        } else if (id == R.id.nav_titol) {

        } else if (id == R.id.nav_categoria) {

        } else if (id == R.id.nav_valoracio) {
            Intent i = new Intent(this, ModifyEvaluation.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    // Life cycle methods. Check whether it is necessary to reimplement them

    @Override
    protected void onResume() {
        bookData.open();
        super.onResume();
    }

    // Life cycle methods. Check whether it is necessary to reimplement them

    @Override
    protected void onPause() {
        bookData.close();
        super.onPause();
    }
}
