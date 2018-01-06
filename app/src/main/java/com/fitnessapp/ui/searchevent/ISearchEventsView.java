package com.fitnessapp.ui.searchevent;

import com.fitnessapp.data.model.Event;
import java.util.List;

/**
 * Created by kiran on 1/6/18.
 */

public interface ISearchEventsView {

  void setProgressBar(boolean show);

  void onSearchFailure(String errorMessage);

  void onSearchSuccessful(List<Event> eventList);
}
