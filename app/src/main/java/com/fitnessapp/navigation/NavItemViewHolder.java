package com.fitnessapp.navigation;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.fitnessapp.MainActivity;
import com.fitnessapp.R;
import com.fitnessapp.ui.events.EventListFragment;
import com.fitnessapp.ui.searchevent.SearchEventFragment;
import com.fitnessapp.ui.trainers.TrainersFragment;

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
    itemView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        switch (title) {
          case "Events":
            ((MainActivity) v.getContext()).setContentView(new EventListFragment());
            return;
          case "Trainers Nearby":
            ((MainActivity) v.getContext()).setContentView(new TrainersFragment());
            return;
          case "Search Events":
            ((MainActivity) v.getContext()).setContentView(new SearchEventFragment());
            return;

          default:
            ((MainActivity) v.getContext()).setContentView(new EventListFragment());
            return;
        }
      }
    });
  }
}