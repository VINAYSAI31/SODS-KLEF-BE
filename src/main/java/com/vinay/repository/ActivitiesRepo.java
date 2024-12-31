package com.vinay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinay.model.Activities;

@Repository
public interface ActivitiesRepo extends JpaRepository<Activities, Integer> {

}
