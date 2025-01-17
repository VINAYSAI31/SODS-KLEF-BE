package com.vinay.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Activities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String title;
	String Des;
	public Activities(int id, String title, String des, byte[] imagedata) {
		super();
		this.id = id;
		this.title = title;
		Des = des;
		this.imagedata = imagedata;
	}
	@Lob
	byte[] imagedata;
	public byte[] getImagedata() {
		return imagedata;
	}


	public void setImagedata(byte[] imagedata) {
		this.imagedata = imagedata;
	}


	public Activities() {
		
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDes() {
		return Des;
	}
	public void setDes(String des) {
		Des = des;
	}
	
}
