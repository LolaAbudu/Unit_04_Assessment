package org.pursuit.unit_04_assessment.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.unit_04_assessment.R;
import org.pursuit.unit_04_assessment.model.Animal;
import org.pursuit.unit_04_assessment.view.AnimalViewHolder;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {
    private List<Animal> animalList;

    public AnimalAdapter(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View childview = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_itemview, parent, false);
        return new AnimalViewHolder(childview);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder animalViewHolder, int position) {
        animalViewHolder.onBind(animalList.get(position));
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }
}
