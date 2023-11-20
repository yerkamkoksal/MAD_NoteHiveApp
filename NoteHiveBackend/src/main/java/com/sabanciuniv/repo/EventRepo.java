package com.sabanciuniv.repo;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sabanciuniv.model.*;

public interface EventRepo extends MongoRepository<Event,Long>{
	
	public List<Event> findAll();
	
	@Query("{'startTime':'?0'}")
	public Event findByStartTime(LocalDateTime startTime);
	
	@Query("{'title':'?0'}")
	public Event findByTitle(String title);
	
	@Query("{'category':'?0'}")
	public List<Event> findByCategory(String category);
}
