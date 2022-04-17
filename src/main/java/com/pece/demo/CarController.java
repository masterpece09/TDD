package com.pece.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pece.demo.dao.CarBean;
import com.pece.demo.service.CarServiceInt;


@RestController
public class CarController {
	
	@Autowired
	private CarServiceInt carService;
	
	@PostMapping("/save-car")
	public CarBean saveCar(@RequestBody CarBean car) {
		return carService.save(car);
		
	}

}
