package com.vinay.server;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vinay.model.Member;

@Service
public interface MemberService {

	public Member addmember(Member mem,MultipartFile image) throws IOException;
	public List<Member> getallmembers();
	public void deletemember(int id);
	public ResponseEntity<?> updateMember(int id, String name, String role, String bio, String linkedin, 
            String email, String github, String year, MultipartFile image);
	public Member getmemberbyid(int id);
}
