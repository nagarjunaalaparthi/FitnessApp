package com.fitnessapp.data;

/**
 * Created by kiran on 1/6/18.
 */

public class FitnessRepositories {
  private FitnessRepositories() {
    // no instance
  }

  private static IDataManager repository = null;

  public synchronized static IDataManager getFireBaseDataManager() {
    if (null == repository) {
      repository = FirebaseDataManager.getInstance();
    }
    return repository;
  }
}
