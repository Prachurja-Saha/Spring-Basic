package com.practice.springbasic.springcore.usefulannotation;

import jakarta.validation.constraints.*;

// Spring Boot uses Hibernate Validator, which is the default implementation of Bean Validation (JSR-303/JSR-380).
public class ValidationBasedAnnotation {

    //@Valid does not require (@Validated. --> Class level)
    // Other validation i.e @NotNull, @Positive ->> @Validated is required
}

class UserDTO {

    @NotNull(message = "ID cannot be null") //
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, max = 50, message = "Name must be 3 to 50 characters long")
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 60, message = "Age must be at most 60")
    private int age;

   // The message provided in @NotNull(message = "ID cannot be null") is used for error reporting when validation fails.
    // Here’s how it is used: if validation fails spring boot return
   /*
   {
    "id": "ID cannot be null"
    }
    */
}
