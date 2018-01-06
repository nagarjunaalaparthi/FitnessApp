package com.fitnessapp.ui.events;

import com.fitnessapp.data.model.Event;
import com.fitnessapp.data.model.Goal;

import java.util.List;

/**
 * Created by kiran on 1/6/18.
 */

public interface IEventListView {
  void setProgressBar(boolean show);

  void showError();

  void showEvents(List<Event> eventList);
}
