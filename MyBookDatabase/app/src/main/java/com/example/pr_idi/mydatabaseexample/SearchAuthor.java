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
    private List<Book> mBooks;
    private ListView lvBooks;
    private AdapterIDI adapter;
    private EditText mEditText;

    public SearchAuthor() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_author, container, false);

        lvBooks = (ListView) v.findViewById(R.id.list_books);
        mEditText = (EditText) v.findViewById(R.id.nomautorinsertat);
        lvBooks = (ListView) v.findViewById(R.id.list_autor);

        mFindButton = (Button) v.findViewById(R.id.boto);
        mFindButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               bookData = new BookData(getActivity());
               bookData.open();

               if (mEditText.getText().toString().isEmpty()) {
                   Toast.makeText(getActivity(), "The field is Requiered", Toast.LENGTH_SHORT).show();
               }

               else {
                   String nomautor = mEditText.getText().toString();

                   mBooks = bookData.getBooksAuthor(nomautor);
                   adapter = new AdapterIDI(getActivity(), mBooks);
                   lvBooks.setAdapter(adapter);

                   if (adapter.isEmpty()) {
                       Toast.makeText(getActivity(), "The Author " + nomautor + " is not at the DataBase", Toast.LENGTH_SHORT).show();
                   }



               }
           }
        });

        return v;

    }
}
