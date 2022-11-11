<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.demo</groupId>
  <artifactId>d2-advanced-java-v2</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>d2-advanced-java-v2</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.release>11</maven.compiler.release>
  </properties>

  <dependencies>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-engine</artifactId>
      <version>5.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <pluginManagement>
      <plugins>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.1</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
</project>


package com.demo.annotations;

import java.io.Serializable;

//APPLIED CLASS LEVEL, FIELD LEVEL, METHOD LEVEL
@JsonSerializable
public class Actor {
    @JsonElement
    private String firstName;
    @JsonElement
    private String lastName;
    private String noOfMoviesActed;
    
    private String language;
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName) {
        this.lastName = lastName;
    }

    public Actor(String firstName, String lastName, String noOfMoviesActed) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.noOfMoviesActed = noOfMoviesActed;
    }

    @Init
    private void initProperCase() {
//jim = Jim
        this.firstName = this.firstName.substring(0,1).toUpperCase()+ this.firstName.substring(1);
        this.lastName = this.lastName.substring(0,1).toUpperCase()+ this.lastName.substring(1);
    }
    @Override
    public String toString() {
        return "Actor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", noOfMoviesActed='" + noOfMoviesActed + '\'' +
                '}';
    }
}

package com.demo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//CREATE METHOD LEVEL ANNOTATION
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Init {
}

package com.demo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
// CREATE ANNOTATION FOR FIELD
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JsonElement {
    public String key() default "";
}

package com.demo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
// CREATING A CLASS LEVEL ANNOATION
//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Target(TYPE)
//delcare an annotation with @interface
public @interface JsonSerializable {
}

package com.demo.annotations;

public class JsonSerializationException extends  RuntimeException{
    public JsonSerializationException(String message) {
        super(message);
    }
}

package com.demo.annotations;

import java.util.Objects;

//PROCESS THE ANNOTATIONS
public class ModelToJsonConverter {
    private void checkIfSerializable(Object object) {
        if(Objects.isNull(object)) {
            throw new JsonSerializationException("Serializing null object.");
        }
        //REFLECT UPON THE OBJECT(ACTOR) AND FIND IF IT HAS METADATA ABOUT SERIALIZATION. 
        //BY GETTING THE CLASS DURING RUNTIME TO CHECK IF IT HAS THE METADATA (JsonSerializable)
        Class<?> clazz = object.getClass();
        boolean serializable = clazz.isAnnotationPresent(JsonSerializable.class);
        if(!serializable) {
            throw new JsonSerializationException("Json Serialization not possible on " + clazz.getSimpleName() + " class. For serialization annotate the class with JsonSerializable");
        }
    }
    //to del
}
