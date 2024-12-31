package com.vinay.server;

import org.springframework.stereotype.Service;

import com.vinay.model.Member;

@Service
public interface MemberService {

	public Member addmember(Member mem);
}
