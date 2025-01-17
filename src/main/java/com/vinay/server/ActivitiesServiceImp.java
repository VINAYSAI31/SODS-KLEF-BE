package com.vinay.server;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vinay.model.Activities;
import com.vinay.model.Member;
import com.vinay.repository.ActivitiesRepo;

@Service
public class ActivitiesServiceImp implements ActivitiesService {

	@Autowired
	ActivitiesRepo actrepo;
	
	@Override
	public Activities addactivity(Activities act) {
		actrepo.save(act);
		return act;
	}

	@Override
	public List<Activities> getactivities() {
		return actrepo.findAll();
	}

	@Override
	public void deleteactivity(int id) {
		actrepo.deleteById(id);
		
	}

	@Override
	public Activities getactivitybyid(int id) {
		// TODO Auto-generated method stub
		return actrepo.getById(id);
	}

	@Override
	public ResponseEntity<?> updateactivity(int id,String title, String des, MultipartFile image) {
		Optional<Activities> optionalActivity = actrepo.findById(id);

        if (optionalActivity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Activities activity = optionalActivity.get();  
        
        if (title != null) activity.setTitle(title);
        if (des != null) activity.setDes(des);
        
        if (image != null && !image.isEmpty()) {
            try {
                // You can store the image locally or in a cloud storage, e.g., AWS S3
                // Here we're storing the image locally for simplicity
            	activity.setImagedata(image.getBytes());
            } catch (IOException e) {
                return ResponseEntity.status(500).body("Error uploading image");
            }
        }
        actrepo.save(activity);
        
        return ResponseEntity.ok(activity);
	}

}
