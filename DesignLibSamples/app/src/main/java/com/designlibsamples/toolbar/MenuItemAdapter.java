package com.designlibsamples.toolbar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.designlibsamples.R;

import java.util.List;

/**
 * Created by Fishy on 2017/2/8.
 */

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemAdapter.MenuItemHolder> {
    List<MenuItem> menuItems;
    Context context;

    MenuItemAdapter(Context context, List<MenuItem> menuItems) {
        this.context = context;
        this.menuItems = menuItems;
    }

    @Override
    public MenuItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_menu_item, parent, false);
        MenuItemHolder holder = new MenuItemHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MenuItemHolder holder, int position) {
        final MenuItem item = menuItems.get(position);
        holder.content.setText(item.getContent());
        holder.icon.setImageResource(item.getResourceId());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, item.getContent(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    class MenuItemHolder extends RecyclerView.ViewHolder {
        View rootView;
        TextView content;
        ImageView icon;

        public MenuItemHolder(View itemView) {
            super(itemView);
            initView(itemView);
        }

        void initView(View rootView) {
            this.rootView = rootView;
            content= (TextView) rootView.findViewById(R.id.content);
            icon= (ImageView) rootView.findViewById(R.id.icon);
        }
    }
}
