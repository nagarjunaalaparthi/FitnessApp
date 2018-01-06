package com.fitnessapp.navigation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapp.R;

import java.util.ArrayList;

/**
 * Created by venkatanarayana on 1/6/18.
 */

/**
 * Adapter to show the navigation items in a recycler view
 */
public class NavListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<String> navItems;

    public NavListAdapter(Context context, ArrayList<String> navItems) {
        this.context = context;
        this.navItems = navItems;
    }

    public String getNavItm(int position) {
        return navItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return navItems.size();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View headerView;
        headerView = LayoutInflater.from(context).inflate(R.layout.nav_item, parent, false);
        return new NavItemViewHolder(headerView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((NavItemViewHolder) holder).setContent(getNavItm(position), position);
    }


}