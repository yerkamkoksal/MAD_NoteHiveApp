package com.sabanciuniv.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalTime;

import org.springframework.data.annotation.*;


@Document
public class Event {
	
	@Id
	private long ID;
	private String title;
	private LocalTime startTime;
	private LocalTime endTime;
	private String category;
	@DocumentReference private Notes note;
	
	

	public Event() {
		super();
	}

	public Event(String title, LocalTime startTime, LocalTime endTime, String category, Notes note) {
		super();
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.category = category;
		this.note = note;
	}
	public Event(String title, LocalTime startTime, LocalTime endTime, String category) {
		super();
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.category = category;
	}

	public Event(long iD, String title, LocalTime startTime, LocalTime endTime, String category, Notes note) {
		super();
		ID = iD;
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.category = category;
		this.note = note;
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

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Notes getNote() {
		return note;
	}

	public void setNote(Notes note) {
		this.note = note;
	}
	
	
	
}
