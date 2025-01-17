package com.vinay.server;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vinay.model.Activities;

@Service
public interface ActivitiesService {

	public Activities addactivity(Activities act);
	public List<Activities> getactivities();
	public void deleteactivity(int id);
	public Activities getactivitybyid(int id);
	public ResponseEntity<?> updateactivity(int id,String title,String des,MultipartFile image);
	
}
