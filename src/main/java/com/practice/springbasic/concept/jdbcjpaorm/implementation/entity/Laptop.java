package com.practice.springbasic.concept.jdbcjpaorm.implementation.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String company;
    private Long modelId;

    // We can achieve bidirectional OneToOne mapping
    // Bidirectional : each entity has a reference to the other entity, allowing navigation in both directions.
    @OneToOne
    // by default @OneToOne will generate foreign key with name employee_id to write our custom name we use @JoinColumn
    @JoinColumn(name = "e_id")
    @JsonBackReference
    private Employee employee;
    // If I remove above code than we will achieve unidirectional mapping than we need to remove mappedBy from Employee

    /*
    * @JsonManagedReference: Placed on the parent side of the relationship (in this case, Employee).
    * This marks the entity as the forward part of the relationship.
    * @JsonBackReference: Placed on the child side of the relationship (in this case, Laptop).
    * This marks the entity as the inverse part of the relationship.
    * */
}
