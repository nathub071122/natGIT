package com.demo.jdbc;

import java.sql.*;

public class SelectStatementEx {
    public static void main(String[] args) {
//        selectActor();
        getMoviesWithCategoryAndLanguage();
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
    private static void getMoviesWithCategoryAndLanguage() {
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
            String selectQuery = "SELECT FILM.TITLE, LANGUAGE.NAME AS 'LANGUAGE', CATEGORY.NAME AS 'CATEGORY'FROM FILM JOIN LANGUAGE ON FILM.LANGUAGE_ID = LANGUAGE.language_id JOIN FILM_CATEGORY ON FILM.FILM_ID = FILM_CATEGORY.FILM_ID JOIN CATEGORY ON CATEGORY.category_id = film_category.category_id";
            ResultSet resultSet = statement.executeQuery(selectQuery);
//            Moves the cursor forward one row from its current position.
            while(resultSet.next()){
//                int actorId = resultSet.getInt("ACTOR_ID");
//                String firstName = resultSet.getString(2);
//                String lastName = resultSet.getString("LAST_NAME");
//                System.out.println("Actor details : " + actorId + "\t" + firstName + "\t" + lastName + "\t");
                System.out.println("Movie details : " + resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t");
            }
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
