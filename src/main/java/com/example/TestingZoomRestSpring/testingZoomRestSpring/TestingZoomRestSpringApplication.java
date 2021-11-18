package com.example.TestingZoomRestSpring.testingZoomRestSpring;

import com.example.TestingZoomRestSpring.testingZoomRestSpring.service.TravelResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestingZoomRestSpringApplication {

	@Autowired
	TravelResultService travelResultService = new TravelResultService();

	public static void main(String[] args) {
		try {
			SpringApplication.run(TestingZoomRestSpringApplication.class, args);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
