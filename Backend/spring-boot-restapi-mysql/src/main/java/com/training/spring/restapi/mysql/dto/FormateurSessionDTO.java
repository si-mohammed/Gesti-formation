package com.training.spring.restapi.mysql.dto;

import java.io.Serializable;
import java.util.Date;

public class FormateurSessionDTO  {
    private long id;
    private String sessionname;
    private String track;
    private Date date;
    private int duree;
    private String adress;
    private int participants;
    private boolean isCompleted;
    private long formateurid;
    private String formateurname;
    private String formateurlastname;


	public FormateurSessionDTO( 
     long _id,  String session_name,  String _track,  Date _date,
     int _duree,
     String _adress,
     int _participants,
     boolean _isCompleted,
     long formateur_id,
     String formateur_name,
     String formateur_lastname)
     {
        this.id=_id;
        this.sessionname = session_name;
        this.track = _track;
        this.date = _date;
        this.duree = _duree;
        this.adress = _adress;
        this.participants = _participants;
        this.isCompleted = _isCompleted;
        this.formateurid = formateur_id;
        this.formateurname = formateur_name;
        this.formateurlastname = formateur_lastname;
	}

	 //getters and setters

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return sessionname;
	}


	public void setName(String name) {
		this.sessionname = name;
	}


	public String getTrack() {
		return track;
	}


	public void setTrack(String track) {
		this.track = track;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public int getParticipants() {
		return participants;
	}


	public void setParticipants(int participants) {
		this.participants = participants;
	}


	public boolean isCompleted() {
		return isCompleted;
	}


	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}


	public long getFormateurid() {
		return formateurid;
	}


	public void setFormateurid(long formateurid) {
		this.formateurid = formateurid;
	}


	public String getFormateurname() {
		return formateurname;
	}


	public void setFormateurname(String formateurname) {
		this.formateurname = formateurname;
	}


	public String getFormateurlastname() {
		return formateurlastname;
	}


	public void setFormateurlastname(String formateurlastname) {
		this.formateurlastname = formateurlastname;
	}

       


        

}