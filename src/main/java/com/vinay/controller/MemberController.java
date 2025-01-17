package com.vinay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vinay.model.Member;
import com.vinay.server.MemberServiceImp;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    MemberServiceImp memberservice;

    @PostMapping("/addmember")
    public ResponseEntity<?> addmember(@RequestPart Member mem, @RequestPart MultipartFile image) {
        try {
            Member member = memberservice.addmember(mem,image);
            if (member != null) {
                return ResponseEntity.ok().body("Member added successfully");
            } else {
                return ResponseEntity.badRequest().body("Failed to add member");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.badRequest().body(e.getLocalizedMessage());
        }
    }
    
    @GetMapping("/getallmembers")
    public List<Member> getallmembers()
    {		 return memberservice.getallmembers();		 
    }
    
    
    @DeleteMapping("/deletemember/{id}")
    public ResponseEntity<?> deletemember(@PathVariable Integer id)
    {
    	try {
    		memberservice.deletemember(id);
    		return ResponseEntity.ok("member deleted succesfully.");
    	}
    	catch(Exception e)
    	{
            return ResponseEntity.badRequest().body(e.getLocalizedMessage());

    	}
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMember(
        @PathVariable int id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String role,
        @RequestParam(required = false) String bio,
        @RequestParam(required = false) String linkedin,
        @RequestParam(required = false) String email,
        @RequestParam(required = false) String github,
        @RequestParam(required = false) String year,
        @RequestParam(required = false) MultipartFile image) {

        return memberservice.updateMember(id, name, role, bio, linkedin, email, github, year, image);
    }
    
    @GetMapping("/getmemberimage/{id}")
    public ResponseEntity<byte[]> getimagebymemberid(@PathVariable int id)
    {
    	Member member = memberservice.getmemberbyid(id);
    	byte[] imagedata= member.getImagedata();
    	return ResponseEntity.ok().body(imagedata);
    }
    
}
