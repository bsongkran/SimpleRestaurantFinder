package com.example.restaurantfinder.api.controllers;

import com.example.restaurantfinder.model.*;
import com.example.restaurantfinder.service.RestaurantService;
import io.swagger.annotations.*;
import org.jsondoc.core.annotation.ApiMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.restaurantfinder.api.responses.ApiResponse;


import java.util.Collection;

/**
 * Created by BERM-PC on 22/12/2559.
 */

@RestController
@RequestMapping("/Api/RestaurantFinder")
public class RestaurantFinderController {

    @Autowired
    RestaurantService restaurantService;


   /** Create Restaurant */

    @RequestMapping(value = "/createRestaurant", method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiMethod(description = "Create Restaurant")
    @ApiOperation( value = "getAllRestaurants", nickname = "getAllRestaurants" ,  notes = "Create Restaurant Note")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue="Niklas")
    })
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = Restaurant.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
            @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
            @io.swagger.annotations.ApiResponse(code = 500, message = "Failure")})

    public ResponseEntity<ApiResponse> createRestaurant(@RequestBody Restaurant restaurant){
        ApiResponse apiResponse = new ApiResponse();
        try {
            restaurantService.saveRestaurant(restaurant);
            apiResponse.setStatus("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity( apiResponse , HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.POST, value="/updateRestaurant", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiMethod(description = "Update restaurant")
    @ApiOperation(value = "updateRestaurant", nickname = "updateRestaurant")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "name",
                    value = "User's name",
                    required = false,
                    dataType = "string",
                    paramType = "query",
                    defaultValue="Niklas")
    })
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = Restaurant.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
            @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
            @io.swagger.annotations.ApiResponse(code = 500, message = "Failure")})
    public ApiResponse updateRestaurant(@RequestBody Restaurant restaurant){
        ApiResponse apiResponse = new com.example.restaurantfinder.api.responses.ApiResponse();
        try {
            restaurantService.updateRestaurant(restaurant);
            apiResponse.setStatus("success");
        } catch (Exception e) {
            apiResponse.setStatus("failed");
            e.printStackTrace();
        }

        return apiResponse;
    }


    @RequestMapping(method = RequestMethod.POST, value="/deleteRestaurant", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiMethod(description = "Delete restaurant")
    @ApiOperation(value = "deleteRestaurant",  notes = "Delete Restaurant should be not empty restaurantId")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "name",
                    value = "1234",
                    required = false,
                    dataType = "long",
                    paramType = "query",
                    defaultValue="123456")
    })
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = Restaurant.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
            @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
            @io.swagger.annotations.ApiResponse(code = 500, message = "Failure")})
    public ApiResponse deleteRestaurant(@RequestBody long restaurantId){
        ApiResponse apiResponse = new com.example.restaurantfinder.api.responses.ApiResponse();
        try {
            restaurantService.deleteRestaurant(restaurantId);
            apiResponse.setStatus("success");
        } catch (Exception e) {
            apiResponse.setStatus("failed");
            e.printStackTrace();
        }

        return apiResponse;
    }



    @RequestMapping(method = RequestMethod.GET, value="/getRestaurantById")
    @ApiMethod(description = "Get restaurant where the price per night is less than the provided value")
    @ApiOperation( value = "getRestaurantById", nickname = "getRestaurantById" ,  notes = "Multiple status values can be provided with comma seperated strings")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "restaurantId",
                    value = "required",
                    required = true, dataType = "long",
                    paramType = "query")
    })
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = Restaurant.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
            @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
            @io.swagger.annotations.ApiResponse(code = 500, message = "Failure")})

    public ResponseEntity<Restaurant> getRestaurantById(@RequestParam(value = "restaurantId" ) long restaurantId){

        Restaurant restaurant = restaurantService.findRestaurantById(restaurantId);

        return new ResponseEntity(restaurant, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value="/getAllRestaurants", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiMethod(description = "Get all restaurant where the price per night is less than the provided value")
    @ApiOperation( value = "getAllRestaurants", nickname = "getAllRestaurants" ,  notes = "Multiple status values can be provided with comma seperated strings")

    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = Restaurant.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
            @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
            @io.swagger.annotations.ApiResponse(code = 500, message = "Failure")})

    public ResponseEntity<Collection<Restaurant>> getAllRestaurants(){
        return new ResponseEntity(restaurantService.getAllRestaurant(), HttpStatus.OK);
    }



}
