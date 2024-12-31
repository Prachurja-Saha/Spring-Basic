# JDBC (Java Database Connectivity) is part of the Java SE (Standard Edition) and JEE is extended version
# of Java SE. JDBC provides the standard API for connecting Java applications to relational databases
# and performing database operations like queries, updates, and transactions

# JDBC [Java Data Base Connectivity]
- It is a Java API for connecting to relational databases and performing CRUD operations(Create, Read, Update, Delete). 
- With JDBC, you can execute SQL queries, retrieve data, and handle transactions within Java applications. 
- It provides a way to interact with databases in a standardized manner, 
- `but it requires manual handling of SQL, connections, and result sets.` 
- `Many frameworks, like Spring Data, are built on top of JDBC to simplify database access and reduce the amount of 
  boilerplate code required.`


# Every RDMS has their own driver i.e MYSQL -> MYSQL Driver etc. (driver is needed to connect database)
  [That's why we need to download JAR of the DataBase driver]
- Java provides package java.sql where 
- `java.sql package is the core of JDBC (Java Database Connectivity) in Java. 
   It contains the main classes and interfaces that enable Java applications to interact with relational databases.`
- To connect Data Base we need to provide url with port , db-name, password
- Every Db has their own port -> Postgres port -> 5432, Mysql port -> 

`Note` Always close the connection after using JDBC