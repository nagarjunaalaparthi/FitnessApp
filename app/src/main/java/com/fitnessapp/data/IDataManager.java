package com.fitnessapp.data;

import android.support.annotation.NonNull;
import com.fitnessapp.data.model.Event;
import com.fitnessapp.data.model.Goal;
import com.fitnessapp.data.model.Trainer;
import java.util.List;

/**
 * Created by kiran on 1/6/18.
 */

public interface IDataManager {

  interface LoadGoalsCallback {
    void onGoalsLoaded(List<Goal> goalList);
  }

  interface LoadGoalCallback {
    void onGoalLoaded(Goal goal);
  }

  interface LoadTrainersCallback {
    void onTrainersLoaded(List<Trainer> trainers);
  }

  interface LoadTrainerCallback {
    void onTrainerLoaded(Trainer trainer);
  }

  interface SearchEventsCallback {
    void onSearchEventResults(List<Event> eventList);

    void onError(String message);
  }

  interface AddTrainerCallBack {
    void onTrianerAdded();

    void onError(String message);
  }

  interface LoadEventsCallback {
    void onEventsLoaded(List<Event> events);
  }

  interface AddEventsCallBack {
    void onEventAdded();

    void onError(String message);
  }

  void loadGoals(@NonNull IDataManager.LoadGoalsCallback callback);

  void searchEventsByLocation(String address, @NonNull IDataManager.SearchEventsCallback callback);

  void loadGoal(@NonNull String goalId, @NonNull IDataManager.LoadGoalCallback callback);

  void loadTrainers(@NonNull IDataManager.LoadTrainersCallback callback);

  void loadTrainer(@NonNull String goalId, @NonNull IDataManager.LoadTrainerCallback callback);

  void addTrainer(@NonNull Trainer trainer, @NonNull IDataManager.AddTrainerCallBack callback);

  void loadEvents(@NonNull IDataManager.LoadEventsCallback callback);

  void addEvent(@NonNull Event event, @NonNull IDataManager.AddEventsCallBack callback);
}
