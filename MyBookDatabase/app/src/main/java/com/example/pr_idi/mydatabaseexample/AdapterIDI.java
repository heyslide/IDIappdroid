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

    Context mContext;
    List<Book> mBooks;


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

        v.setTag(mBooks.get(position).getId());

        return v;
    }
}