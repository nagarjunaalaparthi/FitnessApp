package com.fitnessapp.ui.searchevent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.fitnessapp.R;
import com.fitnessapp.data.Injection;
import com.fitnessapp.data.model.Event;
import com.fitnessapp.ui.customui.CustomRecycleViewLayout;
import java.util.List;

/**
 * Created by kiran on 1/6/18.
 */

public class SearchEventFragment extends Fragment
    implements ISearchEventsView, ISearchEventListClickListener {
  ISearchEventsPresenter mPresenter;
  SearchEventAdapter mAdapter;
  CustomRecycleViewLayout mRecycleViewLayout;
  EditText mSearchView;
  TextView mClearView;

  public static SearchEventFragment newInstance() {
    return new SearchEventFragment();
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_search_events, container, false);

    return view;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mPresenter = new SearchEventPresenter(Injection.provideFitnessRepository(), this);

    initialize(view);
  }

  private void initialize(View view) {
    mRecycleViewLayout = view.findViewById(R.id.search_events_list);
    mSearchView = view.findViewById(R.id.text_search_view);
    mClearView = view.findViewById(R.id.label_cancel);
    mClearView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        mSearchView.setText(null);
        mAdapter.updateList(null);

      }
    });
    mSearchView.setOnEditorActionListener(new EditText.OnEditorActionListener() {
      @Override public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
        if ((actionId == EditorInfo.IME_ACTION_DONE) || ((event.getKeyCode()
            == KeyEvent.KEYCODE_ENTER) && (event.getAction() == KeyEvent.ACTION_DOWN))) {
          mPresenter.searchEvents(view.getText().toString());
          return true;
        } else {
          return false;
        }
      }
    });
    mAdapter = new SearchEventAdapter(null, this);
    mRecycleViewLayout.getRecycleView().setAdapter(mAdapter);
  }

  @Override public void setProgressBar(boolean show) {
    if (show) {
      mRecycleViewLayout.showProgressUI();
    } else {
      mRecycleViewLayout.showRecycleView();
    }
  }

  @Override public void onSearchFailure(String errorMessage) {
    mRecycleViewLayout.showEmptyUI(errorMessage);
  }

  @Override public void onSearchSuccessful(List<Event> eventList) {
    mAdapter.updateList(eventList);
  }

  @Override public void onEventClicked(Event event) {
    Toast.makeText(getContext(), event.getName() + " Clicked ", Toast.LENGTH_SHORT).show();
  }
}
