package com.ContentAlchemy.OTPGen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ContentAlchemy")
public class OtpGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtpGenApplication.class, args);
		System.out.println("Hello Programmer!");
	}

}
