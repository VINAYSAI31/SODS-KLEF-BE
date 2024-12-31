package com.vinay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.model.Member;
import com.vinay.server.MemberServiceImp;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    MemberServiceImp memberservice;

    @PostMapping("/addmember")
    public ResponseEntity<?> addmember(@RequestBody Member mem) {
        try {
            Member member = memberservice.addmember(mem);
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
}
