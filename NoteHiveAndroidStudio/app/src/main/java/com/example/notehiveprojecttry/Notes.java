package com.example.notehiveprojecttry;
public class Notes {

    private long ID;
    private String textNote;
    private String listNote;

    public Notes(long ID, String textNote, String listNote) {
        super();
        this.ID = ID;
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

    public void setID(long ID) {
        this.ID = ID;
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
