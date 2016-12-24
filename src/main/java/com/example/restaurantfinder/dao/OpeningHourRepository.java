package com.example.restaurantfinder.dao;

import com.example.restaurantfinder.model.OpeningHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by BERM-PC on 24/12/2559.
 */
public interface OpeningHourRepository  extends JpaRepository<OpeningHour, Long> {
}
