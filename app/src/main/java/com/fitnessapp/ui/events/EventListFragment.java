package com.fitnessapp.ui.events;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fitnessapp.MainActivity;
import com.fitnessapp.R;
import com.fitnessapp.data.FirebaseDataManager;
import com.fitnessapp.data.IDataManager;
import com.fitnessapp.data.model.Event;
import com.fitnessapp.data.model.Trainer;

import java.util.List;

/**
 * Created by admin on 1/6/2018.
 */

public class EventListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<Event> mEventList;
    public static EventListFragment getInstance(){
        EventListFragment fragment = new EventListFragment();
        return fragment;
    }

    public EventListFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events,container);

        addEvents();
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRecyclerView = ()
    }


    private void addEvents(){
        Event event = new Event("Running Event", "05/01/2018", "1 week", "Running", "Rum=nning Event"
                , "Madhapur");

        FirebaseDataManager.getInstance().addEvent(event, new IDataManager.AddEventsCallBack() {
            @Override
            public void onEventAdded() {

            }

            @Override
            public void onError(String message) {

            }

        });
    }
/*    addTrainer();

        FirebaseDataManager.getInstance().loadTrainers(new IDataManager.LoadTrainersCallback() {
        @Override
        public void onTrainersLoaded(List< Trainer > trainers) {
            Toast.makeText(MainActivity.this, "No of trainer : " + trainers.size(), Toast.LENGTH_SHORT).show();
        }
    });


    private void addTrainer() {
        Trainer trainer = new Trainer("Trainer 1", "Running", "500/hr", "Hyderabad", 4.5, 3);

        FirebaseDataManager.getInstance().addTrainer(trainer, new IDataManager.AddTrainerCallBack() {
            @Override
            public void onTrianerAdded() {

            }

            @Override
            public void onError(String message) {

            }

        });
    }*/
}
