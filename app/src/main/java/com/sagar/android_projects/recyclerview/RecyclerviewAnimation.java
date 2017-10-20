package com.sagar.android_projects.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.sagar.android_projects.recyclerview.adapter.RecyclerviewAnimationAdapter;

public class RecyclerviewAnimation extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_animation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ////////////////////////////////////////////////////////////////////////////////////////////
        //view binding
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        ////////////////////////////////////////////////////////////////////////////////////////////

        /*
        apply the animation to the recyclerview
         */
        int resId = R.anim.layout_animation_slide_from_bottom;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(RecyclerviewAnimation.this, resId);
        recyclerView.setLayoutAnimation(animation);
        /*
        set the layout manager and adapter to the recyclerview
         */
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RecyclerviewAnimation.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new RecyclerviewAnimationAdapter());
    }

}
