package com.practice.springbasic.concept.jdbcjpaorm.implementation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeAddress {

    @Id
    private Long id;

    private String state;
    private String city;
    private int pin;
}
