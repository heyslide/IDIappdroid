package com.example.pr_idi.mydatabaseexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchTitle extends Fragment {

    private ListView titleList;
    private BookData bookData;
    private Button findButton;

    public SearchTitle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_title, container, false);

        final EditText titolllibre = (EditText) v.findViewById(R.id.textCercaTitol);
        titleList = (ListView) v.findViewById(R.id.list_titol);
        findButton = (Button) v.findViewById(R.id.botocerca);
        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bookData = new BookData(getActivity());
                bookData.open();

                if (titolllibre.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "A title is required", Toast.LENGTH_SHORT).show();
                }

                else {
                    String titleBook = titolllibre.getText().toString();
                    final List<Book> values = bookData.getAllBooksByTitle(titleBook);

                    ArrayAdapter<Book> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, values);
                    titleList.setAdapter(adapter);

                    if (adapter.isEmpty()) {
                        Toast.makeText(getActivity(), "The book titled " + titleBook + " is not in the database", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return v;

    }
}

