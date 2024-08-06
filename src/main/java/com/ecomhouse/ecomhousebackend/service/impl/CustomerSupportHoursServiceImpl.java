package com.ecomhouse.ecomhousebackend.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomhouse.ecomhousebackend.dto.CustomerSupportSpecialHoursDto;
import com.ecomhouse.ecomhousebackend.entity.CustomerSupportHours;
import com.ecomhouse.ecomhousebackend.entity.CustomerSupportSpecialHours;
import com.ecomhouse.ecomhousebackend.repository.CustomerSupportHoursRepository;
import com.ecomhouse.ecomhousebackend.repository.CustomerSupportSpecialHoursRepository;
import com.ecomhouse.ecomhousebackend.service.CustomerSupportHoursService;

@Service
public class CustomerSupportHoursServiceImpl implements CustomerSupportHoursService {

    private final ModelMapper modelMapper;
    private final CustomerSupportHoursRepository hoursRepository;
    private final CustomerSupportSpecialHoursRepository specialHoursRepository;

    @Autowired
    public CustomerSupportHoursServiceImpl(ModelMapper modelMapper, CustomerSupportHoursRepository hoursRepository,
            CustomerSupportSpecialHoursRepository specialHoursRepository) {
        this.modelMapper = modelMapper;
        this.hoursRepository = hoursRepository;
        this.specialHoursRepository = specialHoursRepository;
    }

    // Method to get customer support hours, todays special hours & future special
    // hours
    @Override
    public Map<String, Object> getCustomerSupportHours() {
        try {
            // Get customer support hours data
            Optional<CustomerSupportHours> hours = hoursRepository.findById(1L);

            // Check if the data is not present then return null
            // In this case controller method will throw internal server error
            if (!hours.isPresent()) {
                return null;
            } else {

                // Create a map to store the data
                Map<String, Object> mainMap = new LinkedHashMap<>();
                mainMap.put("hours", hours.get());

                // Get today's date in yyyy-MM-dd format
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = formatter.format(date);

                // Check if special hours data is present for today then add it to the map
                // If not present then add empty map
                Optional<CustomerSupportSpecialHours> specialHours = specialHoursRepository.findByDate(formattedDate);
                if (specialHours.isPresent()) {
                    mainMap.put("specialHours", specialHours.get());
                } else {
                    mainMap.put("specialHours", new HashMap<>());
                }

                // Check if the future special hours data is present then add it to the map
                // If not present then add empty list
                List<CustomerSupportSpecialHours> futureSpecialHours = specialHoursRepository
                        .findByDateGreaterThan(formattedDate);
                if (!futureSpecialHours.isEmpty()) {
                    mainMap.put("futureSpecialHours", futureSpecialHours);
                } else {
                    mainMap.put("futureSpecialHours", new ArrayList<>());
                }

                return mainMap;

            }

        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching customer support hours");
        }
    }

    // Method to add special hours
    @Override
    public CustomerSupportSpecialHoursDto addSpecialHours(CustomerSupportSpecialHoursDto specialHours) {
        try {

            // Check if the special hours for the date is already present
            // If yes then update the existing hours else add new hours
            Optional<CustomerSupportSpecialHours> existingSpecialHours = specialHoursRepository
                    .findByDate(specialHours.getDate());

            if (existingSpecialHours.isPresent()) {
                existingSpecialHours.get().setHours(specialHours.getHours());
                return modelMapper.map(specialHoursRepository
                        .save(existingSpecialHours.get()), CustomerSupportSpecialHoursDto.class);
            } else {
                CustomerSupportSpecialHours newSpecialHours = CustomerSupportSpecialHours.builder()
                        .date(specialHours.getDate()).hours(specialHours.getHours()).build();
                return modelMapper.map(specialHoursRepository.save(newSpecialHours),
                        CustomerSupportSpecialHoursDto.class);
            }

        } catch (Exception e) {
            throw new RuntimeException("An error occurred while adding special hours");
        }
    }

}