package com.fitnessapp.data;

import android.support.annotation.NonNull;

/**
 * Created by kiran on 1/6/18.
 */

public class FirebaseDataManager implements IDataManager {

  private static volatile IDataManager sDataManager;

  public static synchronized IDataManager getInstance() {

    if (sDataManager == null) {
      sDataManager = new FirebaseDataManager();
    }
    return sDataManager;
  }

  @Override public void loadGoals(@NonNull LoadGoalsCallback callback) {

  }

  @Override public void loadGoal(@NonNull String goalId, @NonNull LoadGoalCallback callback) {

  }
}
