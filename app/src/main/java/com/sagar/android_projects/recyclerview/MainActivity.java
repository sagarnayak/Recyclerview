package com.sagar.android_projects.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonRecyclerviewAnimation;
    Button buttonRecyclerviewSwipeRefresh;
    Button buttonAddRemoveItem;
    Button buttonSwipeToDismiss;
    Button buttonGridviewAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ////////////////////////////////////////////////////////////////////////////////////////////
        //view binding
        buttonRecyclerviewAnimation = (Button) findViewById(R.id.recyclerview_animation);
        buttonRecyclerviewSwipeRefresh = (Button) findViewById(R.id.recyclerview_swipe_refresh);
        buttonAddRemoveItem = (Button) findViewById(R.id.recyclerview_add_remove_item);
        buttonSwipeToDismiss = (Button) findViewById(R.id.recyclerview_swipe_to_dismiss);
        buttonGridviewAnimation = (Button) findViewById(R.id.gridview_animation);
        ////////////////////////////////////////////////////////////////////////////////////////////

        buttonRecyclerviewAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecyclerviewAnimation.class));
            }
        });

        buttonRecyclerviewSwipeRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SwipeRefreshLayout.class));
            }
        });

        buttonAddRemoveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddRemoveItem.class));
            }
        });

        buttonSwipeToDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SwipeToDismiss.class));
            }
        });

        buttonGridviewAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GridViewAnimation.class));
            }
        });
    }
}
