package com.ecomhouse.ecomhousebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomhouse.ecomhousebackend.entity.CustomerSupportHours;

@Repository
public interface CustomerSupportHoursRepository extends JpaRepository<CustomerSupportHours, Long> {

}