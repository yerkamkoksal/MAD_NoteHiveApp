package com.sabanciuniv.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Notes {
	@Id
	private long ID;
	
	private String textNote;
	private String listNote;
	
	public Notes(long iD, String textNote, String listNote) {
		super();
		ID = iD;
		this.textNote = textNote;
		this.listNote = listNote;
	}
	public Notes() {
		super();
	}
	public Notes(String textNote, String listNote) {
		super();
		this.textNote = textNote;
		this.listNote = listNote;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getTextNote() {
		return textNote;
	}
	public void setTextNote(String textNote) {
		this.textNote = textNote;
	}
	public String getListNote() {
		return listNote;
	}
	public void setListNote(String listNote) {
		this.listNote = listNote;
	}
	
	
}
