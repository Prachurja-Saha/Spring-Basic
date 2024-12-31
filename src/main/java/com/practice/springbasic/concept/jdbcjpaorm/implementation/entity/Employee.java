package com.practice.springbasic.concept.jdbcjpaorm.implementation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private Long id;

    private String name;

    //private OfficeAddress officeAddress;

}