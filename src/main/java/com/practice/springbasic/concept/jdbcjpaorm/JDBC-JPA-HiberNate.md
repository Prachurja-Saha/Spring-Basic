# Spring internally uses JDBC and Hibernate (and other ORM frameworks) as part of its data access layer
# Spring provides a simpler way to interact with databases using JDBC through JdbcTemplate 

# JDBC:
`Description`: Provides connectivity to databases, requiring developers to write SQL queries to communicate with
               the database directly.
`Usage`: Connecting to DB

# Hibernate:
`Description`: An ORM framework that builds on JDBC, providing advanced features like lazy loading, caching, 
               and transaction management.
`Usage`: It allows developers to `interact with the DB using Java objects instead of SQL queries`, 
         mapping Java classes to database tables. -> [Entity]

# JPA (Java Persistence API):
`Description`: A specification that defines standard methods for data persistence in Java applications, 
               serving as an interface.
`Usage`: like interface , Hibernate provide implementation and JPA just define standard methods to 
         use Hibernate implementation also providing its own additional features.


# In summary:
[JDBC is for direct database communication using SQL]
`Hibernate enhances database interaction with object-oriented features.`
[JPA standardizes the way ORM works, with Hibernate being a popular implementation.]

# We need JDBC to use Hibernate - JDBC as the Foundation: Hibernate is built on top of JDBC.