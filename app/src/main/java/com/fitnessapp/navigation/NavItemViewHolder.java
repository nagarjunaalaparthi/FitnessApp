package com.fitnessapp.navigation;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.fitnessapp.R;

/**
 * Created by venkatanarayana on 1/6/18.
 */

public class NavItemViewHolder extends RecyclerView.ViewHolder {
    private TextView navItemTitle;


    public NavItemViewHolder(View v) {
        super(v);
        navItemTitle = v.findViewById(R.id.nav_item_title);
    }

    public void setContent(final String title, final int index) {
        navItemTitle.setText(title);
    }
}