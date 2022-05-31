package com.springboot.bikeforrent;

import com.springboot.bikeforrent.services.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BikeForRentApplication implements CommandLineRunner {

	@Autowired
	private PropertiesService propertiesService;

	public static void main(String[] args) {
		SpringApplication.run(BikeForRentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("URL is: " + propertiesService.getUrl());
	}
}
