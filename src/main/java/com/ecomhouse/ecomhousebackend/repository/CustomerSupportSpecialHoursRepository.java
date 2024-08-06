package com.ecomhouse.ecomhousebackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomhouse.ecomhousebackend.entity.CustomerSupportSpecialHours;

@Repository
public interface CustomerSupportSpecialHoursRepository extends JpaRepository<CustomerSupportSpecialHours, Long> {

    Optional<CustomerSupportSpecialHours> findByDate(String date);

    List<CustomerSupportSpecialHours> findByDateGreaterThan(String date);

}