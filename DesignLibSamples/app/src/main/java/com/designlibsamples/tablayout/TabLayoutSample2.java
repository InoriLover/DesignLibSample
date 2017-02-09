package com.designlibsamples.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.designlibsamples.R;
import com.designlibsamples.toolbar.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fishy on 2017/2/8.
 */

public class TabLayoutSample2 extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager fragmentViewpager;
    ViewPagerAdapter viewPagerAdapter;
    ImageView imgAdd;
    List<Fragment> fragments;
    AlertDialog addTabItemDialog;
    List<MenuItem> tabItems;
    List<MenuItem> addedItems;

    TabItemAdapter.OnItemClickListener onItemClickListener = new TabItemAdapter.OnItemClickListener() {
        @Override
        public void onClicked(View view, MenuItem item) {
            addFragmentItem(item);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout2);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        imgAdd = (ImageView) findViewById(R.id.imgAdd);
        fragmentViewpager = (ViewPager) findViewById(R.id.content);
        createData();
        confViewpager();
        //已经添加过的tabItem
        addedItems = new ArrayList<>();
        addedItems.add(tabItems.get(0));
        addedItems.add(tabItems.get(1));
        addedItems.add(tabItems.get(2));

        fragmentViewpager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(fragmentViewpager);
        refreshTablayoutItem();
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(android.R.color.white));
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabTextColors(getResources().getColor(R.color.alpha_snow_white),
                getResources().getColor(R.color.snow_white));
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddTabItemMenu();
            }
        });
    }

    /**
     * 创建模拟数据
     */
    void createData() {
        tabItems = new ArrayList<>();
        tabItems.add(new MenuItem(R.mipmap.tab_item_edit, "编辑"));
        tabItems.add(new MenuItem(R.mipmap.tab_item_global, "全球"));
        tabItems.add(new MenuItem(R.mipmap.tab_item_import, "导入"));
        tabItems.add(new MenuItem(R.mipmap.tab_item_lock, "加锁"));
        tabItems.add(new MenuItem(R.mipmap.tab_item_mark, "标记"));
        tabItems.add(new MenuItem(R.mipmap.tab_item_money, "支付"));
        tabItems.add(new MenuItem(R.mipmap.tab_item_print, "打印"));
        tabItems.add(new MenuItem(R.mipmap.tab_item_product, "产品"));
        tabItems.add(new MenuItem(R.mipmap.tab_item_save, "保存"));
        tabItems.add(new MenuItem(R.mipmap.tab_item_tool, "工具"));
        tabItems.add(new MenuItem(R.mipmap.tab_item_user, "用户"));
        tabItems.add(new MenuItem(R.mipmap.tab_item_web, "网页"));
    }

    /**
     * 打开添加Tab的弹框
     */
    void openAddTabItemMenu() {
        if (addTabItemDialog == null) {
            View dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_tabitem, null);
            RecyclerView recyclerView = (RecyclerView) dialogView.findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
            TabItemAdapter tabItemAdapter = new TabItemAdapter(this, tabItems);
            tabItemAdapter.setOnItemClickListener(onItemClickListener);
            recyclerView.setAdapter(tabItemAdapter);
            addTabItemDialog = new AlertDialog.Builder(this).setView(dialogView).create();
        }
        addTabItemDialog.show();
    }

    /**
     * 添加Fragment元素
     *
     * @param item
     */
    void addFragmentItem(MenuItem item) {
        ContentFragment fragmentNew = new ContentFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString(ContentFragment.TAG_TITLE, item.getContent());
        fragmentNew.setArguments(bundle1);
        fragments.add(fragmentNew);
        addedItems.add(item);
        viewPagerAdapter.notifyDataSetChanged();
        refreshTablayoutItem();
        if (addTabItemDialog.isShowing()) {
            addTabItemDialog.cancel();
        }
    }

    /**
     * 刷新tablayout的tab
     */
    void refreshTablayoutItem() {
        for (int i = 0; i < addedItems.size(); i++) {
            tabLayout.getTabAt(i).setIcon(addedItems.get(i).getResourceId());
        }
    }

    /**
     * 配置viewpager
     */
    void confViewpager() {
        ContentFragment fragment1 = new ContentFragment();
        ContentFragment fragment2 = new ContentFragment();
        ContentFragment fragment3 = new ContentFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString(ContentFragment.TAG_TITLE, tabItems.get(0).getContent());
        fragment1.setArguments(bundle1);
        Bundle bundle2 = new Bundle();
        bundle2.putString(ContentFragment.TAG_TITLE, tabItems.get(1).getContent());
        fragment2.setArguments(bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString(ContentFragment.TAG_TITLE, tabItems.get(2).getContent());
        fragment3.setArguments(bundle3);
        fragments = new ArrayList<>();
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
    }
}
