package com.example.restaurantfinder.service;

import com.example.restaurantfinder.model.Restaurant;
import com.example.restaurantfinder.dao.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by BERM-PC on 22/12/2559.
 */

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public Restaurant findRestaurantById(long id) {
        return restaurantRepository.findOne(id);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(long id) {
        restaurantRepository.delete(id);
    }


}
