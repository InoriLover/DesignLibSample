package com.designlibsamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by Fishy on 2017/2/4.
 */

public class MainActivity extends AppCompatActivity {
    SectionAdapter sectionAdapter;
    RecyclerView recyclerView;
    final String testDataStr="Tue, 07 Feb 2017 08:27:31 GMT";

    final String mainPackage = "com.designlibsamples";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        sectionAdapter = new SectionAdapter(this, createData(), gridLayoutManager);
        recyclerView.setAdapter(sectionAdapter);
    }

    List<Section> createData() {
        List<Section> sections = new ArrayList<>();
        //Toolbar示例分组
        Section sectionTemp = new Section("Toolbar");
        List<SampleItem> listTemp = new ArrayList<>();
        try {
            listTemp.add(new SampleItem(Class.forName(mainPackage + ".toolbar.ToolbarSample1"), "标准Toolbar"));
            listTemp.add(new SampleItem(Class.forName(mainPackage + ".toolbar.ToolbarSample2"), "toolbar只作为layout"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        sectionTemp.setItems(listTemp);
        sections.add(sectionTemp);
        //Tablayout分组
        Section sectionTemp2 = new Section("TabLayout");
        List<SampleItem> listTemp2 = new ArrayList<>();
        try {
            listTemp2.add(new SampleItem(Class.forName(mainPackage + ".tablayout.TabLayoutSample1"), "普通TabLayout"));
            listTemp2.add(new SampleItem(Class.forName(mainPackage + ".tablayout.TabLayoutSample2"), "可添加式TabLayout"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        sectionTemp2.setItems(listTemp2);
        sections.add(sectionTemp2);
        //CoordinatorLayout分组
        Section sectionTemp3 = new Section("CoordinatorLayout");
        List<SampleItem> listTemp3 = new ArrayList<>();
        try {
            listTemp3.add(new SampleItem(Class.forName(mainPackage +
                    ".coordinatorlayout.CoordinatorLayoutSample1"), "官方示例"));
            listTemp3.add(new SampleItem(Class.forName(mainPackage +
                    ".coordinatorlayout.CoordinatorLayoutSample2"), "自定义Behavior"));
            listTemp3.add(new SampleItem(Class.forName(mainPackage +
                    ".coordinatorlayout.CoordinatorLayoutSample3"), "顶部底部bar隐藏"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        sectionTemp3.setItems(listTemp3);
        sections.add(sectionTemp3);
        return sections;
    }
}
