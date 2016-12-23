package com.example.restaurantfinder.controller;

/**
 * Created by BERM-PC on 23/12/2559.
 */
public class ApiResponse {

    private String status;
    private String message;

    public ApiResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
