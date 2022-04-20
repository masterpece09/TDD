/*
 * This class does Integration testing
 */

package com.pece.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.pece.demo.dao.CarBean;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application.properties")
public class TestWithSpringBootTest {

	@LocalServerPort
	private int port;

	@Test
	public void helloTest() {

		// Act
		ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:" + port + "/tdd/hello",
				String.class);

		System.out.println("Holla!");

		// Assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo("Hello world");

	}

	@Test
	public void helloTest2() {

		// Act
		ResponseEntity<String> response = new RestTemplate()
				.getForEntity("http://localhost:" + port + "/tdd/get-car/toto", String.class);

		// Assert
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		// assertThat(response.getBody()).isEqualTo("Hello world");

	}

	/**
	 * Test Save and findByName
	 */
	@Test
	public void saveAndFind() {
		// Act
		CarBean carBean = new CarBean("Toyota", "Toyota 4*4");
		carBean = new RestTemplate()
				.postForEntity("http://localhost:" + port + "/tdd/save-car", carBean , CarBean.class).getBody();
		
		assertThat(carBean.getName()).isEqualTo("Toyota");
		assertThat(carBean.getDetail()).isEqualTo("Toyota 4*4");
		

		// Assert
		//assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		// assertThat(response.getBody()).isEqualTo("Hello world");

	}

}
