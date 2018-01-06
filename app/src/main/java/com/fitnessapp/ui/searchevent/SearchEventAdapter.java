package com.fitnessapp.ui.searchevent;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fitnessapp.R;
import com.fitnessapp.data.model.Event;
import java.util.List;

/**
 * Created by kiran on 1/6/18.
 */

public class SearchEventAdapter extends RecyclerView.Adapter<SearchEventViewHolder> {
  ISearchEventListClickListener mListener;
  List<Event> mValues;

  SearchEventAdapter(List<Event> items, ISearchEventListClickListener listener) {
    mValues = items;
    mListener = listener;
  }

  public void updateList(List<Event> items) {
    mValues = null;
    mValues = items;
    notifyDataSetChanged();
  }

  @Override public SearchEventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.lisitem_search_event, parent, false);
    return new SearchEventViewHolder(view, mListener);
  }

  @Override public void onBindViewHolder(final SearchEventViewHolder holder, final int position) {
    if (mValues == null) return;
    holder.updateUI(mValues.get(position));
  }

  public String getString(Context context, int resId, String value) {
    return String.format(context.getString(resId), value);
  }

  @Override public int getItemCount() {
    if (mValues == null) return 0;
    return mValues.size();
  }
}
