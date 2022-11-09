:beginner: _**Functional Programming**_  

:one: _Researching Functional Programming API_  

1. Find a collection from a code base your have experienced.
2. Look at various possibilities of using functional interfaces with generics
3. Try using Consumer, Function and Predicate functional interfaces
4. Create custom functional interfaces and utilize them.


:two: _ComparatorLambda_  

:point_right: Analyze the follwing program and implement the solution  


```java
public class ComparatorLambda {
    
    public static void main(String... args) {

   List<String> list = Arrays.asList("java", "angular","python","perl");     
//1. Create  anonyous class object for Compparator Interface. 
//2. Create  lambda expression for Comparator Interface.      
//3. Sort the list using  anonyous class object and print the sorted values
//4. Sort the list using  lambda expression and print the sorted values
//Tip:  Use Collections.sort method.

// Use below to print the sorted values
        for(String s : list) {
            System.out.println(s);
        }
    }
}


```
:beginner: _**Stream API**_  


:three: _Stream API_
```java
package com.demo.java8;

public class CountryData {
    public static void main(String[] args) {
        String [] countries = new String[] {"Singapore", "India","Japan", "Russia", "Netherlands", "Ukraine","France", "Italy"};
        // Process the stream to find out
//        1. Count of countries with the minimum characters
//        2. Display the countries in the upper case that has minimum characters.
// 3. Calculate the max using reduce() method.
    }
}

```
  
:beginner: _**JDBC**_  

:four: _User Story_ : 

4.1 As a user I would like to display the movie title, language and category in the below format. 

Hint : Use Joins  

![](movie.png)  


4.2  As a user I would like to display the movie title, language and category in the below format by accepting language and category from the user (hard code values) using PreparedStatement.

4.3  As a user I would like to display the movie title, language and category in the below format by accepting both language and category or only language or category from the user (hard code values) and passing them as parameters to the procedure below.
````sql
CREATE PROCEDURE GET_MOVIE_DETAILS2(LANGUAGE_IN CHAR(50), CATEGORY_NAME_IN CHAR(50))
BEGIN
    SELECT FILM.TITLE, LANGUAGE.NAME AS 'LANGUAGE', CATEGORY.NAME AS 'CATEGORY'
    FROM FILM
             JOIN LANGUAGE ON FILM.LANGUAGE_ID = LANGUAGE.language_id
             JOIN FILM_CATEGORY ON FILM.FILM_ID = FILM_CATEGORY.FILM_ID
             JOIN CATEGORY ON CATEGORY.category_id = film_category.category_id
            --  ADD REQUIRED CONDITIONS HERE!
    -- WHERE CATEGORY.name = CATEGORY_NAME_IN;
END;

CALL GET_MOVIE_DETAILS1;
CALL GET_MOVIE_DETAILS2('Comedy');
```