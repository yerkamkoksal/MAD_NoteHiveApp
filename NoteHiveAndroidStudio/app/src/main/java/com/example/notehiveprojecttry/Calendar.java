package com.example.notehiveprojecttry;
import java.util.Date;
import java.util.List;

public class Calendar {

    private long ID;
    private String title;
    private Date date;
    private List<Event> events;

    public Calendar(long iD, String title, List<Event> events, Date date) {
        super();
        ID = iD;
        this.title = title;
        this.events = events;
        this.date = date;
    }

    public Calendar(String title, List<Event> events, Date date) {
        super();
        this.title = title;
        this.events = events;
        this.date = date;
    }

    public Calendar() {
        super();
    }

    public long getID() {
        return ID;
    }

    public void setID(long iD) {
        ID = iD;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void insertEvent(Event event) {
        this.events.add(event);
    }
}

