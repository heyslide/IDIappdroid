package com.example.pr_idi.mydatabaseexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private BookData bookData;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        bookData = new BookData(getActivity());
        bookData.open();

        View v = inflater.inflate(R.layout.fragment_main, container, false);

        ListView list = (ListView) v.findViewById(R.id.list_item);

        List<Book> values = bookData.getAllBooksTitle();
        ArrayAdapter<Book> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, values);
        list.setAdapter(adapter);

        


        return v;
    }

}
