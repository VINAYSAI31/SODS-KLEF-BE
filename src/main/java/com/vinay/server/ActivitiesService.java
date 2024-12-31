package com.vinay.server;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vinay.model.Activities;

@Service
public interface ActivitiesService {

	public Activities addactivity(Activities act);
	public List<Activities> getactivities();
	
}
