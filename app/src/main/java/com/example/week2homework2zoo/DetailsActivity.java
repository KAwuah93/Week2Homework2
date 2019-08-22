package com.example.week2homework2zoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView tvAnimalName;
    ImageView AnimalImg;
    TextView categorytv;
    TextView tvDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent passedIntent = getIntent();
        Animal passedAnimal = passedIntent.getExtras().getParcelable("animal");

        //bind
        tvAnimalName = findViewById(R.id.detailTitletv);
        AnimalImg = findViewById(R.id.detailViewiv);
        categorytv = findViewById(R.id.categorytv);
        tvDetail = findViewById(R.id.animalDetail);

        //put the Items on the view
        tvAnimalName.setText(passedAnimal.getName());
        categorytv.setText(passedAnimal.getCategory());
        tvDetail.setText(passedAnimal.getDescription());


    }
}
