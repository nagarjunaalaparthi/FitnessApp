package com.fitnessapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.fitnessapp.ui.base.BaseActivity;
import com.fitnessapp.ui.trainers.TrainersFragment;

public class MainActivity extends BaseActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //setContentView(R.layout.activity_main);
    //setFragment(new SearchEventFragment());
   // setContentView(new TrainersFragment());

  }

  public void setFragment(Fragment fragment) {
    getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
  }
}
