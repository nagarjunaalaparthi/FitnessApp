package com.fitnessapp.data;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.fitnessapp.data.model.Event;
import com.fitnessapp.data.model.Trainer;
import com.google.android.gms.location.places.PlaceReport;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kiran on 1/6/18.
 */

public class FirebaseDataManager implements IDataManager {

  private static volatile IDataManager sDataManager;

  private static DatabaseReference mDatabaseReference;

  public static synchronized IDataManager getInstance() {

    if (sDataManager == null) {
      sDataManager = new FirebaseDataManager();
    }

    if (mDatabaseReference == null) {
      mDatabaseReference = FirebaseDatabase.getInstance().getReference();
    }
    return sDataManager;
  }

  @Override public void loadGoals(@NonNull LoadGoalsCallback callback) {

  }

  @Override public void loadGoal(@NonNull String goalId, @NonNull LoadGoalCallback callback) {

  }

    @Override
    public void loadTrainers(@NonNull final LoadTrainersCallback callback) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("trainers");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    List<Trainer> trainers = new ArrayList<Trainer>();
                    for (int i = 0; i < dataSnapshot.getChildrenCount(); i++) {
                        DataSnapshot snapshot = dataSnapshot.getChildren().iterator().next();
                        Trainer trainer = snapshot.getValue(Trainer.class);
                        trainers.add(trainer);
                    }

                    if (callback != null) {
                        callback.onTrainersLoaded(trainers);
                    }
                 }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


  @Override
  public void loadTrainer(@NonNull String goalId, @NonNull LoadTrainerCallback callback) {

  }

  @Override
  public void addTrainer(@NonNull Trainer trainer, @NonNull final AddTrainerCallBack callback) {
      mDatabaseReference.child("trainers").child(trainer.getId()).setValue(trainer, new DatabaseReference.CompletionListener() {
        @Override
        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

            if (callback != null) {
                if (databaseError != null){
                    callback.onError(databaseError.getMessage());
                } else {
                    callback.onTrianerAdded();
                }
            }
        }
      });
  }

    @Override
    public void loadEvents(final @NonNull LoadEventsCallback callback) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("events");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    List<Event> events = new ArrayList<>();
                    for (int i = 0; i < dataSnapshot.getChildrenCount(); i++) {
                        DataSnapshot snapshot = dataSnapshot.getChildren().iterator().next();
                        Event event = snapshot.getValue(Event.class);
                        events.add(event);
                    }

                    if (callback != null) {
                        callback.onEventsLoaded(events);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void addEvent(@NonNull Event event,final  @NonNull AddEventsCallBack callback) {
        mDatabaseReference.child("events").child(event.getId()).setValue(event, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                if (callback != null) {
                    if (databaseError != null){
                        callback.onError(databaseError.getMessage());
                    } else {
                        callback.onEventAdded();
                    }
                }
            }
        });
    }
}
