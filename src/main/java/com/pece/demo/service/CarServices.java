package com.pece.demo.service;

import org.springframework.stereotype.Service;

import com.pece.demo.dao.CarBean;

@Service
public class CarServices implements CarServiceInt {

	public CarBean getCarByName(String name) 
	{
		return new CarBean("Toyota X", "Advensis 2008");
	}
}
