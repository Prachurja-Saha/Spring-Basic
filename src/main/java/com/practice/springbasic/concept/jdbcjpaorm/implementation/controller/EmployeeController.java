package com.practice.springbasic.concept.jdbcjpaorm.implementation.controller;

import com.practice.springbasic.concept.jdbcjpaorm.implementation.EmployeeRepo;
import com.practice.springbasic.concept.jdbcjpaorm.implementation.entity.Employee;
import jakarta.persistence.Entity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController    // create RESTful web services using Spring MVC.
@RequestMapping("v1/employee") // map HTTP requests to handler methods of MVC and REST controllers
public class EmployeeController {

    public final EmployeeRepo employeeRepo;

    EmployeeController(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    @GetMapping("/list")
    public List<Employee> byName(@RequestParam("name") String name){
        return employeeRepo.findByName(name);
    }

    // By using responseEntity we can send  Headers + HttpStatusCode
    //    HttpHeaders responseHeaders = new HttpHeaders();
    //    responseHeaders.setLocation(location);  responseHeaders.set("MyResponseHeader", "MyValue");
    //    return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
    @PostMapping
    public ResponseEntity<List<Employee>> create(@RequestBody List<Employee> entities){


     entities.stream()
             .filter(e -> null != e.getLaptop())
             .forEach(e -> e.getLaptop().setEmployee(e)); // this will keep bidirectional relationship
               // we have to manually set that


        // saveall takes Iterable which is grand parent of List
        return new ResponseEntity<>(employeeRepo.saveAll(entities), HttpStatus.CREATED);
        /* This can cause infinite recursion (Stack Over Flow) in response employye -> Laptop -> employe...
        *  to avoid that we can use annotation : @JsonManagedReference and @JsonBackReference
        *  These annotations from the Jackson library help to manage the serialization process,
        *  preventing infinite recursion.
        *  OR
        *  We can use @JsonIgnore
        * */
    }
}
