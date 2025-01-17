package com.vinay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.model.Admin;
import com.vinay.server.AdminServiceImplementation;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:3001", allowCredentials = "true")
@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminServiceImplementation adminservice;
	
	
	
	@GetMapping("/getalladmins")
	public List<Admin> getalladmins()
	{
		return adminservice.getalladmins();
	}
	
	@PostMapping("/checkadmin")
	public ResponseEntity<?> checkAdmin(@RequestBody Admin admin, HttpSession session) {
	    String username = admin.getUsername();
	    String password = admin.getPassword();

	    Admin admin1 = adminservice.checkadmin(username, password);
	    
	    if (admin1 != null) {
	        session.setAttribute("Admin", admin1);
	        System.out.println("Session ID: " + session.getId());
	        return ResponseEntity.ok(true); // Send success response
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password.");
	    }
	}
	
	@PostMapping("/addadmin")
	public ResponseEntity<?> addadmin(@RequestBody Admin admin)
	{
		try {
			adminservice.addadmin(admin);
			return ResponseEntity.ok("admin added succesfully");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getLocalizedMessage());
		}
	}
	
	
	 @PostMapping("/logout")
	    public ResponseEntity<?> logout(HttpSession session) {
	        session.invalidate(); // Invalidate the session
	        System.out.println("loggedout for Admin"+session.getId());
	        return ResponseEntity.ok("Logout successful");
	    }
	
	 @DeleteMapping("/deleteadmin/{id}")
	 public ResponseEntity<?> deleteadmin(@PathVariable Integer id)
		{
		    System.out.println("Received ID: " + id); // Debugging log

			try {
				adminservice.deleteadmin(id);
				return ResponseEntity.ok("admin deleted succesfully");
			} catch (Exception e) {
				return ResponseEntity.badRequest().body(e.getLocalizedMessage());
			}
		}
}
