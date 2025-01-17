package com.vinay.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Lob
	byte[] imagedata;
	public Event() {
	}
	public Event(int id, byte[] imagedata) {
		super();
		this.id = id;
		this.imagedata = imagedata;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getImagedata() {
		return imagedata;
	}
	public void setImagedata(byte[] imagedata) {
		this.imagedata = imagedata;
	}
	

}
