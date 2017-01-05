package com.example.pr_idi.mydatabaseexample;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHelp extends Fragment {


    public FragmentHelp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_fragment_help, container, false);

        Resources res = getResources();



        TabHost tabs=(TabHost)v.findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("", res.getDrawable(R.drawable.information_variant));
        tabs.addTab(spec);

        spec = tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("", res.getDrawable(R.drawable.home));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab3");
        spec.setContent(R.id.tab3);
        spec.setIndicator("", res.getDrawable(R.drawable.ic_add_black_24dp));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab4");
        spec.setContent(R.id.tab4);
        spec.setIndicator("", res.getDrawable(R.drawable.book_open_page_variant));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("mitab5");
        spec.setContent(R.id.tab5);
        spec.setIndicator("", res.getDrawable(R.drawable.account_search));
        tabs.addTab(spec);

        tabs.setCurrentTab(0);

        return v;

    }

}

/*
*  TabLayout tabLayout = (TabLayout) findViewById(R.id.tabanim_tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()) {
                    case 0:
                        showToast("One");
                        break;
                    case 1:
                        showToast("Two");

                        break;
                    case 2:
                        showToast("Three");

                        break;
                }
            }

*
* */
