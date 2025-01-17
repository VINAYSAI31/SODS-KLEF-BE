package com.vinay.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinay.model.Project;
import com.vinay.repository.ProjectRepo;

@Service
public class ProjectServiceImp implements ProjectService {

	@Autowired
	ProjectRepo projectrepo;
	
	@Override
	public Project addproject(Project project) {
		projectrepo.save(project);
		return project;
	}

	@Override
	public List<Project> getallprojects() {
		return projectrepo.findAll();
	}

	@Override
	public void deleteproject(int id) {
		
		 projectrepo.deleteById(id);
	}

}
