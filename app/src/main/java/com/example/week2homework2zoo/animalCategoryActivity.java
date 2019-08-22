package com.example.week2homework2zoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class animalCategoryActivity extends AppCompatActivity {
    ListView animalCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_category_list_view);

        animalCategory = findViewById(R.id.lvAnimalCategory);

        Intent passedIntent = getIntent();

        initListView();
    }
    private void initListView(){
        final ArrayList<Animal>dummyAnimalList = new ArrayList<>();
        dummyAnimalList.add(new Animal("Lion","Mammal", "Carnivore",
                "src: to", "Lion description", "wiki::source"));
        dummyAnimalList.add(new Animal("Bengal Tiger","Mammal", "Carnivore",
                "src: to", "Bengal Tiger description", "wiki::source"));
        dummyAnimalList.add(new Animal("Zebra","Mammal", "Herbivore",
                "src: to", "Zebra description", "wiki::source"));
        dummyAnimalList.add(new Animal("Elephants","Mammal", "Herbivore",
                "src: to", "Elephant description", "wiki::source"));
        dummyAnimalList.add(new Animal("Crab","crustaceans", "Carnivore",
                "src: to", "Crabs description", "wiki::source"));
        dummyAnimalList.add(new Animal("Lion","amphibians", "Carnivore",
                "src: to", "Lion description", "wiki::source"));
        dummyAnimalList.add(new Animal("Bald Eagle","Birds", "Carnivore",
                "src: to", "Bald Eagle description", "wiki::source"));
        dummyAnimalList.add(new Animal("Gecko","Lizard", "Carnivore",
                "src: to", "Geico", "wiki::source"));
        dummyAnimalList.add(new Animal("Bottlenose Dolphin","Mammal", "Omnivore",
                "src: to", "Bottlenose Dolphin description", "wiki::source"));
        dummyAnimalList.add(new Animal("Hawk","Birds", "Carnivore",
                "src: to", "Hawk description", "wiki::source"));
        dummyAnimalList.add(new Animal("Grey Wolf","Mammal", "Carnivore",
                "src: to", "Wolf description", "wiki::source"));

        Set <String> categories = new HashSet();

        for (Animal a : dummyAnimalList) {
            categories.add(a.getCategory());
        }
        Log.d("SET", "initListView: " + categories.toString());

        // this (context), style, and list
        //iterate through and add to a list
        final ArrayList<String> arrCate = new ArrayList<String>(categories.size());

        for(String x : categories)
            arrCate.add(x);

        ArrayAdapter<Animal> arrayAdapter = new ArrayAdapter<Animal>(this, R.layout.animal_ct_list_view,dummyAnimalList);
        ArrayAdapter<String> arrAdapter = new ArrayAdapter<String>(this, R.layout.animal_ct_list_view, arrCate);

        animalCategory.setAdapter(arrAdapter);

        animalCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(animalCategoryActivity.this,"lol",Toast.LENGTH_SHORT).show();
                Intent transfer = new Intent(view.getContext(), AnimalRVActivity.class);

                //sort through the freaking thingo and attach it to the bundle and send it off
                ArrayList<Animal> passedAnimals = new ArrayList<>();
                for(Animal x : dummyAnimalList){
                    if(x.getCategory() == arrCate.get(position).toString()){
                        passedAnimals.add(x);
                    }
                }
                //Attach to Bundle
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("animal", passedAnimals);
                transfer.putExtras(bundle);
                startActivity(transfer);

            }
        });

        //animalCategory.get
    }
    //Animal(String name, String category, String diettype, String avatar, String description, String wiki)
}
