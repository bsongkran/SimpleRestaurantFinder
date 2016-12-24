package com.example.restaurantfinder.dao;

import com.example.restaurantfinder.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by BERM-PC on 22/12/2559.
 */


public interface RestaurantRepository extends JpaRepository<Restaurant , Long> {

    List<Restaurant> findByNameOrDescription(String name , String description);

}
