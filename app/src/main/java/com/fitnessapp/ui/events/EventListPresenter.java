package com.fitnessapp.ui.events;

import android.support.annotation.NonNull;

import com.fitnessapp.data.FirebaseDataManager;
import com.fitnessapp.data.IDataManager;
import com.fitnessapp.data.model.Event;

import java.util.List;

/**
 * Created by admin on 1/6/2018.
 */

public class EventListPresenter implements IEventListPresenter {

    private final IDataManager mDataManager;
    private final IEventListView mEventListView;

    public EventListPresenter(@NonNull IDataManager dataManager, @NonNull IEventListView eventListView) {
        mDataManager = dataManager;
        mEventListView = eventListView;
    }

    @Override
    public void loadEvents(boolean force) {
        FirebaseDataManager.getInstance().loadEvents(new IDataManager.LoadEventsCallback() {
            @Override
            public void onEventsLoaded(List<Event> events) {
                mEventListView.showEvents(events);
            }
        });
    }
}
