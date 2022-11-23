package com.demo.jdbc;
public class ActorModel {
    private int actorId;
    private String firstName;
    private String lastName;
    public int getActorId() {
        return actorId;
    }
    public void setActorId(int actorId) {
        this.actorId = actorId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public ActorModel(int actorId, String firstName, String lastName) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return   "Actor details : " + actorId + "\t" + firstName + "\t" + lastName + "\t";
    }
}
