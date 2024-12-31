package com.practice.springbasic.jdbc;

import java.sql.*;

public class JdbcTest {

    // If it is postgres then -> jdbc:postgres://localhost:5432/db-name
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jdbc-test";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args){

        try {

            String query = "select * from employees";

            // We need to download Jar for MySql Driver
            Connection con = DriverManager.getConnection(JDBC_URL,USER,PASSWORD);
            // Connection -> interface

            /* Statement */
            Statement st = con.createStatement();

            // select query
            ResultSet rs = st.executeQuery(query);
            System.out.println(rs); // is of pointer type

            while (rs.next()) { // iterating
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String position = rs.getString("position");
                double salary = rs.getDouble("salary");
                System.out.printf("ID: %d, Name: %s, Position: %s, Salary: %.2f%n", id, name, position, salary);
            }

            con.close(); // closing connection
            /* Or we can use try with resourse*/

        } catch (SQLException e) {// Checked exception
            throw new RuntimeException(e);
        }

         /* try with resource */
       // try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)

    }
}
