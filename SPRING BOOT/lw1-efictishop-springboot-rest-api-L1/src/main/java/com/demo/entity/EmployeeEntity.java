package com.demo.entity;
import javax.persistence.*;
//Employee Entity that will be persisted in the database using the Hibernate ORM Framework
@Entity(name = "EMPLOYEES")
public class EmployeeEntity {
    //    SET UP PRIMARY KEY FOR UNIQUENESS
    @Id
//    AUTO GENERATE ID
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID")
    private int id;
    @Column(name = "firstName", nullable = false)
    private String name;
    private int salary;
    public EmployeeEntity() {
    }
    public EmployeeEntity(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
