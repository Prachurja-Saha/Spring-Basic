package com.practice.springbasic.concept.jdbcjpaorm.implementation.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// spring data jpa is build on top of jpa specification.It simplifies working with jpa

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /*
     If underlying database doesn't support IDENTITY column or some similar variant then the persistence provider
     can choose an alternative appropriate strategy.

    * GenerationType.AUTO strategy delegates the responsibility of ID generation to the persistence provider,
    * which may choose any appropriate strategy based on the database capabilities.
    * */
    private Long id;
    private String name;

    // mappedBy = "employee" : indicates that the Laptop entity owns the bidirectional relationship.
    // In Laptop entity : private Employee employee; employee is mapped here
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL) // one Employee should have one laptop
    @JsonManagedReference // prevent infinite loop should placed in parent side where response will Employee and child will
    private Laptop laptop;// be laptop if response/parent is laptop child is employee than place @JsonManagedReference
                          // in laptop

    // for OneToOne mapping we will uncomment below code and comment/delete annotation code written in Laptop and also
    // remove mappedBy = employee which is written inside @OneToOne
    // @JoinColumn(name = "l_id", referencedColumnName = "id") //-> referencedColumnName is Laptop primary key column
    // private Laptop laptop;


}