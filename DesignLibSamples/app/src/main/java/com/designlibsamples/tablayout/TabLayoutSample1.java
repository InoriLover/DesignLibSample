package com.designlibsamples.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.designlibsamples.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fishy on 2017/2/8.
 */

public class TabLayoutSample1 extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager fragmentViewpager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout1);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        fragmentViewpager = (ViewPager) findViewById(R.id.content);
        confViewpager();
        fragmentViewpager.setAdapter(viewPagerAdapter);
//        TabLayout.Tab tab1 = tabLayout.newTab();
//        TabLayout.Tab tab2 = tabLayout.newTab();
//        TabLayout.Tab tab3 = tabLayout.newTab();
//        tab1.setText("选项一");
//        tab2.setText("选项二");
//        tab3.setText("选项三");
        tabLayout.setupWithViewPager(fragmentViewpager);
        tabLayout.getTabAt(0).setText("选项一")  ;
        tabLayout.getTabAt(1).setText("选项二");
        tabLayout.getTabAt(2).setText("选项三");
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(android.R.color.white));
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabTextColors(getResources().getColor(R.color.alpha_snow_white),
                getResources().getColor(R.color.snow_white));
    }

    /**
     * 配置viewpager
     */
    void confViewpager() {
        ContentFragment fragment1 = new ContentFragment();
        ContentFragment fragment2 = new ContentFragment();
        ContentFragment fragment3 = new ContentFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString(ContentFragment.TAG_TITLE, "PageOne");
        fragment1.setArguments(bundle1);
        Bundle bundle2 = new Bundle();
        bundle2.putString(ContentFragment.TAG_TITLE, "PageTwo");
        fragment2.setArguments(bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString(ContentFragment.TAG_TITLE, "PageThree");
        fragment3.setArguments(bundle3);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
    }
}
