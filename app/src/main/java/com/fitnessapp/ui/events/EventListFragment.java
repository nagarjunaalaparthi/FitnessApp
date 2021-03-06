package com.fitnessapp.ui.events;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapp.R;
import com.fitnessapp.data.FirebaseDataManager;
import com.fitnessapp.data.IDataManager;
import com.fitnessapp.data.Injection;
import com.fitnessapp.data.model.Event;

import java.util.List;

/**
 * Created by admin on 1/6/2018.
 */

public class EventListFragment extends Fragment implements IEventListView{

    private RecyclerView mRecyclerView;
    private List<Event> mEventList;
    private EventListAdapter mAdapter;
    private EventListPresenter mPresenter;

    public static EventListFragment getInstance(){
        EventListFragment fragment = new EventListFragment();
        return fragment;
    }

    public EventListFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events,null);
        mPresenter = new EventListPresenter(Injection.provideFitnessRepository(), this);

        initView(view);
        return view;
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.eventListRecycler);
        LinearLayoutManager navListManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(navListManager);
        mAdapter =  new EventListAdapter(getContext());

        mPresenter.loadEvents(true);
    }


    private void addEvents(Event event){

        FirebaseDataManager.getInstance().addEvent(event, new IDataManager.AddEventsCallBack() {
            @Override
            public void onEventAdded() {

            }

            @Override
            public void onError(String message) {

            }

        });
    }

    @Override
    public void setProgressBar(boolean show) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showEvents(List<Event> eventList) {
        if(eventList != null && !eventList.isEmpty()){
            mAdapter.setEventList(eventList);
            mRecyclerView.setAdapter(mAdapter);
        }
    }
}
