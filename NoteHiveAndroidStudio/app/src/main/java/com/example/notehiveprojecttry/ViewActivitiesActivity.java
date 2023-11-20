package com.example.notehiveprojecttry;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ViewActivitiesActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    ActivitiesAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activities);

        recyclerView = findViewById(R.id.recycler_view);

        List<Event> activities = Event.getActivities();
        adapter = new ActivitiesAdapter(this,activities, new ActivitiesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Event event) {
                // Start the ActivityDescriptionActivity and pass the clicked event to it.
                Intent intent = new Intent(ViewActivitiesActivity.this, ActivityDescriptionActivity.class);
                intent.putExtra("event", event);
                startActivity(intent);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();

        if (Event.isDeleted) {
            Snackbar.make(recyclerView, "Event successfully deleted.", Snackbar.LENGTH_SHORT).show();
            Event.isDeleted = false;
        }
    }


}
