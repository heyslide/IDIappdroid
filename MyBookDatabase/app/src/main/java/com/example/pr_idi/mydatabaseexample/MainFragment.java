package com.example.pr_idi.mydatabaseexample;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private BookData bookData;
    private List<Book> mBooks;
    private ListView lvBooks;
    private AdapterIDI adapter;
    private PopupWindow popUpWindow;


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        bookData = new BookData(getActivity());
        bookData.open();

        lvBooks = (ListView) v.findViewById(R.id.list_books);

        mBooks = bookData.getAllBooksTitle();
        adapter = new AdapterIDI(getActivity(), mBooks);
        lvBooks.setAdapter(adapter);

        lvBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "book seleccionado" + id, Toast.LENGTH_SHORT).show();
                /*popUpWindow.showAtLocation(getView(), Gravity.BOTTOM, 10, 10);
                popUpWindow.update(50, 50, 320, 90);*/
            }
        });

        return v;
    }
}