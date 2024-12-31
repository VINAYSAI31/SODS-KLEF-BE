package com.vinay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.model.Activities;
import com.vinay.server.ActivitiesService;
import com.vinay.server.ActivitiesServiceImp;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/act")
public class ActivitiesController {
	
	@Autowired
	private ActivitiesServiceImp actservice;

	
	@PostMapping("/addactivity")
	public ResponseEntity<?> addactivities(@RequestBody Activities act)
	{
		try {
			Activities acti = actservice.addactivity(act);
			if(acti!=null)
			{
			return ResponseEntity.ok().body("Activity added succesfully");
			}
			else
			{
				return ResponseEntity.badRequest().body("Failed to add Activity");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			return ResponseEntity.badRequest().body(e.getLocalizedMessage());
		}
	}
	
	
	@GetMapping("/getactivities")
	public List<Activities> getactivities()
	{
		return actservice.getactivities();
	}
	
}
