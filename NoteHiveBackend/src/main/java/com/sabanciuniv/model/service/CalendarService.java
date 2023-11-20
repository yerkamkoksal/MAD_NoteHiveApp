package com.sabanciuniv.model.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.internal.diagnostics.logging.Logger;
import com.sabanciuniv.model.*;
import com.sabanciuniv.repo.*;

@Service
public class CalendarService {
	
	Logger logger;
	
	@Autowired
	private CalendarRepo calendarRepo;
	
	public void searchCalendar(String title) {
		Calendar calendar = calendarRepo.findByTitle(title);
		logger.info("The calendar "+calendar.getTitle()+ " you searched is on "+calendar.getDate()+ " .");
	}
	
	
	public void changeTitleOfCalendar(String oldTitle, String newTitle) {
		Calendar calendar = calendarRepo.findByTitle(oldTitle);
		calendar.setTitle(newTitle);
		logger.info("The event with old title "+ oldTitle + " is changed to "+calendar.getTitle()+ " successfully.");
	}
	
	public void deleteCalendar(String title) {
		Calendar calendar = calendarRepo.findByTitle(title);
		calendarRepo.delete(calendar);
	}
	
	public void createCalendar(String title,LocalDate date) {

		Calendar calendar = new Calendar();
		calendar.setTitle(title);
		calendar.setDate(date);
		calendar.setEvents(null);
	    calendarRepo.save(calendar);
	}
}
