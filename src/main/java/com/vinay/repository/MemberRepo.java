package com.vinay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vinay.model.Member;

@Repository
public interface MemberRepo  extends JpaRepository<Member, Integer>{

}
