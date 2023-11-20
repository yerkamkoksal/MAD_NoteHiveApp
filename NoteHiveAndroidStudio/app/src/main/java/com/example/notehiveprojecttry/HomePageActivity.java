package com.example.notehiveprojecttry;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class HomePageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        Button btnViewActivities = findViewById(R.id.viewActivityButton);
        Button btnaddActivity = findViewById(R.id.addActivityButton);

        btnViewActivities.setOnClickListener(v -> {
            Intent intent = new Intent(HomePageActivity.this, ViewActivitiesActivity.class);
            startActivity(intent);
        });

        btnaddActivity.setOnClickListener(v -> {
            Intent intent = new Intent(HomePageActivity.this, AddEventActivity.class);
            startActivity(intent);
        });
    }
}
