package com.sagar.android_projects.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sagar.android_projects.recyclerview.R;

import java.util.ArrayList;

/**
 * Created by sagar on 10/20/2017.
 * this is the adapter for the swipe to dismiss recyclerview.
 * the major difference in this adapter is in its view.
 * in its view there is a foreground view and a background view.
 * the foreground is shown by default.
 * and the background is shown when the user has swiped the view.
 * this foreground view has to be bind in the holder. as this is to be used in the ItemTouchHelper.SimpleCallback
 * class that is created.
 */
public class RecyclerviewAddRemoveItemAdapter extends RecyclerView.Adapter<RecyclerviewAddRemoveItemAdapter.ViewHolderRecyclerviewAnimation> {

    ArrayList<String> datas;

    public RecyclerviewAddRemoveItemAdapter(ArrayList<String> datas) {
        this.datas = datas;
    }

    @Override
    public ViewHolderRecyclerviewAnimation onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderRecyclerviewAnimation(LayoutInflater.from(parent.getContext()).inflate(R.layout.singleview_recyclerview_animation, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolderRecyclerviewAnimation holder, int position) {

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolderRecyclerviewAnimation extends RecyclerView.ViewHolder {

        public ViewHolderRecyclerviewAnimation(View itemView) {
            super(itemView);
        }
    }
}
