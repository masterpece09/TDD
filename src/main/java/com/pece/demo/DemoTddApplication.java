package com.pece.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.pece.demo.service"})
public class DemoTddApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTddApplication.class, args); 
		
	} 

}
