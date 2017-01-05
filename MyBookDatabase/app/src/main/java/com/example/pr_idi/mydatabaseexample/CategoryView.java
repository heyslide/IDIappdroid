package com.example.pr_idi.mydatabaseexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryView extends Fragment {
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

        return v;
    }

}
