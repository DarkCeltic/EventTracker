package com.event_tracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.event_tracker.beans.Event;

public interface EventTrackerService {

	public List<Event> getAllEvents();
}
