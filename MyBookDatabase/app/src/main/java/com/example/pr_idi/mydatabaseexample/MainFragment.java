package com.example.pr_idi.mydatabaseexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private BookData bookData;
    private List<Book> mBooks;
    private ListView lvBooks;
    private AdapterIDI adapter;
    private LinearLayout mLinearLayout;
    boolean obert = false;


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                if (!obert) {
                    final View Layout = view.findViewById(R.id.layoutdesplegable);
                    final View Layout2 = view.findViewById(R.id.layoutdesplegable2);
                    final ImageButton tancar = (ImageButton) view.findViewById(R.id.tancar);
                    Layout.setVisibility(View.VISIBLE);
                    Layout2.setVisibility(View.VISIBLE);
                    tancar.setVisibility(View.VISIBLE);
                    obert = true;

                    final TextView nomllibre = (TextView) view.findViewById(R.id.nomllibre);
                    nomllibre.setTextColor(Color.parseColor("#0000FF"));

                    final TextView valoracio = (TextView) view.findViewById(R.id.valoracio);

                    final Book book = adapter.llibre(position);

                    valoracio.setText(book.getPersonal_evaluation());

                    switch(book.getPersonal_evaluation()) {
                        case "Very bad":
                            valoracio.setTextColor(Color.parseColor("#9e0303"));
                            break;
                        case "Bad":
                            valoracio.setTextColor(Color.parseColor("#db8300"));
                            break;
                        case "Fair":
                            valoracio.setTextColor(Color.parseColor("#acce04"));
                            break;
                        case "Good":
                            valoracio.setTextColor(Color.parseColor("#26b705"));
                            break;
                        case "Very good":
                            valoracio.setTextColor(Color.parseColor("#136301"));
                            break;
                    }


                    final Spinner spinner = (Spinner) view.findViewById(R.id.modificaciodepuntuacio);

                    Button modificacio = (Button) view.findViewById(R.id.modificacioboto);
                    modificacio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            bookData.canviavaloracio(book, spinner.getSelectedItem().toString());
                            book.setPersonal_evaluation(spinner.getSelectedItem().toString());

                            valoracio.setText(book.getPersonal_evaluation());

                            switch(book.getPersonal_evaluation()) {
                                case "Very bad":
                                    valoracio.setTextColor(Color.parseColor("#9e0303"));
                                    break;
                                case "Bad":
                                    valoracio.setTextColor(Color.parseColor("#db8300"));
                                    break;
                                case "Fair":
                                    valoracio.setTextColor(Color.parseColor("#acce04"));
                                    break;
                                case "Good":
                                    valoracio.setTextColor(Color.parseColor("#26b705"));
                                    break;
                                case "Very good":
                                    valoracio.setTextColor(Color.parseColor("#136301"));
                                    break;
                            }
                        }
                    });


                    tancar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Layout.setVisibility(View.GONE);
                            Layout2.setVisibility(View.GONE);
                            tancar.setVisibility(View.GONE);
                            nomllibre.setTextColor(Color.parseColor("#000000"));
                            obert = false;
                        }
                    });
                }

                else {
                    Snackbar.make(view, "Please, to open another book, first close the opened one", Snackbar.LENGTH_LONG).show();
                }
            }

        });

        return v;
    }
}
