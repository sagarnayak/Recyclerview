package com.sagar.android_projects.recyclerview.util;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.sagar.android_projects.recyclerview.adapter.RecyclerviewSwipeToDismissAdapter;

/**
 * Created by sagar on 10/20/2017.
 * this is the custom itemTouchHelper.SimpleCallback class created to handle the swipe left behaviour
 * of the items in the recyclerview.
 * to use this in your code just extend a class with ItemTouchHelper.SimpleCallback.
 * implement the methods.
 * also override onSelectedChanged(), onChildDrawOver(), clearView(), onChildDraw() methods.
 * or you can paste the methods directly to your class from here. and replace the viewForeground with your
 * foreground view for the recyclerview.
 */
public class SwipeDismissItemTouchHelper extends ItemTouchHelper.SimpleCallback {

    private Context context;

    public SwipeDismissItemTouchHelper(int dragDirs, int swipeDirs, Context context) {
        super(dragDirs, swipeDirs);
        this.context = context;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        ((itemswiped) context).swiped(viewHolder.getAdapterPosition());
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (viewHolder != null) {
            final View foregroundView = ((RecyclerviewSwipeToDismissAdapter.ViewHolderRecyclerviewAnimation) viewHolder).cardViewForeground;
            getDefaultUIUtil().onSelected(foregroundView);
        }
    }

    @Override
    public void onChildDrawOver(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        final View foregroundView = ((RecyclerviewSwipeToDismissAdapter.ViewHolderRecyclerviewAnimation) viewHolder).cardViewForeground;
        getDefaultUIUtil().onDrawOver(c, recyclerView, foregroundView, dX, dY,
                actionState, isCurrentlyActive);
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        final View foregroundView = ((RecyclerviewSwipeToDismissAdapter.ViewHolderRecyclerviewAnimation) viewHolder).cardViewForeground;
        getDefaultUIUtil().clearView(foregroundView);
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        final View foregroundView = ((RecyclerviewSwipeToDismissAdapter.ViewHolderRecyclerviewAnimation) viewHolder).cardViewForeground;

        getDefaultUIUtil().onDraw(c, recyclerView, foregroundView, dX, dY,
                actionState, isCurrentlyActive);
    }

    /**
     * interface to notify the calling activity about the item swipe.
     */
    public interface itemswiped {
        void swiped(int position);
    }
}
