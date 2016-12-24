package com.example.restaurantfinder.api.controllers;

import com.example.restaurantfinder.api.responses.ApiResponse;
import com.example.restaurantfinder.model.OpeningHour;
import com.example.restaurantfinder.model.Restaurant;
import com.example.restaurantfinder.service.OpeningHourService;
import io.swagger.annotations.*;
import org.jsondoc.core.annotation.ApiMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * Created by BERM-PC on 24/12/2559.
 */

@RestController
@RequestMapping("/Api/OpeningHour")
public class OpeningHourController {


    @Autowired
    OpeningHourService openingHourService;

    @RequestMapping(value = "/createOpeningHour", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiMethod(description = "Create OpeningHour")
    @ApiOperation(value = "createOpeningHour", nickname = "createOpeningHour", notes = "Create OpeningHour Note")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue = "Niklas")
    })
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = OpeningHour.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
            @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
            @io.swagger.annotations.ApiResponse(code = 500, message = "Failure")})
    public ApiResponse createOpeningHour(@RequestBody OpeningHour openingHour) {
        ApiResponse response = new ApiResponse();

        try {
            response.setStatus("success");
            openingHourService.saveOpeningHour(openingHour);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus("failed");
        }


        return response;
    }

    @RequestMapping(value = "/updateOpeningHour", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiMethod(description = "updateOpeningHour")
    @ApiOperation(value = "updateOpeningHour", nickname = "updateOpeningHour", notes = "updateOpeningHour")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue = "Niklas")
    })
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = OpeningHour.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
            @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
            @io.swagger.annotations.ApiResponse(code = 500, message = "Failure")})
    public ApiResponse updateOpeningHour(@RequestBody OpeningHour openingHour) {
        ApiResponse response = new ApiResponse();

        try {
            response.setStatus("success");
            openingHourService.updateOpeningHour(openingHour);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus("failed");
        }
        return response;
    }

    @RequestMapping(value = "/deleteOpeningHour", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiMethod(description = "deleteOpeningHour")
    @ApiOperation(value = "deleteOpeningHour", nickname = "deleteOpeningHour", notes = "deleteOpeningHour")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue = "Niklas")
    })
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = OpeningHour.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
            @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
            @io.swagger.annotations.ApiResponse(code = 500, message = "Failure")})
    public ApiResponse deleteOpeningHour(@RequestBody long openingHourId) {
        ApiResponse response = new ApiResponse();
        try {
            response.setStatus("success");
            openingHourService.deleteOpeningHour(openingHourId);
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus("failed");
        }
        return response;
    }


    @RequestMapping(value = "/getOpeningHourById", method = RequestMethod.GET)
    @ApiMethod(description = "getOpeningHourById")
    @ApiOperation(value = "getOpeningHourById", nickname = "getOpeningHourById", notes = "getOpeningHourById")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "openingHourId",
                    value = "openingHourId is require",
                    required = true, dataType = "long",
                    paramType = "query", defaultValue = "1")
    })
    @ApiResponses(value = {
            @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = OpeningHour.class),
            @io.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
            @io.swagger.annotations.ApiResponse(code = 403, message = "Forbidden"),
            @io.swagger.annotations.ApiResponse(code = 404, message = "Not Found"),
            @io.swagger.annotations.ApiResponse(code = 500, message = "Failure")})
    public ResponseEntity<OpeningHour> getOpeningHourById(long openingHourId) {
        OpeningHour openingHour = openingHourService.findById(openingHourId);
        return new ResponseEntity(openingHour, HttpStatus.OK);
    }

}
