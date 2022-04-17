package com.pece.demo.service;

import com.pece.demo.dao.CarBean;

public interface CarServiceInt {

	public CarBean getCarByName(String name);
	
	public CarBean save(CarBean car);
	
	public CarBean findByName(String name);
}
