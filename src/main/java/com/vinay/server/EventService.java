package com.vinay.server;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vinay.model.Event;
import com.vinay.model.Member;

@Service
public interface EventService {

	Event addeventphoto(MultipartFile image);

}
