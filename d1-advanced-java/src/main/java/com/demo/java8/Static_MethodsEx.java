package com.demo.java8;
//Printer
public class Static_MethodsEx {
    public static void main(String[] args) {
//        Vehicle ferrari = new Car("Ferrari",false);
//        System.out.println(ferrari.getDetails());
//        Vehicle tesla = new Car("Tesla",true);
//        System.out.println(tesla.getDetails());

//        Vehicle ferrari = new PetrolCar("Ferrari");
//        System.out.println(ferrari.getDetails());
//        Vehicle tesla = new ElectricCar("Tesla");
//        System.out.println(tesla.getDetails());

//        Vehicle ferrari = new PetrolCar("Ferrari");
//        System.out.println(ferrari.getDetails());
//        System.out.println(ferrari.getHorsePower(1000,450));
//        Vehicle tesla = new ElectricCar("Tesla");
//        System.out.println(tesla.getDetails());
//        System.out.println(tesla.getHorsePower(900,400));

        Vehicle ferrari = new PetrolCar("Ferrari");
        System.out.println(ferrari.getDetails());
        System.out.println(Vehicle.getHorsePower(1000,450));
        Vehicle tesla = new ElectricCar("Tesla");
        System.out.println(tesla.getDetails());
        System.out.println(Vehicle.getHorsePower(900,400));
        Vehicle truck = new Truck("BMW");
        System.out.println(truck.getDetails());
        System.out.println(Vehicle.getHorsePower(500,300));
        truck = new Truck("BMW");
        System.out.println(truck.getDetails());
        System.out.println(Vehicle.getHorsePower(500,300));
//        this' cannot be referenced from a static context
//        this refers to the current object.
//       static methods belong to the class and not any inistance
//        System.out.println(this);
    }
}

interface Vehicle {
//    methods in interfaces are abstract and public by default
//    public abstract String getBrand();
//    details change for different implementations.
    String getDetails();
//    IP (Thinking hat) think about horse power, is it dependent on the vehicle,
//    if not dependent where can we define the body.
//    int getHorsePower(int rpm, int torque);
//add new behavior to old interfaces without braking the previously implemented classes
    public static int getHorsePower(int rpm, int torque) {
    return (rpm * torque) / 5232;
}
}

//class Car implements Vehicle {
//    public String brand;
//    public boolean electric;
//    public Car(String brand, boolean electric) {
//        this.brand = brand;
//        this.electric = electric;
//    }
//    @Override
//    public String getDetails() {
//        // different logic for different vehicle types.....
//        String details = "";
//        if(electric) {
//            details = " is an electric car";
//        }
//        else
//        {
//            details = " is not an electic car";
//        }
//        return "The card brand " + brand + details;
//    }
//}

class ElectricCar implements Vehicle {
    public String brand;
    public boolean electric;
    public ElectricCar(String brand) {
        this.brand = brand;
    }
    @Override
    public String getDetails() {
        return "The vehicle brand " + brand + " is an electric car";
    }

//    @Override
//    public int getHorsePower(int rpm, int torque) {
//         return (rpm * torque) / 5232;
//    }
}

class PetrolCar implements Vehicle {
    public String brand;
    public boolean electric;
    public PetrolCar(String brand) {
        this.brand = brand;
    }
    @Override
    public String getDetails() {
        return "The card brand " + brand + " is a petrol car";
    }

//    static methods cannot be overridden
//    @Override
//    public int getHorsePower(int rpm, int torque) {
//        return (rpm * torque) / 5232;
//    }
}

class Truck implements Vehicle {
    public String brand;
    public boolean electric;
    public Truck(String brand) {
        this.brand = brand;
    }
    @Override
    public String getDetails() {
        System.out.println(this);
        return "The card brand " + brand + " is a petrol car";

    }

//    @Override
//    public int getHorsePower(int rpm, int torque) {
//        return (rpm * torque) / 5232;
//    }
}