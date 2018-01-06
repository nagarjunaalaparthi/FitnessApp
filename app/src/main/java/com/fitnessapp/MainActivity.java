package com.fitnessapp;

import android.os.Bundle;

import com.fitnessapp.ui.base.BaseActivity;
import com.fitnessapp.ui.trainers.TrainersFragment;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new TrainersFragment());
    }

}
