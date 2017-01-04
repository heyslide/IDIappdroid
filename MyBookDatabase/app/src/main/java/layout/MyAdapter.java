package layout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pr_idi.mydatabaseexample.Book;
import com.example.pr_idi.mydatabaseexample.BookData;
import com.example.pr_idi.mydatabaseexample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Achro on 03/01/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Book> books;

    public MyAdapter(List<Book> values) {
        super();
        books = values;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_inside_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Book book = books.get(position);
        holder.title.setText(book.getTitle());
        holder.author.setText(book.getAuthor());
        holder.year.setText(book.getYear());
        holder.publisher.setText(book.getPublisher());
        holder.rating.setText(book.getPersonal_evaluation());

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView author;
        TextView year;
        TextView publisher;
        TextView category;
        TextView rating;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.textRTitle);
            author = (TextView) itemView.findViewById(R.id.textRAuthor);
            year = (TextView) itemView.findViewById(R.id.textRYear);
            publisher = (TextView) itemView.findViewById(R.id.textRPublisher);
            category = (TextView) itemView.findViewById(R.id.textRCategory);
            rating = (TextView) itemView.findViewById(R.id.textRRating);
        }
    }

}
