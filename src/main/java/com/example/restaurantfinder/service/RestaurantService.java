package com.example.restaurantfinder.service;

import com.example.restaurantfinder.model.Restaurant;

import java.util.List;

/**
 * Created by BERM-PC on 22/12/2559.
 */
public interface RestaurantService {

    Restaurant findRestaurantById(long id);

    List<Restaurant> getAllRestaurant();

    void saveRestaurant(Restaurant restaurant) throws Exception;

    void updateRestaurant(Restaurant restaurant) throws Exception;

    void deleteRestaurant(long id) throws Exception;

}
