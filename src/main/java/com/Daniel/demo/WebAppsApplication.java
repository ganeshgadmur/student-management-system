package com.Daniel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class WebAppsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppsApplication.class, args);
		
//		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
//		
//		String encoded = encoder.encode("1234");
//		System.out.println("Encoded:" + encoded);
//		//System.out.println(encoder.matches("1234", encoded));
//		//System.out.println(encoder.matches("5678", encoded));
	}

}

