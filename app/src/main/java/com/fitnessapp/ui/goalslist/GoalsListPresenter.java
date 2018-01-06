package com.fitnessapp.ui.goalslist;

import android.support.annotation.NonNull;
import com.fitnessapp.data.IDataManager;
import com.fitnessapp.data.model.Goal;
import java.util.List;

/**
 * Created by kiran on 1/6/18.
 */

public class GoalsListPresenter implements IGoalsListPresenter {

  private final IDataManager mDataManager;
  private final IGoalsListView mGoalsView;

  public GoalsListPresenter(
      @NonNull IDataManager dataManager, @NonNull IGoalsListView goalsView) {
    mDataManager = dataManager;
    mGoalsView = goalsView;
  }


  @Override public void loadGoals(boolean force) {
      mGoalsView.setProgressBar(true);
    mDataManager.loadGoals(new IDataManager.LoadGoalsCallback() {
      @Override public void onGoalsLoaded(List<Goal> goalList) {
        mGoalsView.setProgressBar(false);
        mGoalsView.showGoals(goalList);
      }
    });
  }
}
