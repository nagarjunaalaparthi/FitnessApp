package com.fitnessapp.ui.trainers;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fitnessapp.R;
import com.fitnessapp.data.Injection;
import com.fitnessapp.data.model.Trainer;

import java.util.List;

public class TrainersFragment extends Fragment implements ITrainersListView {

    TrainersListPresenter presenter;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trainers, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new TrainersListPresenter(Injection.provideFitnessRepository(), this);
        presenter.loadTrainers(true);
    }

    @Override
    public void setProgressBar(boolean show) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showTrainers(List<Trainer> trainersList) {
        TrainersAdapter adapter = new TrainersAdapter(trainersList);
        recyclerView.setAdapter(adapter);
    }
}
