package com.event_tracker.beans;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "events")
public class Event implements Serializable {

	private static final long serialVersionUID = -7940380397612783665L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_id")
	private int eventId;

	@Column(name = "event_name")
	private String eventName;

	@Column(name = "event_location")
	private String eventLocation;

	@Column(name = "date")
	private Date date;

	@Column(name = "time")
	private Time time;

	@Transient
	private String timeString;

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getTimeString() {
		return timeString;
	}

	public void setTimeString(Time time) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		int h = cal.get(Calendar.HOUR);
		int m = cal.get(Calendar.MINUTE);
		String timeFormat[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
				"twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six",
				"twenty seven", "twenty eight", "twenty nine" };

		String timeString = null;
		if (m == 00) {
			timeString = timeFormat[h] + " o' clock";
		} else if (m == 1) {
			timeString = "one minute past " + timeFormat[h];
		} else if (m == 59) {
			timeString = "one minute to " + timeFormat[h];
		} else if (m == 15) {
			timeString = "quarter past " + timeFormat[h];
		} else if (m == 30) {
			timeString = "half past " + timeFormat[h];
		} else if (m == 45) {
			timeString = "quarter to " + timeFormat[h + 1];
		} else if (m < 30) {
			timeString = timeFormat[m] + " minutes past " + timeFormat[h];
		} else {
			timeString = timeFormat[60 - m] + " minutes to " + timeFormat[h + 1];
		}
	}

	public Event() {
		super();
	}

	public Event(int eventId, String eventName, String eventLocation, Date date, Time time) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventLocation = eventLocation;
		this.date = date;
		this.time = time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + eventId;
		result = prime * result + ((eventLocation == null) ? 0 : eventLocation.hashCode());
		result = prime * result + ((eventName == null) ? 0 : eventName.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((timeString == null) ? 0 : timeString.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (eventId != other.eventId)
			return false;
		if (eventLocation == null) {
			if (other.eventLocation != null)
				return false;
		} else if (!eventLocation.equals(other.eventLocation))
			return false;
		if (eventName == null) {
			if (other.eventName != null)
				return false;
		} else if (!eventName.equals(other.eventName))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (timeString == null) {
			if (other.timeString != null)
				return false;
		} else if (!timeString.equals(other.timeString))
			return false;
		return true;
	}

}
