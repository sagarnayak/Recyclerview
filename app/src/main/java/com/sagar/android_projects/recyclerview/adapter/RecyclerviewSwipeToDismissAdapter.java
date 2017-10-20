package com.sagar.android_projects.recyclerview.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sagar.android_projects.recyclerview.R;

import java.util.ArrayList;

/**
 * Created by sagar on 10/20/2017.
 */
public class RecyclerviewSwipeToDismissAdapter extends RecyclerView.Adapter<RecyclerviewSwipeToDismissAdapter.ViewHolderRecyclerviewAnimation> {

    ArrayList<String> arrayList;

    public RecyclerviewSwipeToDismissAdapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolderRecyclerviewAnimation onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderRecyclerviewAnimation(LayoutInflater.from(parent.getContext()).inflate(R.layout.singleview_recyclerview_swipe_to_dismiss, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolderRecyclerviewAnimation holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolderRecyclerviewAnimation extends RecyclerView.ViewHolder {

        public View viewBackground;
        public CardView cardViewForeground;

        ViewHolderRecyclerviewAnimation(View itemView) {
            super(itemView);

            viewBackground = itemView.findViewById(R.id.swipe_dismiss_view);
            cardViewForeground = itemView.findViewById(R.id.cardview_swipe_dismiss);
        }
    }
}
