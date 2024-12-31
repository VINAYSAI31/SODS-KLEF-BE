package com.vinay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinay.model.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer>{

}
