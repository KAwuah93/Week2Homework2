package com.example.week2homework2zoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class AnimalRVActivity extends AppCompatActivity {
    RecyclerView rcView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_rvview);

        //create the layout Manager and assign it to the recycler view

        rcView = findViewById(R.id.rvAnimals);
        //commonly merged into 1 statement
        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(this);
        rcView.setLayoutManager(layoutManager);

        //Create the damn adapter
        ArrayList<Animal> animalListforRV = getAnimalList();
        AnimalRVAdapter animalAdapter = new AnimalRVAdapter(animalListforRV);

        rcView.setAdapter(animalAdapter);
    }

    private ArrayList<Animal> getAnimalList() {

        //pulling filtered Animal list from the Bundle
        Intent passedIntent = getIntent();
        ArrayList<Animal> curatedAnimals = passedIntent.getParcelableArrayListExtra("animal");

        return curatedAnimals;
    }

    //create method to return filtered List

}
