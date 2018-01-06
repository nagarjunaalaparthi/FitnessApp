package com.fitnessapp.data.model;

import com.google.firebase.database.IgnoreExtraProperties;
import java.util.UUID;

/**
 * Created by admin on 1/6/2018.
 */

@IgnoreExtraProperties
public class Event {
  String id = UUID.randomUUID().toString();
  private String name;
  private String date;
  private String duration;
  private String category;
  private String description;
  private String location;

  public Event(){

  }

  public Event(String name, String date, String duration, String category, String description,
      String location){
    this.name = name;
    this.date = date;
    this.duration = duration;
    this.category = category;
    this.description = description;
    this.location = location;
  }
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}