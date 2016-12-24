package com.example.restaurantfinder;

import com.example.restaurantfinder.model.Restaurant;
import com.example.restaurantfinder.service.RestaurantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleRestaurantFinderApplicationTests {

	public static final String API_URL = "http://localhost:8080/Api";

	@Autowired
	RestaurantService restaurantService;

	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	public void contextLoads() {
	}

	@Test
	public void createRestaurant(){

		RestaurantService service = mock(RestaurantService.class);

		Restaurant restaurant = new Restaurant();


		//this.restTemplate.postForEntity("/{username}/vehicle", String.class, "Phil");

		//assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

}
