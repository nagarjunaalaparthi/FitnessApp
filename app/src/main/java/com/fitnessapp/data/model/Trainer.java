package com.fitnessapp.data.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.Random;
import java.util.UUID;

@IgnoreExtraProperties
public class Trainer {

    public Trainer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id = UUID.randomUUID().toString();
    String name;
    String skill;
    String fee;
    double rating;
    double experience;

    public Trainer(String name, String skill, String fee, double rating, double experience) {
        this.name = name;
        this.skill = skill;
        this.fee = fee;
        this.rating = rating;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }
}
