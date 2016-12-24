package com.example.restaurantfinder.service;

import com.example.restaurantfinder.dao.OpeningHourRepository;
import com.example.restaurantfinder.model.OpeningHour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by BERM-PC on 24/12/2559.
 */

@Service
@Transactional
public class OpeningHourServiceImpl implements OpeningHourService {

    @Autowired
    OpeningHourRepository openingHourRepository;

    @Override
    public void saveOpeningHour(OpeningHour openingHour) throws Exception {
        openingHourRepository.save(openingHour);
    }

    @Override
    public void updateOpeningHour(OpeningHour openingHour) throws Exception {
        openingHourRepository.save(openingHour);
    }

    @Override
    public void deleteOpeningHour(long openingHourId) throws Exception {
        openingHourRepository.delete(openingHourId);
    }

    @Override
    public OpeningHour findById(long openingHourId) {
        return openingHourRepository.findOne(openingHourId);
    }

    @Override
    public List<OpeningHour> getAllOpeningHour() {
        return (List<OpeningHour>) openingHourRepository.findAll();
    }

    @Override
    public List<OpeningHour> getListOfOpeningHourByRestaurantId(long restaurantId) {
        return null;
    }
}
