package com.vinay.server;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vinay.model.Event;
import com.vinay.model.Member;
import com.vinay.repository.EventRepository;

@Service
public class EventServiceImplementation implements EventService {

	@Autowired
	EventRepository eventrepo;
	@Override
	public Event addeventphoto(MultipartFile image) {
		
		Event event = new Event();
		try {
			event.setImagedata(image.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventrepo.save(event);
	}

}
