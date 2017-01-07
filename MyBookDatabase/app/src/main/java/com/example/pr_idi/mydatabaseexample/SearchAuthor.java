package com.example.pr_idi.mydatabaseexample;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
    private AdapterAutors autors;
    private EditText mEditText;
    private Button mallauthors;

    public SearchAuthor() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search_author, container, false);

        mEditText = (EditText) v.findViewById(R.id.nomautorinsertat);
        lvBooks = (ListView) v.findViewById(R.id.list_autor);

        bookData = new BookData(getActivity());
        bookData.open();

        mFindButton = (Button) v.findViewById(R.id.boto);
        mFindButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


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

        mallauthors = (Button) v.findViewById(R.id.allauthors);
        mallauthors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mBooks = bookData.getAllBooks();
                autors = new AdapterAutors(getActivity(), mBooks);
                lvBooks.setAdapter(autors);

                Snackbar.make(v, "CHOOSE ONE OF THESE AUTHORS FOR SEE HIS BOOKS", Snackbar.LENGTH_LONG).show();

                lvBooks.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String nomautor = lvBooks.getItemAtPosition(position).toString();
                        mEditText.setText(nomautor);
                    }
                });

            }
        });




        return v;

    }
}
