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

import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Book> books;
    private Context context;
    private RecyclerViewClickListener listener;

    public MyAdapter(Context contextact, List<Book> values, RecyclerViewClickListener listener) {
        super();
        this.context = contextact;
        this.books = values;
        this.listener = listener;
    }

    public void substituteList (List<Book> newvalues) {
        books = newvalues;
    }

    public Object getItem(int position) {
        return books.get(position);
    }

    public void deleteItem(int position) { books.remove(position);}

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

    public List<Book> filterByTitle(List<Book> tofilter, String newText) {
        final String lowercase = newText.toLowerCase();

        final List<Book> filteredList = new ArrayList<>();
        for (Book book : tofilter) {
            final String title = book.getTitle().toLowerCase();
            if (title.contains(lowercase)) filteredList.add(book);
        }
        return filteredList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null)
                        listener.onRowClicked(getAdapterPosition());
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null)
                        listener.onViewClicked(v, getAdapterPosition());
                }
             });
        }
    }
}
