package com.fitnessapp.ui.searchevent;

import android.support.annotation.NonNull;
import com.fitnessapp.data.IDataManager;
import com.fitnessapp.data.model.Event;
import java.util.List;

/**
 * Created by kiran on 1/6/18.
 */

public class SearchEventPresenter implements ISearchEventsPresenter {

  private IDataManager mDataManager;
  private ISearchEventsView mView;

  public SearchEventPresenter(@NonNull IDataManager dataManager, @NonNull ISearchEventsView view) {
    mDataManager = dataManager;
    mView = view;
  }

  @Override public void searchEvents(String address) {
    mView.setProgressBar(true);
    mDataManager.searchEventsByLocation(address, new IDataManager.SearchEventsCallback() {
      @Override public void onSearchEventResults(List<Event> eventList) {
        mView.setProgressBar(false);
        mView.onSearchSuccessful(eventList);
      }

      @Override public void onError(String message) {
        mView.setProgressBar(false);
        mView.onSearchFailure(message);
      }
    });
  }

  @Override public void cleanup() {
    mDataManager = null;
    mView = null;
  }
}
