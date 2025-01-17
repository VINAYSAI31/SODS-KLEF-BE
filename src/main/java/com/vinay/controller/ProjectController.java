package com.vinay.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.model.Project;
import com.vinay.server.ProjectServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectServiceImp projectservice;
	
	
	@PostMapping("/addproject")
	public ResponseEntity<?> addproject(@RequestBody Project pro) {
		try {
			Project project = projectservice.addproject(pro);
			if(project!=null)
			{
				return ResponseEntity.ok().body("Project added succesfully");
			}
			else
			{
				return ResponseEntity.badRequest().body("Failed to add Project");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getLocalizedMessage());
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		
	}
	
	@GetMapping("/getallprojects")
	public List<Project> getallprojects()
	{
		return projectservice.getallprojects();
	}
	
	
	
	@DeleteMapping("/deleteproject/{id}")
	public ResponseEntity<?> deleteproject(@PathVariable int id)
	{
		try {
			projectservice.deleteproject(id);
			return ResponseEntity.ok().body("Project Deleted Succesfully");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getLocalizedMessage());
		}
		
	}
	
	

	
}
