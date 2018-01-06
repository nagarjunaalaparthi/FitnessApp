package com.fitnessapp.ui.trainers;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fitnessapp.R;
import com.fitnessapp.data.model.Trainer;

import java.util.ArrayList;
import java.util.List;

public class TrainersAdapter extends RecyclerView.Adapter<TrainersAdapter.ViewHolder> {

    private List<Trainer> trainers = new ArrayList<>();
    public TrainersAdapter(List<Trainer> trainer) {
        this.trainers = trainer;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_trainer, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Trainer trainer = trainers.get(position);
        holder.name.setText(trainer.getName());
        holder.skill.setText(trainer.getSkill());
        holder.location.setText(trainer.getLocation());
        holder.rating.setText(String.valueOf(trainer.getRating()));
    }

    @Override
    public int getItemCount() {
        return trainers == null ? 0 : trainers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name, skill, rating, location;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.trainer_name);
            skill = (TextView) itemView.findViewById(R.id.trainer_skill);
            location = (TextView) itemView.findViewById(R.id.trainer_location);
            rating = (TextView) itemView.findViewById(R.id.trainer_rating);
        }
    }
}
