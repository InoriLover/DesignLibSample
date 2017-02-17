package com.designlibsamples.coordinatorlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.designlibsamples.R;

/**
 * Created by Fishy on 2017/2/13.
 */

public class CoordinatorLayoutSample2 extends AppCompatActivity {
    Button btnShow;
    ViewGroup root;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator2);
        btnShow = (Button) findViewById(R.id.btnShow);
        root= (ViewGroup) findViewById(R.id.root);
        root.setClickable(true);
        root.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        float x = event.getX();
                        float y = event.getY();
                        btnShow.setX(x);
                        btnShow.setY(y);
                        return  true;
                }
                return false;
            }
        });
    }
}
