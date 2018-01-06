package com.fitnessapp.ui.events;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fitnessapp.R;
import com.fitnessapp.data.model.Event;

import java.util.List;

/**
 * Created by admin on 1/6/2018.
 */

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder> {

    private List<Event> mEventList;
    private Context mContext;

    public EventListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_event, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public void setEventList(List<Event> eventList){
        mEventList = eventList;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Event event = mEventList.get(position);

        holder.txtEventName.setText(event.getName());
        holder.txtEventDate.setText(event.getDate());
        holder.txtEventDesc.setText(event.getDescription());
        holder.txtEventLocation.setText(event.getLocation());

    }

    @Override
    public int getItemCount() {
        return mEventList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtEventName, txtEventDate, txtEventDesc, txtEventLocation;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtEventName = (TextView) v.findViewById(R.id.txtEventName);
            txtEventDate = (TextView) v.findViewById(R.id.txtEventDate);
            txtEventDesc = (TextView) v.findViewById(R.id.txtEventDescr);
            txtEventLocation = (TextView) v.findViewById(R.id.txtEventLocation);
        }
    }
}
