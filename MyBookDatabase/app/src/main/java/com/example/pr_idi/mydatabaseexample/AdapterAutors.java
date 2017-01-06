package com.example.pr_idi.mydatabaseexample;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by carlo on 06/01/2017.
 */

public class AdapterAutors extends BaseAdapter{

    private Context mContext;
    private List<Book> Autors;

    public AdapterAutors(Context context, List<Book> autors) {
        mContext = context;
        Autors = autors;
    }

    @Override
    public int getCount() {
        return Autors.size();
    }

    @Override
    public Object getItem(int position) {
        return Autors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.list_authors, null);

        TextView nomll = (TextView) v.findViewById(R.id.autor);
        nomll.setText(Autors.get(position).getAuthor());

        return v;
    }
}


/*public class AdapterIDI extends BaseAdapter {

    private Context mContext;
    private List<Book> mBooks;
    private RatingBar valoracio;
    private Button aplicar;
    private boolean expandit;

    //Constructor
    public AdapterIDI(Context context, List<Book> books) {
        mContext = context;
        mBooks = books;
    }

    @Override
    public int getCount() {
        return mBooks.size();
    }

    @Override
    public Object getItem(int position) {
        return mBooks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(mContext, R.layout.list_view, null);

        TextView nomll = (TextView) v.findViewById(R.id.nomllibre);
        nomll.setText(mBooks.get(position).getTitle());

        valoracio = (RatingBar) v.findViewById(R.id.estrellas);
        aplicar = (Button) v.findViewById(R.id.modifybutton);

        ImageButton modificacio = (ImageButton) v.findViewById(R.id.modificar);
        /*modificacio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!expandit){
                    expandir();

                }

                else {
                    desexpandir();
                }

            }
        });*/

      /*  v.setTag(mBooks.get(position).getId());

        return v;
    }

    public void expandir() {
        expandit = true;
        aplicar.setVisibility(View.VISIBLE);
        valoracio.setVisibility(View.VISIBLE);
    }

    public void desexpandir() {
        expandit = false;
        aplicar.setVisibility(View.GONE);
        valoracio.setVisibility(View.GONE);
    }
}*/