package com.nt.sbeans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {

	@Autowired
	private LocalDateTime ldt;

	public String showWishMessage(String user) {
		System.out.println("WishMessageGenerator.showWishMessage()");
		// get current hour of the day 
		int hour = ldt.getHour(); // in 24 hours format  
		if (hour < 12)
			return "GOOD MORNING " + user;
		else if (hour < 16)
			return "GOOD AFTERNOON " + user;
		else if (hour < 20)
			return "GOOD EVENING " + user;
		else
			return "GOOD NIGHT " + user;
	}
}
