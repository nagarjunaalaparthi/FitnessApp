package com.fitnessapp.ui.customui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.fitnessapp.R;

/**
 * Created by kiran on 1/6/18.
 */

public class CustomRecycleViewLayout extends FrameLayout {
  private RecyclerView mRecycleView;
  private FrameLayout mEmptyViewLayout;
  private FrameLayout mProgressLayout;
  private TextView mEmptyView;

  public CustomRecycleViewLayout(@NonNull Context context) {
    super(context);
    initialize();
  }

  public CustomRecycleViewLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    initialize();
  }

  public RecyclerView getRecycleView(){
     return mRecycleView;
  }


  private void initialize() {

    inflate(getContext(), R.layout.layout_custom_recycle_view, this);
    mRecycleView = (RecyclerView) this.findViewById(R.id.recycle_view);
    mRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));

    mEmptyViewLayout = (FrameLayout) this.findViewById(R.id.empty_container);
    mEmptyViewLayout.findViewById(R.id.empty_view);
    mProgressLayout = (FrameLayout) this.findViewById(R.id.progress_container);
  }

  public void showProgressUI() {
    mRecycleView.setVisibility(View.GONE);
    mProgressLayout.setVisibility(View.VISIBLE);
    mEmptyViewLayout.setVisibility(View.GONE);
  }

  public void showEmptyUI(String message) {
    mRecycleView.setVisibility(View.GONE);
    mProgressLayout.setVisibility(View.GONE);
    mEmptyViewLayout.setVisibility(View.VISIBLE);
    mEmptyView.setText(message);
  }

  public void showRecycleView() {
    mRecycleView.setVisibility(View.VISIBLE);
    mProgressLayout.setVisibility(View.GONE);
    mEmptyViewLayout.setVisibility(View.GONE);
  }
}
