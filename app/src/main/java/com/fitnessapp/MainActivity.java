package com.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.fitnessapp.data.FirebaseDataManager;
import com.fitnessapp.data.IDataManager;
import com.fitnessapp.data.model.Goal;
import com.fitnessapp.data.model.Trainer;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addTrainer();

        FirebaseDataManager.getInstance().loadTrainers(new IDataManager.LoadTrainersCallback() {
            @Override
            public void onTrainersLoaded(List<Trainer> trainers) {
                Toast.makeText(MainActivity.this, "No of trainer : " + trainers.size(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addTrainer() {
        Trainer trainer = new Trainer("Trainer 1", "Running", "500/hr", "Hyderabad", 4.5, 3);

        FirebaseDataManager.getInstance().addTrainer(trainer, new IDataManager.AddTrainerCallBack() {
            @Override
            public void onTrianerAdded() {

            }

            @Override
            public void onError(String message) {

            }

        });
    }
}
