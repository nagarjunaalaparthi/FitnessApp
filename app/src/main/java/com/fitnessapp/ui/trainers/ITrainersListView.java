package com.fitnessapp.ui.trainers;

import com.fitnessapp.data.model.Goal;
import com.fitnessapp.data.model.Trainer;

import java.util.List;

/**
 * Created by kiran on 1/6/18.
 */

public interface ITrainersListView {
  void setProgressBar(boolean show);

  void showError();

  void showTrainers(List<Trainer> trainersList);
}
