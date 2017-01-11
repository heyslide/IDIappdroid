package com.example.pr_idi.mydatabaseexample;


import android.app.Dialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryView extends Fragment implements RecyclerViewClickListener{

    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutmanager;
    private MyAdapter myadapter;
    private BookData bookdata;

    public CategoryView() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        bookdata = new BookData(getActivity());
        bookdata.open();

        View v = inflater.inflate(R.layout.fragment_category_view, container, false);

        recycler = (RecyclerView) v.findViewById(R.id.recycler_view);

        List<Book> values = bookdata.getAllBooksCategory();
        myadapter = new MyAdapter(getActivity(), values, this);
        recycler.setAdapter(myadapter);
        layoutmanager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(layoutmanager);
        recycler.setItemAnimator(new DefaultItemAnimator());

        View v2 = inflater.inflate(R.layout.recycler_inside_layout, container, false);

        ImageView ivDelete = (ImageView) v2.findViewById(R.id.ivDeleteBook);
        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {

            }
        });

        setHasOptionsMenu(true);

        return v;
    }

    @Override
    public void onCreateOptionsMenu (Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search_title, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint("Search by title...");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<Book> filteredList = myadapter.filterByTitle(bookdata.getAllBooksCategory(), newText);
                myadapter.substituteList(filteredList);
                myadapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    @Override
    public void onRowClicked(int position) {

    }

    @Override
    public void onViewClicked(View v, final int position) {
        if (v.getId() == R.id.ivDeleteBook) {
            //Toast.makeText(getActivity(), "This is item " + position, Toast.LENGTH_SHORT).show();
            
            class DeleteDialog extends DialogFragment {
                @Override
                public Dialog onCreateDialog(Bundle savedInstanceState) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage("Do you wish to delete this book?");
                    builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Book book = (Book) myadapter.getItem(position);
                            bookdata.deleteBook(book);
                            myadapter.deleteItem(position);
                            myadapter.notifyDataSetChanged();
                        }
                    });

                    builder.setNegativeButton("Back", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //No cal fer res
                        }
                    });
                    return builder.create();
                }
            }

            DeleteDialog delete = new DeleteDialog();
            delete.show(getFragmentManager(), "delete");

        }
    }
}
