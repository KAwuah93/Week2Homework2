package com.example.week2homework2zoo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class AnimalRVAdapter extends RecyclerView.Adapter<AnimalRVAdapter.ViewHolder>{
    private ArrayList<Animal> animalArrayList;

    public AnimalRVAdapter(ArrayList<Animal> animalArrayList) {
        this.animalArrayList = animalArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate a view into memory, pul context from the parent and attach it to the parent view
        //set attach to root to false
        View inflatedItem  = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.animal_ct_list_view, parent, false);
        //Return the view within the Viewholder
        return new ViewHolder(inflatedItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Animal currentAnimal = animalArrayList.get(position);
        //how you can do it by using a prewritten method
        holder.populateValues(currentAnimal);

    }

    @Override
    public int getItemCount() {
        return animalArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView titleText;
        Animal selectAnimal;

        public ViewHolder(View itemView){
            super(itemView);

            //Bind using the the ItemView instead of directly
            titleText = itemView.findViewById(R.id.titletxt);
            itemView.setOnClickListener(this);
        }
        public void setItemCar(Animal animal) {
            this.selectAnimal = animal;
        }

        public void populateValues(Animal animal){
            titleText.setText(animal.getName());
            setItemCar(animal);
        }

        @Override
        public void onClick(View view){
            Intent detailsIntent = new Intent(view.getContext(), DetailsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("animal", selectAnimal);
            detailsIntent.putExtras(bundle);

            view.getContext().startActivity(detailsIntent);

        }
    }
}
