package com.sabanciuniv.repo;

import com.sabanciuniv.model.Calendar;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface CalendarRepo extends MongoRepository<Calendar,Long>{
	
	public List<Calendar> findAll();
	
	@Query("{'title':'?0'}")
	public Calendar findByTitle(String title);
	
	@Query("{'date':'?0'}")
	public List<Calendar> findByDate(LocalTime date);
	
}
