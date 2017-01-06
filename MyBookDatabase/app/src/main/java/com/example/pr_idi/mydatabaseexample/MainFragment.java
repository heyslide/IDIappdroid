package com.example.pr_idi.mydatabaseexample;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
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
    //private PopupWindow popUpWindow;
    //private FrameLayout positionOfPopUp;


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

        //positionOfPopUp = (FrameLayout) v.findViewById(R.id.popUp_position);

        lvBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                Toast.makeText(getActivity(), "PARA1", Toast.LENGTH_SHORT).show();
                View spiner = view.findViewById(R.id.estrellas);
                if(spiner.getVisibility() == View.GONE) {
                    //adapter.expandir();
                    spiner.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "PARA2", Toast.LENGTH_SHORT).show();
                }
                else {
                    //adapter.desexpandir();
                    spiner.setVisibility(View.GONE);
                    Toast.makeText(getActivity(), "PARA3", Toast.LENGTH_SHORT).show();
                }
                //adapter.notifyDataSetChanged();
            }
        });

        return v;
    }

    //class ListView implements AdapterView.OnItemClickListener()

    /*class ItemList implements AdapterView.OnItemClickListener(
        @Override
        public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

        }
    });*/


}

/*/* View costumView = inflater.inflate(R.layout.popupwindowlayout,null);
                popUpWindow = new PopupWindow(
                        costumView,
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );

                ImageButton canviar = (ImageButton) costumView.findViewById(R.id.okey);
                canviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                ImageButton nocanviar = (ImageButton) costumView.findViewById(R.id.cancelar);
                nocanviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popUpWindow.dismiss();
                    }
                });

                popUpWindow.showAtLocation(positionOfPopUp, Gravity.CENTER,0,0);*/

//Toast.makeText(getActivity(), "book seleccionado" + id, Toast.LENGTH_SHORT).show();
                /*popUpWindow.showAtLocation(getView(), Gravity.BOTTOM, 10, 10);
                popUpWindow.update(50, 50, 320, 90);*/