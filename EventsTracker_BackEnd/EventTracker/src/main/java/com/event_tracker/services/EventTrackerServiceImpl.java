package com.event_tracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event_tracker.beans.Event;
import com.event_tracker.repositories.EventTrackerRepository;

@Service
public class EventTrackerServiceImpl implements EventTrackerService {

	private EventTrackerRepository evp;
	
	@Autowired
	public void setEventTrackerService(EventTrackerRepository evp) {
		this.evp = evp;
	}
	

	@Override
	public List<Event> getAllEvents() {
		return evp.getAllEvents();
	}
}
