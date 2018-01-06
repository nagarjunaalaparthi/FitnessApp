package com.fitnessapp.data;

import android.support.annotation.NonNull;
import com.fitnessapp.data.model.Goal;
import java.util.List;

/**
 * Created by kiran on 1/6/18.
 */

public interface IDataManager {

  interface  LoadGoalsCallback {
    void onGoalsLoaded(List<Goal> goalList);
  }
  interface  LoadGoalCallback {
    void onGoalLoaded(Goal goal);
  }

  void loadGoals(@NonNull IDataManager.LoadGoalsCallback callback);

  void loadGoal(@NonNull String goalId, @NonNull IDataManager.LoadGoalCallback callback);

}
