package com.example.pr_idi.mydatabaseexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAfegir extends Fragment {

    private BookData bookData;
    private Button mButton;
    private Book book;


    public FragmentAfegir() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_afegir, container, false);

        bookData = new BookData(getActivity());
        bookData.open();

        mButton = (Button) v.findViewById(R.id.addBookToDB);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText title = (EditText)v.findViewById(R.id.textAddTitle);
                EditText author = (EditText)v.findViewById(R.id.textAddAuthor);
                EditText publisher = (EditText)v.findViewById(R.id.textAddPublisher);
                EditText year = (EditText)v.findViewById(R.id.textAddYear);
                Spinner category = (Spinner)v.findViewById(R.id.spinAddCategory);
                Spinner rating = (Spinner)v.findViewById(R.id.spinAddPuntuation);

                // save the new book to the database

                if (isEmpty(title) || isEmpty(author) || isEmpty(publisher) || isEmpty(year)) {
                    Toast toast = Toast.makeText(getActivity(), "All fields are required", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    book = bookData.createBook(title.getText().toString(), author.getText().toString(),
                            publisher.getText().toString(), Integer.parseInt(year.getText().toString()),
                            category.getSelectedItem().toString(), rating.getSelectedItem().toString());
                }
            }
        });

        return v;
    }

    private boolean isEmpty(EditText field) {
        if (field.getText().toString().isEmpty()) return true;
        else return false;
    }

}


