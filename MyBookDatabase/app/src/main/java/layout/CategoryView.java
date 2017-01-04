package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pr_idi.mydatabaseexample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryView extends Fragment {
    /* recyclerview -> dos layouts
        -uno con la recyclerview
        -otro que define como es cada elemento
       pasar adapter a recyclerview
       definir en myAdapter un custom viewholder (llenar elementos de la lista con lo que decimos)
       coger layout y asignar textos a textviews (en el adapter)
       y pasarle el adapter a la recyclerview

    */

    private RecyclerView recycler;
    private RecyclerView.LayoutManager layoutmanager;
    private MyAdapter myadapter;

    public CategoryView() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        recycler = (RecyclerView) getView().findViewById(R.id.recycler_view);
        recycler.setAdapter(myadapter);
        recycler.setLayoutManager(layoutmanager);

        return inflater.inflate(R.layout.fragment_category_view, container, false);
    }

}
