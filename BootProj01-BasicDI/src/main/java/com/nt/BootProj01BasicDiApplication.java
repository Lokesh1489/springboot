package com.nt;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.WishMessageGenerator;

@SpringBootApplication
public class BootProj01BasicDiApplication {
	@Bean(name = "ldt")
	public LocalDateTime createLDT() {
		System.out.println("BootProj01BasicDiApplication.createLDT()");
		return LocalDateTime.now();

	}

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(BootProj01BasicDiApplication.class, args);
		WishMessageGenerator generator = factory.getBean("wmg", WishMessageGenerator.class);
		String message = generator.showWishMessage("lokesh");
		System.out.println(message);
	}
}
