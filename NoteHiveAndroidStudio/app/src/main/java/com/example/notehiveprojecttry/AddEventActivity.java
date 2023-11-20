package com.example.notehiveprojecttry;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;


import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AddEventActivity extends AppCompatActivity {

    private static final String URL_ENDPOINT = "http://10.0.2.2:8080/events";

    private TextView titleInput;
    private TextView startTimeInput;
    private TextView endTimeInput;
    private TextView categoryInput;
    private Button createButton;
    private TextView noteInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        titleInput = findViewById(R.id.titleInput);
        startTimeInput = findViewById(R.id.startTimeInput);
        endTimeInput = findViewById(R.id.endTimeInput);
        categoryInput = findViewById(R.id.categoryInput);
        createButton = findViewById(R.id.createButton);
        noteInput = findViewById(R.id.noteInput);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleInput.getText().toString();
                String startTimeStr = startTimeInput.getText().toString();
                String endTimeStr = endTimeInput.getText().toString();
                String category = categoryInput.getText().toString();
                String note = noteInput.getText().toString();

                if (title.isEmpty() || startTimeStr.isEmpty() || endTimeStr.isEmpty() || category.isEmpty()) {
                    Snackbar.make(v, "Please fill in all fields.", Snackbar.LENGTH_LONG).show();
                } else {
                    try {
                        int startTime = Integer.parseInt(startTimeStr);
                        int endTime = Integer.parseInt(endTimeStr);

                        Event event = new Event();
                        event.setTitle(title);
                        event.setStartTime(startTime);
                        event.setEndTime(endTime);
                        event.setCategory(category);
                        event.setNote(note);

                        createEvent(event);

                        Snackbar.make(v, "Event created successfully!", Snackbar.LENGTH_LONG).show();

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(AddEventActivity.this, ViewActivitiesActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }, 2000);

                    } catch (NumberFormatException e) {
                        Snackbar.make(v, "Start time and end time should be integers.", Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private String post(String urlEndpoint, String jsonData) throws IOException {
        URL url = new URL(urlEndpoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        OutputStream os = conn.getOutputStream();
        os.write(jsonData.getBytes("UTF-8"));
        os.close();

        int responseCode = conn.getResponseCode();
        return String.valueOf(responseCode);
    }

    void createEvent(final Event event) {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                String eventJson = event.toJson();
                try {
                    return post(URL_ENDPOINT + "/save", eventJson);
                } catch (IOException e) {
                    return e.toString();
                }
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                System.out.println(s);
            }
        }.execute();
    }
}