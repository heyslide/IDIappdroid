package com.example.pr_idi.mydatabaseexample;

import android.content.Context;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    NavigationView navigationView;
    private boolean tancar = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MainFragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragments, fragment).commit();
        getSupportActionBar().setTitle("Library on the go");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                InputMethodManager inputMethodManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                InputMethodManager inputMethodManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        };

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragments, fragment).commit();
        getSupportActionBar().setTitle("Library on the go");
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

        Fragment fragment = null;
        boolean FragmentTransition = false;

        switch (item.getItemId()) {

            case R.id.nav_principal:
                tancar = true;
                fragment = new MainFragment();
                FragmentTransition = true;
                getSupportActionBar().setTitle("Library on the go");
                //navigationView.getMenu().getItem(0).setChecked(true);
                break;

            case R.id.nav_registrar:
                tancar = false;
                fragment = new FragmentAfegir();
                FragmentTransition = true;
                getSupportActionBar().setTitle("Add a new book");
                //navigationView.getMenu().getItem(1).setChecked(true);
                break;

            case R.id.nav_recycle:
                tancar = false;
                fragment = new CategoryView();
                FragmentTransition = true;
                getSupportActionBar().setTitle("View all the books");
                //navigationView.getMenu().getItem(2).setChecked(true);
                break;

            case R.id.nav_autor:
                tancar = false;
                fragment = new SearchAuthor();
                FragmentTransition = true;
                getSupportActionBar().setTitle("Find books by author");
                //navigationView.getMenu().getItem(3).setChecked(true);
                break;

            case R.id.help:
                tancar = false;
                fragment = new FragmentHelp();
                FragmentTransition = true;
                getSupportActionBar().setTitle("Help");
                //navigationView.getMenu().getItem(4).setChecked(true);
                break;

            case R.id.about:
                tancar = false;
                fragment = new FragmentAbout();
                FragmentTransition = true;
                getSupportActionBar().setTitle("About");
                //navigationView.getMenu().getItem(5).setChecked(true);
                break;
        }

        if (FragmentTransition) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragments, fragment).commit();
            //item.setChecked(true);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
