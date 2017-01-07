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

        v.setTag(Autors.get(position).getId());

        return v;
    }
}

