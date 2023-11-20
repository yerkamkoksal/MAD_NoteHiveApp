package com.sabanciuniv.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document
public class Calendar {
	
	@Id
	private long ID;
	private String title;
	private LocalDate date;
	@DocumentReference private List<Event> events;
	
	public Calendar(long iD, String title, List<Event> events,LocalDate date) {
		super();
		ID = iD;
		this.title = title;
		this.events = events;
		this.date = date;
	}

	public Calendar(String title, List<Event> events, LocalDate date) {
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public void insertEvent(Event event) {
		this.events.add(event);
	}
	
	

}
