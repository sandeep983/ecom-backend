package com.ecomhouse.ecomhousebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecomhouse.ecomhousebackend.dto.Response;
import com.ecomhouse.ecomhousebackend.dto.CustomerSupportSpecialHoursDto;
import com.ecomhouse.ecomhousebackend.service.CustomerSupportHoursService;

import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customer-support")
public class CustomerSupportController {

    private final CustomerSupportHoursService service;

    @Autowired
    public CustomerSupportController(CustomerSupportHoursService service) {
        this.service = service;
    }

    // Api to get customer support hours & todays special hours
    @GetMapping("/hours")
    public Response<Map<String, Object>> getCustomerSupportHours() {

        Response<Map<String, Object>> response = new Response<>();

        Map<String, Object> hoursMap = service.getCustomerSupportHours();
        if (Objects.nonNull(hoursMap)) {
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Customer support hours fetched successfully");
            response.setData(hoursMap);
        } else {
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Something went wrong");
        }
        return response;

    }

    // Api to add the special hours data
    @PostMapping("/special-hours")
    public Response<CustomerSupportSpecialHoursDto> addSpecialHours(
            @RequestBody @Valid CustomerSupportSpecialHoursDto specialHours) {

        Response<CustomerSupportSpecialHoursDto> response = new Response<>();

        CustomerSupportSpecialHoursDto specialHoursDto = service.addSpecialHours(specialHours);
        if (Objects.nonNull(specialHoursDto)) {
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Special hours added successfully");
            response.setData(specialHoursDto);
        } else {
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Something went wrong");
        }

        return response;

    }

}