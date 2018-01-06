package com.fitnessapp.ui.trainers;

import android.support.annotation.NonNull;

import com.fitnessapp.data.IDataManager;
import com.fitnessapp.data.model.Goal;
import com.fitnessapp.data.model.Trainer;

import java.util.List;

/**
 * Created by kiran on 1/6/18.
 */

public class TrainersListPresenter implements ITrainersListPresenter {

  private final IDataManager mDataManager;
  private final ITrainersListView mTrainersView;

  public TrainersListPresenter(
      @NonNull IDataManager dataManager, @NonNull ITrainersListView trainersListView) {
    mDataManager = dataManager;
    mTrainersView = trainersListView;
  }


  @Override public void loadTrainers(boolean force) {
      mTrainersView.setProgressBar(true);
    mDataManager.loadTrainers(new IDataManager.LoadTrainersCallback() {
      @Override
      public void onTrainersLoaded(List<Trainer> trainers) {
        mTrainersView.setProgressBar(false);
        mTrainersView.showTrainers(trainers);
      }
    });
  }
}
