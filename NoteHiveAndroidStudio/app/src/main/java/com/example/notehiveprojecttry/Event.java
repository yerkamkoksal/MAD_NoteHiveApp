package com.example.notehiveprojecttry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class Event implements Serializable {

    private String title;
    private int startTime;
    private int endTime;
    private String category;
    private String note;
    private static List<Event> activities = new ArrayList<>();
    public static boolean isDeleted = false;

    public Event() {
        super();
    }

    public Event(String title, int startTime, int endTime, String category, String note) {
        super();
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.category = category;
        this.note = note;
    }

    public String toJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("title", this.title);
            json.put("startTime", this.startTime);
            json.put("endTime", this.endTime);
            json.put("category", this.category);
            json.put("note", this.note);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static List<Event> getActivities() {
        if (activities.isEmpty()) {
            // Sample activities data
            activities.add(new Event("School", 900, 1600, "Education", "Study Math, English and Science."));
            // ... other activities ...

            Collections.sort(activities, new Comparator<Event>() {
                @Override
                public int compare(Event o1, Event o2) {
                    return Integer.compare(o1.getStartTime(), o2.getStartTime());
                }
            });
        }

        return activities;
    }

    public static void addEvent(Event event) {
        getActivities().add(event);
    }

    public static void deleteEvent(Event event) {
        activities.remove(event);
        isDeleted = true;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
