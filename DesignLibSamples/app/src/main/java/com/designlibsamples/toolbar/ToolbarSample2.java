package com.designlibsamples.toolbar;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.designlibsamples.R;
import com.designlibsamples.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fishy on 2017/2/8.
 */

public class ToolbarSample2 extends AppCompatActivity implements View.OnClickListener {
    TextView title;
    ImageView iconLeft;
    ImageView iconRight;
    View fillView;
    PopupWindow popupWindow;
    RecyclerView menuRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar2);
        fillView = findViewById(R.id.fillView);
        title = (TextView) findViewById(R.id.title);
        iconLeft = (ImageView) findViewById(R.id.iconLeft);
        iconRight = (ImageView) findViewById(R.id.iconRight);
        title.setText("主标题");
        iconLeft.setImageResource(R.mipmap.icon_info);
        iconRight.setImageResource(R.mipmap.icon_list);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        fillView.getLayoutParams().height = Util.getStatusBarHeight(this);
        iconLeft.setOnClickListener(this);
        iconRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iconLeft:
                break;
            case R.id.iconRight:
                displayMenuView();
                break;
        }
    }

    /**
     * 打开菜单
     */
    void displayMenuView() {
        if (popupWindow == null) {
            View content = LayoutInflater.from(this).inflate(R.layout.menu_more_view, null);
            menuRecyclerView = (RecyclerView) content.findViewById(R.id.menuRecyclerView);
            MenuItemAdapter adapter = new MenuItemAdapter(this, createMenuItem());
            menuRecyclerView.setAdapter(adapter);
            menuRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            popupWindow = new PopupWindow(content);
            popupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
            popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
            popupWindow.setFocusable(true);
            //设置可以点击外围区域关闭
            popupWindow.setOutsideTouchable(true);
            popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        }
        popupWindow.showAsDropDown(iconRight);
    }

    List<MenuItem> createMenuItem() {
        List<MenuItem> items = new ArrayList<>();
        items.add(new MenuItem(R.mipmap.icon_display, "展示"));
        items.add(new MenuItem(R.mipmap.icon_mail, "邮件"));
        items.add(new MenuItem(R.mipmap.icon_pay, "支付"));
        items.add(new MenuItem(R.mipmap.icon_skirt, "衬衫"));
        return items;
    }
}
