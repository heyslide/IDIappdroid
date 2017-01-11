package com.example.pr_idi.mydatabaseexample;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
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

        final EditText title = (EditText) v.findViewById(R.id.textAddTitle);
        title.setHint("ex: Pride and Prejudice");
        final EditText author = (EditText) v.findViewById(R.id.textAddAuthor);
        author.setHint("ex: Jane Austen");
        final EditText publisher = (EditText) v.findViewById(R.id.textAddPublisher);
        publisher.setHint("ex: Whitehall");
        final EditText year = (EditText) v.findViewById(R.id.textAddYear);
        year.setHint("ex: 1813");
        final Spinner category = (Spinner) v.findViewById(R.id.spinAddCategory);
        final Spinner rating = (Spinner) v.findViewById(R.id.spinAddPuntuation);

        mButton = (Button)v.findViewById(R.id.addBookToDB);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titol = title.getText().toString();
                String autor = author.getText().toString();
                String publicador = publisher.getText().toString();
                String any = year.getText().toString();
                String categoria = category.getSelectedItem().toString();
                String valoracio = rating.getSelectedItem().toString();

                if (titol.isEmpty() || autor.isEmpty() || publicador.isEmpty() || any.isEmpty()) {
                    Snackbar.make(v, "All fields are required", Snackbar.LENGTH_SHORT).show();
                }
                else{
                    Integer anyint = Integer.parseInt(any);
                    book = bookData.createBook(titol, autor, publicador, anyint, categoria, valoracio);
                    Snackbar.make(v, "Book added correctly!", Snackbar.LENGTH_LONG).show();
                    title.setText("");
                    author.setText("");
                    publisher.setText("");
                    year.setText("");
                }
            }
        });

        return v;
    }
}


