package com.example.restaurantfinder.controller;

import com.example.restaurantfinder.model.Restaurant;
import com.example.restaurantfinder.service.RestaurantService;
import org.jsondoc.core.annotation.ApiMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by BERM-PC on 22/12/2559.
 */

@RestController
public class RestaurantFinderRestController {

    @Autowired
    RestaurantService restaurantService;


    @RequestMapping(value = "/createRestaurant", method = RequestMethod.POST , headers = "application/json")
    public ResponseEntity<String> createRestaurant(@RequestBody Restaurant restaurant){
        restaurantService.saveRestaurant(restaurant);
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity( "" , HttpStatus.CREATED);
    }




    @RequestMapping(value = "/getAllRestaurant", method = RequestMethod.GET)
    @ApiMethod(description = "Get all restaurant where the price per night is less than the provided value")
    public ResponseEntity<Collection<Restaurant>> getAllRestaurants(){
        return new ResponseEntity(restaurantService.getAllRestaurant(), HttpStatus.OK);
    }







}
