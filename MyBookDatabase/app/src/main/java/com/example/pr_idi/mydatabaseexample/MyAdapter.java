package com.example.pr_idi.mydatabaseexample;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Achro on 03/01/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Book> books;
    private Context context;

    public MyAdapter(Context contextact, List<Book> values) {
        super();
        this.context = contextact;
        this.books = values;
    }

    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_inside_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Book book = books.get(position);
        Integer any = book.getYear();
        holder.title.setText(book.getTitle());
        holder.author.setText(book.getAuthor());
        holder.year.setText(any.toString() + ", " + book.getPublisher());
        //holder.publisher.setText(book.getPublisher());
        holder.category.setText(book.getCategory());
        holder.rating.setText(book.getPersonal_evaluation());
        switch(holder.rating.getText().toString()) {
            case "Very bad":
                holder.rating.setTextColor(Color.parseColor("#9e0303"));
                break;
            case "Bad":
                holder.rating.setTextColor(Color.parseColor("#db8300"));
                break;
            case "Fair":
                holder.rating.setTextColor(Color.parseColor("#acce04"));
                break;
            case "Good":
                holder.rating.setTextColor(Color.parseColor("#26b705"));
                break;
            case "Very good":
                holder.rating.setTextColor(Color.parseColor("#136301"));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void filterByTitle(String newText) {
        //pffffffffFFFFFFFFFF
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView author;
        TextView year;
        //TextView publisher;
        TextView category;
        TextView rating;
        ImageView delete;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.textRTitle);
            author = (TextView) itemView.findViewById(R.id.textRAuthor);
            year = (TextView) itemView.findViewById(R.id.textRYear);
            //publisher = (TextView) itemView.findViewById(R.id.textRPublisher);
            category = (TextView) itemView.findViewById(R.id.textRCategory);
            rating = (TextView) itemView.findViewById(R.id.textRRating);
            delete = (ImageView) itemView.findViewById(R.id.ivDeleteBook);


        }
    }
}
