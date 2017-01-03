package com.example.pr_idi.mydatabaseexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by carlo on 03/01/2017.
 */

public class AdapterIDI extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    List<Book> mBooks;


    public AdapterIDI(Context context, List<Book> books) {
        super();
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.mBooks = books;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView = layoutInflater.inflate(R.layout. null);
        convertView= layoutInflater.inflate(R.layout.content_by_author, null);

        TextView txt=(TextView)convertView.findViewById(R.id.text);




        return convertView;
        //return null;
    }
}