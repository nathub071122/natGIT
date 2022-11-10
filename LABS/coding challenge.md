THE ACTORS CHALLENGE
--------------------

THE ACTORS DASHBOARD!
**********************
Actor [Jim, 5]
Actor [John, 6]
Actor [Will, 2]
Actor [Kate, 1]
Actor [Joy, 5]
Actor [Allen, 2]
Actor [Jill, 5]
**********************
Actor with least movies acted : Actor [Kate, 1]
Actor with most movies acted : Actor [John, 6]
**********************
Moives acted and actors : {1=Kate, 2=Will, Allen, 5=Jim, Joy, Jill, 6=John}
***********************

:books: **Resources**  


```text
The actors.txt file contents
Jim 5
John 6
Will 2
Kate 1
Joy 5
Allen 2
Jill 5
```

----------------------------
The Program Skeleton

```java
package com.demo;

import com.demo.model.Actor;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {

    public static void main(String... args)  {
        System.out.println("THE ACTORS DASHBOARD!");
        System.out.println("**********************");
        //1. CREATE THE ACTORS MODEL IN Actor.java
        List<Actor> actors = new ArrayList<>();

        try (
        // 2. CODE TO READ FROM actors.txt
                BufferedReader reader = <<CODE HERE>>
                
                Stream<String> stream = reader.lines();
        ) {
        //3. MAP EACH LINE TO ACTOR AND PRINT ON CONSOLE
            stream.map( 
            <<CODE HERE>>
            

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        System.out.println("**********************");
        //4. GET ACTORS WITH LEAST ACTED MOVIES
        Optional<Actor> opt = 
        <<CODE HERE>>
        System.out.println("Actor with least movies acted : " + opt.get());

        //5. GET ACTORS WITH MOST ACTED MOVIES
        
        Optional<Actor> opt2 = 
        <<CODE HERE>>
        System.out.println("Actor with most movies acted : " + opt.get());
        System.out.println("**********************");

        //6. MAP AND PRINT THE MOVIES ACTED AND ACTORS.
        Map<Integer, String> map =
        <<CODE HERE>>
        
        System.out.println("Moives acted and actors : " + map);
    }
}
```

:eye: *Handle the required exceptions*  