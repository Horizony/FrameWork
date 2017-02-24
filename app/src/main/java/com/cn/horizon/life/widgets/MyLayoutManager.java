package com.cn.horizon.life.widgets;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by horizony on 2016/12/20.
 */

public class MyLayoutManager extends RecyclerView.LayoutManager {
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getItemCount() < 1 || state.isPreLayout()) return;

        detachAndScrapAttachedViews(recycler);
        View firstView = recycler.getViewForPosition(0);
        measureChildWithMargins(firstView, 0, 0);
        int width = getDecoratedMeasuredWidth(firstView);
        int height = getDecoratedMeasuredHeight(firstView);

        int offX = 0, offY = 0;
        for (int i = 0; i < getItemCount(); i++) {
            View scrap = recycler.getViewForPosition(i);
            addView(scrap);
            measureChildWithMargins(scrap, 0, 0);
            layoutDecoratedWithMargins(scrap, offX, offY, offX + width, offY + height);
            offX += width;
            offY += height;
        }
    }

    @Override
    public boolean canScrollHorizontally() {
        return true;
    }

    @Override
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.scrollHorizontallyBy(dx, recycler, state);
    }

    @Override
    public boolean canScrollVertically() {
        return true;
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.scrollVerticallyBy(dy, recycler, state);
    }

}
