package com.ecomhouse.ecomhousebackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "customer_support_hours")
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSupportHours {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mondayToThursday;
    private String friday;
    private String saturday;
    private String sunday;

}