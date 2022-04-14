package com.pece.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
/*
 * This Class does unit testing
 */

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.pece.demo.dao.CarBean;
import com.pece.demo.service.CarServiceInt;

@RunWith(SpringRunner.class)
@WebMvcTest
public class DemoTddApplicationTests  {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
    private CarServiceInt carServiceInt; 

	@Test
	public void testMockMVC() throws Exception {
//		MockMvc mockMvc =  MockMvcBuilders.standaloneSetup(new DemoTddApplicationTests()).build();
		MvcResult result = mockMvc.perform(get("/hello").contentType("application/json")).andExpect(status().isOk()).andReturn();
		assertThat(result.getResponse().getContentAsString()).isEqualTo("Hello world");
		
	}
	

	@Test
	public void testGetCar() throws Exception {
		Mockito.when(carServiceInt.getCarByName("toto")).thenReturn(new CarBean("Toyota", "Avensix 2019"));
				
		MvcResult result = mockMvc.perform(get("/get-car/toto").contentType("application/json"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("name").value("Toyota"))
				.andExpect(jsonPath("detail").value("Avensix 2019"))
				.andReturn();
//		assertThat(result.getResponse().getContentAsString()).isEqualTo("Hello world");
	}

}