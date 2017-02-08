package com.designlibsamples;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Fishy on 2017/2/6.
 */

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.CustomHolder> {
    //原始数据，传入的参数
    List<Section> datas;
    Context context;
    //整理过后给adapter使用的数据
    List<Object> dataList;
    //子View的集合
    List<View> holdersView;
    final long ANIMATION_DURATION = 150;

    final int SECTION = 0;
    final int SAMPLE_ITEM = 1;

    SectionAdapter(Context context, List<Section> datas, final GridLayoutManager gridLayoutManager) {
        this.context = context;
        this.datas = datas;
        dataList = new ArrayList<>();
        clearUpData(datas);
        holdersView = new ArrayList<>();
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (getItemViewType(position) == SECTION) {
                    return gridLayoutManager.getSpanCount();
                } else {
                    return 1;
                }
            }
        });
    }

    /**
     * 整理数据，将原始map转为list集合
     *
     * @param origin
     */
    void clearUpData(List<Section> origin) {
        for (Section section : origin) {
            dataList.add(section);
            for (SampleItem item : section.getPublicIitems()) {
                dataList.add(item);
            }
        }
    }

    @Override
    public CustomHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case SECTION:
                View section = LayoutInflater.from(context).inflate(R.layout.layout_section, parent, false);
                CustomHolder holderS = new CustomHolder(section, viewType);
                return holderS;
            case SAMPLE_ITEM:
                View sampleItem = LayoutInflater.from(context).inflate(R.layout.layout_sample_item, parent, false);
                CustomHolder holderItem = new CustomHolder(sampleItem, viewType);
                return holderItem;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final CustomHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == SECTION) {
            final Section section = (Section) dataList.get(position);
            holder.tvSection.setText(section.getName());
            holder.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playExpandAnimation(section.isPublic(), holder.imgExpand);
                    section.setPublic(!section.isPublic());
                    refreshData();
                }
            });
        } else if (viewType == SAMPLE_ITEM) {
            final SampleItem item = (SampleItem) dataList.get(position);
            holder.tvSampleItem.setText(item.getContent());
            holder.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, item.getClassName());
                    context.startActivity(intent);
                }
            });
        }
    }

    /**
     * 播放某一组展开或收起的动画
     *
     * @param isExpand 是否展开
     */
    void playExpandAnimation(boolean isExpand, View view) {
        int start;
        int end;
        if (isExpand) {
            start = 0;
            end = -90;
        } else {
            start = -90;
            end = 0;
        }
        PropertyValuesHolder rotation = PropertyValuesHolder.ofFloat("rotation", start, end);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view, rotation);
        objectAnimator.setDuration(ANIMATION_DURATION);
        objectAnimator.start();
    }

    /**
     * 刷新数据
     */
    public void refreshData() {
        dataList.clear();
        clearUpData(datas);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        Object object = dataList.get(position);
        if (object instanceof Section) {
            return SECTION;
        } else if (object instanceof SampleItem) {
            return SAMPLE_ITEM;
        }
        return -1;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CustomHolder extends RecyclerView.ViewHolder {

        View root;
        TextView tvSection;
        ImageView imgExpand;
        TextView tvSampleItem;

        public CustomHolder(View itemView, int viewType) {
            super(itemView);
            initView(itemView, viewType);
        }

        void initView(View rootView, int viewType) {
            this.root = rootView;
            switch (viewType) {
                case SECTION:
                    tvSection = (TextView) rootView.findViewById(R.id.sectionName);
                    imgExpand = (ImageView) rootView.findViewById(R.id.imgExpand);
                    break;
                case SAMPLE_ITEM:
                    tvSampleItem = (TextView) rootView.findViewById(R.id.sampleItemName);
                    break;
            }
        }
    }
}
