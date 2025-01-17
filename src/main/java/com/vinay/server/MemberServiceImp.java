package com.vinay.server;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vinay.model.Member;
import com.vinay.repository.MemberRepo;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberRepo memberrepo;
	
	@Override
	public Member addmember(Member mem, MultipartFile image) throws IOException {
		mem.setImagedata(image.getBytes());
		memberrepo.save(mem);
		return mem;
	}

	@Override
	public List<Member> getallmembers() {
		// TODO Auto-generated method stub
		return memberrepo.findAll();
	}

	@Override
	public void deletemember(int id) {
		memberrepo.deleteById(id);
	}

	
	
        @Override
	    public ResponseEntity<?> updateMember(int id, String name, String role, String bio, String linkedin, 
	                                           String email, String github, String year, MultipartFile image) {
	        Optional<Member> optionalMember = memberrepo.findById(id);

	        if (optionalMember.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }

	        Member member = optionalMember.get();

	        if (name != null) member.setName(name);
	        if (role != null) member.setRole(role);
	        if (bio != null) member.setBio(bio);
	        if (linkedin != null) member.setLinkedin(linkedin);
	        if (email != null) member.setEmail(email);
	        if (github != null) member.setGithub(github);
	        if (year != null) member.setYear(year);

	        // Handle image upload (if any)
	        if (image != null && !image.isEmpty()) {
	            try {
	                // You can store the image locally or in a cloud storage, e.g., AWS S3
	                // Here we're storing the image locally for simplicity
	                member.setImagedata(image.getBytes());
	            } catch (IOException e) {
	                return ResponseEntity.status(500).body("Error uploading image");
	            }
	        }

	        memberrepo.save(member);

	        return ResponseEntity.ok(member);
	    
	}

		@Override
		public Member getmemberbyid(int id) {
			// TODO Auto-generated method stub
			return memberrepo.getById(id);
		}


	

	
}
