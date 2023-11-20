package com.sabanciuniv.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sabanciuniv.model.*;
public interface NoteRepo extends MongoRepository<Notes,Long>{
	
	
	public List<Notes> findAll();
	

}
