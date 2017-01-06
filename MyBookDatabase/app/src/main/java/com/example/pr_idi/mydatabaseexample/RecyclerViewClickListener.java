package com.example.pr_idi.mydatabaseexample;

import android.view.View;

/**
 * Created by carlo on 06/01/2017.
 */
public interface RecyclerViewClickListener {

    void onRowClicked(int position);
    void onViewClicked(View v, int position);
}
