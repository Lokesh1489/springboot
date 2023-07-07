package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("hotel")
@Data
public class Hotel {
	@Value("12345")
	private Integer hotelid;
	@Value("${hotel.name}")
	private String hotelname;
	@Value("${hotel.addrs}")
	private String hotelAddrs;
	@Value("${hotel.contactno}")
	private String MobileNo;
	@Value("${customer.name}")
	private String custName;
	
	

}
