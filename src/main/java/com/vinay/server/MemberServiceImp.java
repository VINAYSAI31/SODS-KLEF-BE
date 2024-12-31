package com.vinay.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinay.model.Member;
import com.vinay.repository.MemberRepo;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberRepo memberrepo;
	
	@Override
	public Member addmember(Member mem) {
		memberrepo.save(mem);
		return mem;
	}

	
}
