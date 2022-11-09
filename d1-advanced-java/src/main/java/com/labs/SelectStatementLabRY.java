package com.labs;

import java.sql.*;

public class SelectStatementLabRY {
    public static void main(String[] args) {
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
            String selectQuery =
                    "SELECT a.TITLE AS TITLE, b.NAME AS LANGUAGE, d.NAME AS CATEGORY FROM FILM a " +
                            "LEFT JOIN LANGUAGE b ON a.LANGUAGE_ID  = b.LANGUAGE_ID " +
                            "LEFT JOIN FILM_CATEGORY c ON a.FILM_ID  = c.FILM_ID " +
                            "LEFT JOIN CATEGORY d ON c.CATEGORY_ID = d.CATEGORY_ID;";

//                    "select a.title as TITLE , b.name as LANGUAGE, d.name as CATEGORY from film a, language b, film_category c, category d \n" +
//                            "where a.language_id=b.language_id and a.film_id=c.film_id and c.category_id=d.category_id";
//                    "select a.title as TITLE , a.name as LANGUAGE, b.name as CATEGORY from \n" +
//                    "(SELECT film.title, language.name, film_category.category_id\n" +
//                    "FROM film\n" +
//                    "INNER JOIN language \n" +
//                    "ON film.language_id=language.language_id\n" +
//                    "INNER JOIN film_category \n" +
//                    "ON film.film_id=film_category.film_id) a\n" +
//                    "INNER JOIN  \n" +
//                    "(SELECT category.name , category_id\n" +
//                    "FROM category where category.category_id in (select category_id from  film_category)) b\n" +
//                    "ON a.category_id=b.category_id";
            ResultSet resultSet = statement.executeQuery(selectQuery);
//            Moves the cursor forward one row from its current position.
            while(resultSet.next()){
                String title = resultSet.getString(1);
                String language = resultSet.getString(2);
                String category = resultSet.getString(3);
                System.out.println("Film details : " + title + "\t" + language + "\t" + category + "\t");
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