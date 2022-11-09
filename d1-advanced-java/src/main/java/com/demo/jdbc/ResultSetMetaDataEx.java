package com.demo.jdbc;

import java.sql.*;

public class ResultSetMetaDataEx {
    public static void main(String[] args) {
        selectActor();
    }
    private static void selectActor() {
        //        Unhandled exception: java.lang.ClassNotFoundException (checked exception)
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.....");
//            https <protocol> : set of rules governing the transfer of data
//            <protocol><subprotocol><url>
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SAKILA","root","mysql");
            System.out.println("Connected!");
            Statement statement = connection.createStatement();
            System.out.println("Statement created");
            String selectQuery = "SELECT ACTOR_ID, FIRST_NAME, LAST_NAME FROM ACTOR";
            ResultSet resultSet = statement.executeQuery(selectQuery);
//            Moves the cursor forward one row from its current position.
            while(resultSet.next()){
                int actorId = resultSet.getInt("ACTOR_ID");
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString("LAST_NAME");
                System.out.println("Actor details : " + actorId + "\t" + firstName + "\t" + lastName + "\t");
            }
            System.out.println("***************");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            System.out.println("NOC " + resultSetMetaData.getColumnCount());
            for(int i =1; i<=resultSetMetaData.getColumnCount();i++) {
                System.out.println(resultSetMetaData.getColumnName(i) + ":" + resultSetMetaData.getColumnTypeName(i));
            }
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            System.out.println(databaseMetaData.getDriverName());
            System.out.println(databaseMetaData.getUserName());
            System.out.println(databaseMetaData.getDatabaseProductName());
            System.out.println(databaseMetaData.getDatabaseProductVersion());
        }
        catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Missing the Driver class!" + classNotFoundException);
        } catch (SQLException e) {
            System.out.println("Error connecting to SQL " + e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Unable to close the connection " + e);
            }
        }
    }
}

