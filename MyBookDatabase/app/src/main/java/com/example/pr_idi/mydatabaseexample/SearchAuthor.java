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
public class SearchAuthor extends Fragment {

    private BookData bookData;
    private Button mFindButton;
    private ListView mlist;
    private static final String TAG = "ByAuthor";

    public SearchAuthor() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_author, container, false);

        final EditText nom_autor = (EditText) v.findViewById(R.id.nomautorinsertat);

        mFindButton = (Button) v.findViewById(R.id.boto);
        mFindButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               bookData = new BookData(getActivity());
               bookData.open();

               if (nom_autor.getText().toString().isEmpty()) {
                   Toast.makeText(getActivity(), "The field is Requiered", Toast.LENGTH_SHORT).show();
               }

               else {
                   String nomautor = nom_autor.getText().toString();
                   final List<Book> values = bookData.getBooksAuthor(nomautor);
                   mlist = (ListView) v.findViewById(R.id.list_autor);

                   ArrayAdapter<Book> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, values);
                   mlist.setAdapter(adapter);

                   if (adapter.isEmpty()) {
                       Toast.makeText(getActivity(), "The Author " + nomautor + " is not at the DataBase", Toast.LENGTH_SHORT).show();
                   }
               }
           }
        });

        return v;

    }
}
