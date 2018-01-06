package com.fitnessapp.ui.goalslist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.fitnessapp.data.Injection;
import com.fitnessapp.data.model.Goal;
import java.util.List;

/**
 * Created by kiran on 1/6/18.
 */

public class GoalsListActivity  extends AppCompatActivity implements IGoalsListView {
  GoalsListPresenter mPresenter;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mPresenter = new GoalsListPresenter(Injection.provideFitnessRepository(), this);
    mPresenter.loadGoals(true);

  }

  @Override public void setProgressBar(boolean show) {

  }

  @Override public void showError() {

  }

  @Override public void showGoals(List<Goal> goalsList) {
    //TODO: SHow goals in list

  }
}
