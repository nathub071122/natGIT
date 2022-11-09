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

:one: _Stream API_
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

:one: _User Story_ : As a user I would like to display the movie title, language and category in the below format. 

Hint : Use Jons  

![](movie.png)  


