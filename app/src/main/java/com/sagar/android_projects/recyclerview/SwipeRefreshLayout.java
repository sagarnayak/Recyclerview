package com.sagar.android_projects.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.sagar.android_projects.recyclerview.adapter.RecyclerviewAnimationAdapter;

public class SwipeRefreshLayout extends AppCompatActivity {

    android.support.v4.widget.SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ////////////////////////////////////////////////////////////////////////////////////////////
        //view binding
        swipeRefreshLayout = (android.support.v4.widget.SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_swipe_refresh);
        ////////////////////////////////////////////////////////////////////////////////////////////

        recyclerView.setLayoutManager(new LinearLayoutManager(SwipeRefreshLayout.this));
        recyclerView.setAdapter(new RecyclerviewAnimationAdapter());

        /*
        do not get confused with the thread. the thread is just used to wait for 3 seconds and dismiss
        the swipe refresh. in real app you will perform the data fetching work and after its comletion
        just call the swipeRefreshLayout.setRefreshing(false);
        this will hide the swipe refresh progress.
         */
        swipeRefreshLayout.setOnRefreshListener(new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    swipeRefreshLayout.setRefreshing(false);
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }

}
