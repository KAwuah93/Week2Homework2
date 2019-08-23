package com.example.week2homework2zoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {
        //Get past the entry screen into the other screen
        Intent gateKeeper = new Intent(view.getContext(), animalCategoryActivity.class);
        view.getContext().startActivity(gateKeeper);
    }
}
