package com.designlibsamples.toolbar;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.designlibsamples.R;
import com.designlibsamples.Util;

import java.lang.reflect.Field;

/**
 * Created by Fishy on 2017/2/8.
 */

public class ToolbarSample1 extends AppCompatActivity {
    Toolbar toolbar;
    View fillView;
    Toolbar.OnMenuItemClickListener onMenuItemClickListener = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.item_list:
                    break;
                case R.id.item_info:
                    break;
                case R.id.item_more:
                    break;
            }
            Toast.makeText(ToolbarSample1.this,item.getTitle(),Toast.LENGTH_SHORT).show();
            return true;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar1);
        fillView=findViewById(R.id.fillView);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setLogo(R.mipmap.icon_logo);
        toolbar.setTitle("主标题");
        toolbar.setSubtitle("子标题");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.icon_navi);
        toolbar.setOnMenuItemClickListener(onMenuItemClickListener);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        fillView.getLayoutParams().height= Util.getStatusBarHeight(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

}
