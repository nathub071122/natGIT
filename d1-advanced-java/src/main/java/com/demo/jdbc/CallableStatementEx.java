package com.demo.jdbc;

import java.sql.*;

public class CallableStatementEx {
    public static void main(String[] args) {
//        selectActor();
        getMoviesWithCategoryAndLanguage();
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
            String callProcedure = "{ call GET_MOVIE_DETAILS1}";
            System.out.println("Connected!");
            CallableStatement callableStatement = connection.prepareCall(callProcedure);
            System.out.println("Callable Statement created");

            ResultSet resultSet = callableStatement.executeQuery();
//            Moves the cursor forward one row from its current position.
            while(resultSet.next()){
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
