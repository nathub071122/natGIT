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
