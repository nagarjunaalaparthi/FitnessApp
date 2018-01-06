package com.fitnessapp.data;

/**
 * Created by kiran on 1/6/18.
 */

public class Injection {

  public static IDataManager provideFitnessRepository() {
    return FitnessRepositories.getFireBaseDataManager();
  }
}
