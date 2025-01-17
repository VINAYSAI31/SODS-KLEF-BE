package com.vinay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vinay.model.Activities;
import com.vinay.model.Member;
import com.vinay.server.ActivitiesService;
import com.vinay.server.ActivitiesServiceImp;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/activity")
public class ActivitiesController {
	
	@Autowired
	private ActivitiesServiceImp actservice;

	
	@PostMapping("/addactivity")
	public ResponseEntity<?> addactivities(@RequestPart Activities act,@RequestPart MultipartFile image)
	{
		try {
			act.setImagedata(image.getBytes());
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
	
	@DeleteMapping("/deleteactivity/{id}")
	public ResponseEntity<?> deleteactivity(@PathVariable int id)
	{
		try {
			actservice.deleteactivity(id);
			return ResponseEntity.ok("activity deleted succesfully");
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getLocalizedMessage());
		}
	}
	
	@GetMapping("/getactivityimage/{id}")
	public ResponseEntity<byte[]> getactivityimage(@PathVariable int id)
	{
		Activities activity=actservice.getactivitybyid(id);
		
		byte[] imagedata = activity.getImagedata();
		return ResponseEntity.ok().body(imagedata);
		
	}
	
	
	@PutMapping("/update/{id}")
    public ResponseEntity<?> updateActivity(
        @PathVariable int id,
        @RequestParam(required = false) String title,
        @RequestParam(required = false) String des,
 
        @RequestParam(required = false) MultipartFile image) {

        return actservice.updateactivity(id, title, des, image);
    }
    
   
    
	
	
	
}
