package com.fitnessapp.ui.searchevent;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.fitnessapp.R;
import com.fitnessapp.data.model.Event;

/**
 * Created by kiran on 1/6/18.
 */

public class SearchEventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
  ISearchEventListClickListener mListener;
  TextView eventNameView;
  Event mItem;

  public SearchEventViewHolder(View itemView, ISearchEventListClickListener listener) {
    super(itemView);
    mListener = listener;
    itemView.setOnClickListener(this);
    eventNameView = itemView.findViewById(R.id.li_event_name);
  }

  void updateUI(Event event) {
    mItem = event;
    eventNameView.setText(event.getName());
  }

  @Override public void onClick(View view) {
    if (mListener != null) {
      mListener.onEventClicked(mItem);
    }
  }
}
