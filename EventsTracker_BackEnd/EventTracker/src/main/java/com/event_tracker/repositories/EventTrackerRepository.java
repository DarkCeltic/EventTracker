package com.event_tracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.event_tracker.beans.Event;

@Repository
public interface EventTrackerRepository extends JpaRepository<Event, String>{
	
	@Query("select e from Event e")
	public List<Event> getAllEvents();
}