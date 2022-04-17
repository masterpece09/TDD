package com.pece.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pece.demo.dao.CarBean;
import com.pece.demo.dao.CarRepository;

@Service
public class CarServices implements CarServiceInt {

	@Autowired
	private CarRepository carRepository;
	
	public CarBean getCarByName(String name) 
	{
		return new CarBean("Toyota X", "Advensis 2008");
	}

	@Override
	public CarBean save(CarBean car) {
		return carRepository.save(car);
	}

	@Override
	public CarBean findByName(String name) {
		return carRepository.findByName(name);
	}
}
