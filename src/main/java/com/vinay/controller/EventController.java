package com.vinay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vinay.model.Event;
import com.vinay.model.Member;
import com.vinay.server.EventService;
import com.vinay.server.EventServiceImplementation;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/event")
public class EventController {
	
	@Autowired
	EventServiceImplementation eventservice;
	
	
	 @PostMapping("/addeventphoto")
	    public ResponseEntity<?> addevent(@RequestBody MultipartFile image) {
	        try {
	            Event event = eventservice.addeventphoto(image);
	            if (event != null) {
	                return ResponseEntity.ok().body("Photo added successfully");
	            } else {
	                return ResponseEntity.badRequest().body("Failed to add Photo");
	            }
	        } catch (Exception e) {
	            System.err.println(e.getMessage());
	            return ResponseEntity.badRequest().body(e.getLocalizedMessage());
	        }
	    }

}
