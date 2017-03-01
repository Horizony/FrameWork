package com.cn.horizon.life.widgets.tools;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by horizony on 2017/2/28.
 */

public class BottomHideBehavior extends CoordinatorLayout.Behavior<View> {
    public BottomHideBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {

        float translationY = Math.abs(dependency.getTop());
        child.setTranslationY(translationY);
        return true;
    }
}
