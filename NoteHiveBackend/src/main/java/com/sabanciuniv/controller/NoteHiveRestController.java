package com.sabanciuniv.controller;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabanciuniv.model.*;
import com.sabanciuniv.repo.*;

import jakarta.annotation.PostConstruct;


@RestController
@RequestMapping("/notehive")
public class NoteHiveRestController {
	
	@Autowired private EventRepo eventRepository;
	@Autowired private CalendarRepo calendarRepository;
	private static final Logger logger = LoggerFactory.getLogger(NoteHiveRestController.class);
	
	@PostConstruct
	public void init () {
		if (calendarRepository.count()==0) {
			logger.info("Calendar is empty, initializing...");
			
			LocalTime startTime1 = LocalTime.of(10, 30);
			LocalTime startTime2 = LocalTime.of(14, 45);
			LocalTime startTime3 = LocalTime.of(20, 0);
			LocalTime endTime1 = LocalTime.of(12, 0);
			LocalTime endTime2 = LocalTime.of(16, 30);
			LocalTime endTime3 = LocalTime.of(21, 0);
			
			LocalTime startTime4 = LocalTime.of(9, 30);
			LocalTime startTime5 = LocalTime.of(17, 45);
			LocalTime startTime6 = LocalTime.of(21, 0);
			LocalTime endTime4 = LocalTime.of(12, 30);
			LocalTime endTime5 = LocalTime.of(19, 30);
			LocalTime endTime6 = LocalTime.of(23, 0);
			
			Event event1 = new Event("Go to School",startTime1,endTime1,"Education");
			Event event2 = new Event("Eat Some Lunch",startTime2,endTime2,"Nutrition");
			Event event3 = new Event("Watch a Movie",startTime3,endTime3,"Entertainment");
			
			Event event4 = new Event("Have a Breakfast",startTime4,endTime4,"Nutrition");
			Event event5 = new Event("Attend the Meeting",startTime5,endTime5,"Professional");
			Event event6 = new Event("Go to a Night Club",startTime6,endTime6,"Entertainment");
			
			event1.setID(1);
			event2.setID(2);
			event3.setID(3);
			event4.setID(4);
			event5.setID(5);
			event6.setID(6);


			
			eventRepository.save(event1);
			eventRepository.save(event2);
			eventRepository.save(event3);
			eventRepository.save(event4);
			eventRepository.save(event5);
			eventRepository.save(event6);

			LocalDate date1 = LocalDate.of(2023, 05, 10);
			List<Event> events = new ArrayList<Event>();
			Calendar calendar1 = new Calendar("Wednesday",events,date1);
			calendar1.setID(11);
			
			events.add(event1);
			events.add(event2);
			events.add(event3);
			
			LocalDate date2 = LocalDate.of(2023, 05, 11);
			List<Event> events2 = new ArrayList<Event>();
			Calendar calendar2 = new Calendar("Thursday",events,date2);
			calendar2.setID(12);

			events2.add(event4);
			events2.add(event5);
			events2.add(event6);

			calendarRepository.save(calendar1);
			calendarRepository.save(calendar2);
			logger.info("");
			logger.info("===============================================");


			


			logger.info("All events are successfullyy added to calendar "+ calendar1.getTitle());
			logger.info("");
			logger.info("===============================================");
			
			logger.info("Information of events list for "+calendar1.getTitle());
			events.forEach(e->logger.info(e.getID()+" "+e.getTitle()+" "+e.getStartTime()+" "+e.getEndTime()+" "+e.getCategory()));

			logger.info("");
			logger.info("===============================================");			logger.info("Information of events list for "+calendar2.getTitle());
			events2.forEach(e->logger.info(e.getID()+" "+e.getTitle()+" "+e.getStartTime()+" "+e.getEndTime()+" "+e.getCategory()));
			logger.info("");
			logger.info("===============================================");

			logger.info("Calendars are successfully Created!!!");



		}
		
	}
	@GetMapping("/events")
	public List<Event> events(){
		
		return eventRepository.findAll();
	}
	
	@PostMapping("/events/save")
	public Event saveEvent(@RequestBody Event event2) {
		
		Event event = eventRepository.save(event2);
		logger.info(event2.getTitle()+" is added");
		return event;
	}
	
	@PostMapping("/events/search")
	public Event searchEvent(@RequestBody Event event2){
		
		Event event= eventRepository.findByTitle(event2.getTitle());
		logger.info(event2.getTitle()+" you searched is found");
		return event;
	}
	
	
	@PostMapping("/calendars/save")
	public Calendar saveCalendar(@RequestBody Calendar calendar) {
		
		Calendar calendarSaved = calendarRepository.save(calendar);
		return calendarSaved;
	}
	
	@GetMapping("/calendars")
	public List<Calendar> calendars(){
		return calendarRepository.findAll();
	}
	
	@PostMapping("/calendars/search")
	public Calendar searchCalendar(@RequestBody Calendar calendar2){
		
		Calendar calendar= calendarRepository.findByTitle(calendar2.getTitle());
		logger.info(calendar2.getTitle()+ " is found.");
		return calendar;
	}
	
	


	
}
