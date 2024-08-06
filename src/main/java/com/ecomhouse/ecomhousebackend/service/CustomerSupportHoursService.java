package com.ecomhouse.ecomhousebackend.service;

import java.util.Map;

import com.ecomhouse.ecomhousebackend.dto.CustomerSupportSpecialHoursDto;

public interface CustomerSupportHoursService {

    Map<String, Object> getCustomerSupportHours();

    CustomerSupportSpecialHoursDto addSpecialHours(CustomerSupportSpecialHoursDto specialHours);

}