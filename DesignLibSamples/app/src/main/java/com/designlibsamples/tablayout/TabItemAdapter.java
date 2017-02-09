package com.designlibsamples.tablayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.designlibsamples.R;
import com.designlibsamples.toolbar.MenuItem;
import com.designlibsamples.toolbar.MenuItemAdapter;

import java.util.List;

/**
 * Created by Fishy on 2017/2/9.
 */

public class TabItemAdapter extends RecyclerView.Adapter<TabItemAdapter.TabItemHolder> {
    List<MenuItem> menuItems;
    Context context;
    OnItemClickListener onItemClickListener;

    TabItemAdapter(Context context, List<MenuItem> menuItems) {
        this.context = context;
        this.menuItems = menuItems;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public TabItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_tab_item, parent, false);
        TabItemHolder holder = new TabItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final TabItemHolder holder, int position) {
        final MenuItem item = menuItems.get(position);
        holder.content.setText(item.getContent());
        holder.icon.setImageResource(item.getResourceId());
        holder.icon.setColorFilter(context.getResources().getColor(R.color.blue));
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onClicked(v, item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    class TabItemHolder extends RecyclerView.ViewHolder {
        View rootView;
        TextView content;
        ImageView icon;

        public TabItemHolder(View itemView) {
            super(itemView);
            initView(itemView);
        }

        void initView(View rootView) {
            this.rootView = rootView;
            content = (TextView) rootView.findViewById(R.id.tvTabItem);
            icon = (ImageView) rootView.findViewById(R.id.iconTabItem);
        }
    }

    interface OnItemClickListener {
        void onClicked(View view, MenuItem item);


    }
}
