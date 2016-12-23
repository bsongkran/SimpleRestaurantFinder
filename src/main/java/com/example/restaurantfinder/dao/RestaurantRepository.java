package com.example.restaurantfinder.dao;

import com.example.restaurantfinder.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by BERM-PC on 22/12/2559.
 */


public interface RestaurantRepository extends JpaRepository<Restaurant , Long> {


}
