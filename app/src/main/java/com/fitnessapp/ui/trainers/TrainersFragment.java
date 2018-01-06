package com.fitnessapp.ui.trainers;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.fitnessapp.R;
import com.fitnessapp.data.Injection;
import com.fitnessapp.data.model.Trainer;

import java.util.ArrayList;
import java.util.List;

public class TrainersFragment extends Fragment implements ITrainersListView {

    TrainersListPresenter presenter;
    private RecyclerView recyclerView;
    private EditText searchText;
    private List<Trainer> trainers = new ArrayList<>();
    private TrainersAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trainers, null);
        searchText = (EditText) view.findViewById(R.id.search_editText);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        searchText.addTextChangedListener(searchTextWatcher);
        return view;
    }

    private TextWatcher searchTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() > 2) {

            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

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

    private void searchTrainers(String locationText) {
        List<Trainer> searchedTrainers = new ArrayList<>();
        if (trainers.size() > 0) {
            for (int i = 0; i < trainers.size(); i++) {
                if (trainers.get(i).getLocation().contains(locationText)) {
                    searchedTrainers.add(trainers.get(i));
                }
            }

            if (adapter == null) {
                adapter = new TrainersAdapter(searchedTrainers);
                recyclerView.setAdapter(adapter);
            } else {
                adapter.setTrainers(searchedTrainers);
            }
        }
    }

    @Override
    public void showTrainers(List<Trainer> trainersList) {
        trainers = trainersList;
        adapter = new TrainersAdapter(trainersList);
        recyclerView.setAdapter(adapter);
    }
}
