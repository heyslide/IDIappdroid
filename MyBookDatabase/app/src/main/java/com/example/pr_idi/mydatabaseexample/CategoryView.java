package com.example.pr_idi.mydatabaseexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryView extends Fragment implements RecyclerViewClickListener{
    /* recyclerview -> dos layouts
        -uno con la recyclerview
        -otro que define como es cada elemento
       pasar adapter a recyclerview
       definir en myAdapter un custom viewholder (llenar elementos de la lista con lo que decimos)
       coger layout y asignar textos a textviews (en el adapter)
       y pasarle el adapter a la recyclerview

    */

    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutmanager;
    private MyAdapter myadapter;
    private BookData bookdata;

    public CategoryView() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        bookdata = new BookData(getActivity());
        bookdata.open();

        View v = inflater.inflate(R.layout.fragment_category_view, container, false);

        recycler = (RecyclerView) v.findViewById(R.id.recycler_view);

        List<Book> values = bookdata.getAllBooksCategory();
        myadapter = new MyAdapter(getActivity(), values);
        recycler.setAdapter(myadapter);
        layoutmanager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(layoutmanager);
        recycler.setItemAnimator(new DefaultItemAnimator());

        View v2 = inflater.inflate(R.layout.recycler_inside_layout, container, false);

        ImageView ivDelete = (ImageView) v2.findViewById(R.id.ivDeleteBook);
        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                Toast.makeText(getActivity(), "sdjf", Toast.LENGTH_SHORT).show();
            }
        });

        setHasOptionsMenu(true);

        return v;
    }

    @Override
    public void onCreateOptionsMenu(
            Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search_title, menu);

        MenuItem item = menu.findItem(R.id.menuSearchTitle);
/*        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myadapter.filterByTitle(newText);
                return false;
            }
        });*/
    }

    @Override
    public void onRowClicked(int position) {
        
    }

    @Override
    public void onViewClicked(View v, int position) {

    }
}
