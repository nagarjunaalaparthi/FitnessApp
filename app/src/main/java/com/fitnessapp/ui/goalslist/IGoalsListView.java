package com.fitnessapp.ui.goalslist;

import com.fitnessapp.data.model.Goal;
import java.util.List;

/**
 * Created by kiran on 1/6/18.
 */

public interface IGoalsListView {
  void setProgressBar(boolean show);

  void showError();

  void showGoals(List<Goal> goalsList);
}
