package com.designlibsamples.coordinatorlayout;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.text.style.TtsSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Fishy on 2017/2/16.
 */

public class FloatTextBehavior extends CoordinatorLayout.Behavior<TextView> {
    FloatTextBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        float x = dependency.getX();
        float y = dependency.getY();
        child.setX(x);
        child.setY(y + dependency.getHeight() * 2);
        child.setText("position:x-->" + x + "\ny-->" + y);
        return true;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof Button;
    }
}
