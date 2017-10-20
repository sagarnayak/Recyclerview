package com.sagar.android_projects.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.sagar.android_projects.recyclerview.adapter.GridviewAnimationAdapter;
import com.sagar.android_projects.recyclerview.util.GridRecyclerview;

public class GridViewAnimation extends AppCompatActivity {

    GridRecyclerview recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_animation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ////////////////////////////////////////////////////////////////////////////////////////////
        //view binding
        recyclerView = (GridRecyclerview) findViewById(R.id.recyclerview_gridview_animation);
        ////////////////////////////////////////////////////////////////////////////////////////////

        /*
        set the gridlayout manager for the custom gridlayout
         */
        recyclerView.setLayoutManager(new GridLayoutManager(GridViewAnimation.this, 3));
        /*
        apply the custom animation to the grid layout
         */
        int resId = R.anim.grid_layout_animation_slide_from_bottom;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(GridViewAnimation.this, resId);
        recyclerView.setLayoutAnimation(animation);
        /*
        set the adapter
         */
        recyclerView.setAdapter(new GridviewAnimationAdapter());
    }

}
