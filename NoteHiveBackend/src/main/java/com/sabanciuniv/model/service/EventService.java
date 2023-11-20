package com.sabanciuniv.model.service;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.internal.diagnostics.logging.Logger;
import com.sabanciuniv.model.*;
import com.sabanciuniv.repo.*;

@Service
public class EventService {
	Logger logger;
	
	@Autowired
	private EventRepo eventRepo;
	
	public void searchEvent(String title) {
		Event event = eventRepo.findByTitle(title);
		logger.info("The event"+event.getTitle()+ " you searched for is between "+event.getStartTime()+ " and "+event.getEndTime()+".");
	}
	
	public void moveEvent(String title, LocalTime newStartTime,LocalTime newEndTime) {
		Event event = eventRepo.findByTitle(title);
		event.setStartTime(newStartTime);
		event.setEndTime(newEndTime);
		logger.info("The event with title "+event.getTitle() +" is between "+event.getStartTime()+ " - "+event.getEndTime()+ " successfully.");

	}
	
	public void changeTitleOfEvent(String oldTitle, String newTitle) {
		Event event = eventRepo.findByTitle(oldTitle);
		event.setTitle(newTitle);
		logger.info("The event with old title "+oldTitle + " is changed to "+event.getTitle()+ " successfully.");
	}
	
	public void deleteEvent(String title) {
		Event event = eventRepo.findByTitle(title);
		eventRepo.delete(event);
	}
	
	public void createEvent(String title, LocalTime startTime, LocalTime endTime, String category, String note) {

		Event event = new Event();
	    event.setTitle(title);
	    event.setStartTime(startTime);
	    event.setEndTime(endTime);
	    event.setCategory(category);
	    event.getNote().setTextNote(note);
	    eventRepo.save(event);
	}


}
