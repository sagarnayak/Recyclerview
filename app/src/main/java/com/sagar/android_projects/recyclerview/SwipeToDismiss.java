package com.sagar.android_projects.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.sagar.android_projects.recyclerview.adapter.RecyclerviewSwipeToDismissAdapter;
import com.sagar.android_projects.recyclerview.util.SwipeDismissItemTouchHelper;

import java.util.ArrayList;

public class SwipeToDismiss extends AppCompatActivity implements SwipeDismissItemTouchHelper.itemswiped {

    RecyclerView recyclerView;

    ArrayList<String> data;
    RecyclerviewSwipeToDismissAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_to_dismiss);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ////////////////////////////////////////////////////////////////////////////////////////////
        //view binding
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_swipe_to_dismiss);
        ////////////////////////////////////////////////////////////////////////////////////////////

        /*
        set the layout manager
         */
        recyclerView.setLayoutManager(new LinearLayoutManager(SwipeToDismiss.this));
        /*
        set the item animator
         */
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        /*
        create dataset for the adapter
         */
        data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add("dsfbdfbdg");
        }
        /*
        set the data to the adapter and set adapter to recyclerview
         */
        adapter = new RecyclerviewSwipeToDismissAdapter(data);
        recyclerView.setAdapter(adapter);

        /*
        we have created a custom itemTouchHelper.SimpleCallback class.
        create the object of it.
        attach the recyclerview to this object.
         */
        ItemTouchHelper.SimpleCallback itemSimpleCallback = new SwipeDismissItemTouchHelper(0, ItemTouchHelper.LEFT, SwipeToDismiss.this);
        new ItemTouchHelper(itemSimpleCallback).attachToRecyclerView(recyclerView);
    }

    /*
    this is the callback method of the custom itemTouchHelper.SimpleCallback class that is created.
    this will be called when any item is swiped.
     */
    @Override
    public void swiped(int position) {
        data.remove(position);
        adapter.notifyItemRemoved(position);
    }
}
