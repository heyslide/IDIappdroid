package com.example.pr_idi.mydatabaseexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
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
    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MainFragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragments, fragment).commit();
        getSupportActionBar().setTitle("Books Titles DataBase");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }
*/
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

        Fragment fragment = null;
        boolean FragmentTransition = false;

        if (id == R.id.nav_registrar) {

            fragment = new FragmentAfegir();
            FragmentTransition = true;
            getSupportActionBar().setTitle("Add New Book");

        }  else if (id == R.id.nav_recycle) {

            fragment = new CategoryView();
            FragmentTransition = true;
            getSupportActionBar().setTitle("By Category");

        } else if (id == R.id.nav_autor) {

            fragment = new SearchAuthor();
            FragmentTransition = true;
            getSupportActionBar().setTitle("By Author");

        } else if (id == R.id.nav_titol) {

            fragment = new SearchTitle();
            FragmentTransition = true;
            getSupportActionBar().setTitle("By Title");

        } else if (id == R.id.help) {

            fragment = new FragmentHelp();
            FragmentTransition = true;
            getSupportActionBar().setTitle("Help");

        } else if (id == R.id.about) {

           fragment = new FragmentAbout();
            FragmentTransition = true;
            getSupportActionBar().setTitle("About");

       } else if (id == R.id.nav_principal) {
            MainFragment fragment2 = new MainFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragments, fragment2).commit();
            getSupportActionBar().setTitle("Books Titles DataBase");

        }

        if (FragmentTransition) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragments, fragment).commit();
            item.setChecked(true);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    // Life cycle methods. Check whether it is necessary to reimplement them

    /*@Override
    protected void onResume() {
        bookData.open();
        super.onResume();
    }

    // Life cycle methods. Check whether it is necessary to reimplement them

    @Override
    protected void onPause() {
        bookData.close();
        super.onPause();
    }*/
}
