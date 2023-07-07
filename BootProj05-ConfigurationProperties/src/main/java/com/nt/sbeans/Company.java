package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("comp")
@Setter
@ToString
@ConfigurationProperties(prefix = "org.softtek")
@PropertySource("App.properties")

public class Company {
	private String name;
	private String addrs;
	private Long pincode;
	private Long contact;

	@Value("${softtek.size}")
	private Integer size;
}
