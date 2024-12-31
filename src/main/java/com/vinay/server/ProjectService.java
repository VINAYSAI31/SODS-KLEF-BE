package com.vinay.server;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vinay.model.Project;

@Service
public interface ProjectService {

	public Project addproject(Project project);
	public List<Project> getallprojects();
}
