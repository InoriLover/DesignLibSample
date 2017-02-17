package com.designlibsamples.coordinatorlayout;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Fishy on 2017/2/17.
 */

public class TopLayoutBehavior extends CoordinatorLayout.Behavior<LinearLayout> {
    int offsetTotal = 0;
    boolean scrolling = false;

    TopLayoutBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, LinearLayout child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, LinearLayout child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        offset(child,dyConsumed);
        Log.i("test","dxConsumed-->"+dxConsumed);
        Log.i("test","dxUnconsumed-->"+dxUnconsumed);
    }
    public void offset(View child,int dy){
        int old = offsetTotal;
        int top = offsetTotal - dy;
        //最小值取负高度
        top = Math.max(top, -child.getHeight());
        //最大值取0
        top = Math.min(top, 0);
        //top代表偏移量
        offsetTotal = top;
        if (old == offsetTotal){
            scrolling = false;
            return;
        }
        int delta = offsetTotal-old;
        child.offsetTopAndBottom(delta);
        scrolling = true;
    }
}
