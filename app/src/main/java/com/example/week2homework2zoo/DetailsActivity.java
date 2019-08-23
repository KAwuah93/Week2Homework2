package com.example.week2homework2zoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView tvAnimalName;
    ImageView AnimalImg;
    TextView categorytv;
    TextView tvDetail;

    //playbutton
    Button Mediaplay;
    int MediaTag;

    private MediaPlayer mp;

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
        Mediaplay = findViewById(R.id.mediaPlayer);

        //put the Items on the view
        tvAnimalName.setText(passedAnimal.getName());
        categorytv.setText(passedAnimal.getCategory());
        tvDetail.setText(passedAnimal.getDescription());

        //media items
        AnimalImg.setImageResource(passedAnimal.getprofilepic());

        //create the mediaplayer and bind on the onclick to the button
        MediaTag = passedAnimal.getCry();
        mp = MediaPlayer.create(this, MediaTag );




    }

    public void onClickMedia(View view) {
        mp.start();

    }
}
