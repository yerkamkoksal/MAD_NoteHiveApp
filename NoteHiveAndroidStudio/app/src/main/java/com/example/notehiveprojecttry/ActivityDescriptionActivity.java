package com.example.notehiveprojecttry;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class ActivityDescriptionActivity extends AppCompatActivity {

    TextView tvActivityDescription;
    TextView tvActivityDetails;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Log.d("ActivityDescription", "onCreate: setContentView done");

        tvActivityDescription = findViewById(R.id.tv_activity_description);
        tvActivityDetails = findViewById(R.id.tv_activity_details);
        imageView = findViewById(R.id.activity_image);

        Log.d("ActivityDescription", "onCreate: findViewById done");

        // Get the Event object passed from the previous activity
        Event selected = (Event)getIntent().getSerializableExtra("event");
        Log.d("ActivityDescription", "onCreate: getSerializableExtra done, event: " + selected);

        // Populate the description and details TextViews with the event information
        tvActivityDescription.setText(selected.getTitle());

        String startTime = "Start Time: " + formatTime(selected.getStartTime());
        String endTime = "\nEnd Time: " + formatTime(selected.getEndTime());
        String category = "\nCategory: " + selected.getCategory() + "\n";
        String note = "\nNote: " + selected.getNote();

        SpannableString startTimeSpannable = new SpannableString(startTime);
        SpannableString endTimeSpannable = new SpannableString(endTime);
        SpannableString categorySpannable = new SpannableString(category);
        SpannableString noteSpannable = new SpannableString(note);


        startTimeSpannable.setSpan(new StyleSpan(Typeface.BOLD), 0, "Start Time:".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        endTimeSpannable.setSpan(new StyleSpan(Typeface.BOLD), 0, "\nEnd Time:".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        categorySpannable.setSpan(new StyleSpan(Typeface.BOLD), 0, "\nCategory:".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        noteSpannable.setSpan(new StyleSpan(Typeface.BOLD), 0, "\nNote:".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        tvActivityDetails.setText(TextUtils.concat(startTimeSpannable, endTimeSpannable, categorySpannable,noteSpannable));
        Log.d("ActivityDescription", "onCreate: setText done");

        category = selected.getCategory();
        switch (category) {
            case "Education":
                imageView.setImageResource(R.drawable.education_image);
                break;
            case "Health":
                imageView.setImageResource(R.drawable.health_image);
                break;
            case "Meals":
                imageView.setImageResource(R.drawable.meals_image);
                break;
            case "Breaks":
                imageView.setImageResource(R.drawable.breaks_image);
                break;
            case "Leisure":
                imageView.setImageResource(R.drawable.leisure_image);
                break;
            default:
                break;
        }

        Button deleteButton = findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Event.deleteEvent(selected);
                Intent intent = new Intent(ActivityDescriptionActivity.this, ViewActivitiesActivity.class);
                startActivity(intent);
                finish();
            }
        });


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(selected.getTitle());
        } else {
            Log.d("ActivityDescription", "onCreate: Action bar is null");
        }

    }

    public String formatTime(int time) {
        int hours = time / 100;
        int minutes = time % 100;
        return String.format(Locale.getDefault(), "%02d:%02d", hours, minutes);
    }


}


