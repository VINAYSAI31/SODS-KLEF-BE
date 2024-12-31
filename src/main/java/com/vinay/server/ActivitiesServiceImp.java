package com.vinay.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinay.model.Activities;
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

}
