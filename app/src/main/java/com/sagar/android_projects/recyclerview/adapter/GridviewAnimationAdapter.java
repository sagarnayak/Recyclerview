package com.sagar.android_projects.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sagar.android_projects.recyclerview.R;

/**
 * Created by sagar on 10/20/2017.
 */

public class GridviewAnimationAdapter extends RecyclerView.Adapter<GridviewAnimationAdapter.ViewHolderRecyclerviewAnimation> {

    @Override
    public ViewHolderRecyclerviewAnimation onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderRecyclerviewAnimation(LayoutInflater.from(parent.getContext()).inflate(R.layout.singleview_gridview_animation, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolderRecyclerviewAnimation holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class ViewHolderRecyclerviewAnimation extends RecyclerView.ViewHolder {

        public ViewHolderRecyclerviewAnimation(View itemView) {
            super(itemView);
        }
    }
}
