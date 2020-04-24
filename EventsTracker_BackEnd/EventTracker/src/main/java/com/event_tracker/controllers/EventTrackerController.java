package com.event_tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event_tracker.beans.Event;
import com.event_tracker.services.EventTrackerService;

@RestController
public class EventTrackerController {

	private EventTrackerService evs;
	
	@Autowired
	public void setEventTrackerService(EventTrackerService evs) {
		this.evs = evs;
	}
	
	@GetMapping("/events")
	public List<Event> getAdmins() {
		
		return evs.getAllEvents();
	}
}
