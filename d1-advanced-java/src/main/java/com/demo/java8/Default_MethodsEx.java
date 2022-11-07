package com.demo.java8;
//Printer
public class Default_MethodsEx {
    public static void main(String[] args) {
//        Vehicle1 ferrari = new Car("Ferrari",false);
//        System.out.println(ferrari.getDetails());
//        Vehicle1 tesla = new Car("Tesla",true);
//        System.out.println(tesla.getDetails());

//        Vehicle1 ferrari = new PetrolCar1("Ferrari");
//        System.out.println(ferrari.getDetails());
//        Vehicle1 tesla = new ElectricCar1("Tesla");
//        System.out.println(tesla.getDetails());

//        Vehicle1 ferrari = new PetrolCar1("Ferrari");
//        System.out.println(ferrari.getDetails());
//        System.out.println(ferrari.getHorsePower(1000,450));
//        Vehicle1 tesla = new ElectricCar1("Tesla");
//        System.out.println(tesla.getDetails());
//        System.out.println(tesla.getHorsePower(900,400));

        Vehicle1 ferrari = new PetrolCar1("Ferrari");
        System.out.println(ferrari.getDetails());
        ferrari.tax();
        System.out.println(Vehicle1.getHorsePower(1000,450));
        Vehicle1 tesla = new ElectricCar1("Tesla");
        System.out.println(tesla.getDetails());
        tesla.tax();
        System.out.println(Vehicle1.getHorsePower(900,400));
        Vehicle1 truck = new Truck1("BMW");
        System.out.println(truck.getDetails());
        System.out.println(Vehicle1.getHorsePower(500,300));
        truck.tax();
        truck = new Truck1("BMW");
        System.out.println(truck.getDetails());
        System.out.println(Vehicle1.getHorsePower(500,300));
//        this' cannot be referenced from a static context
//        this refers to the current object.
//       static methods belong to the class and not any inistance
//        System.out.println(this);
    }
}

interface Vehicle1 {
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

//introducing new functionality without breakign existing implementation
 public default void tax() {
     System.out.println("100 dollars / year!");
 }
// can override them
}

//class Car implements Vehicle1 {
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

class ElectricCar1 implements Vehicle1 {
    public String brand;
    public boolean electric;
    public ElectricCar1(String brand) {
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

    public  void tax() {
        System.out.println("50 dollars / year!");
    }
}

class PetrolCar1 implements Vehicle1 {
    public String brand;
    public boolean electric;
    public PetrolCar1(String brand) {
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

class Truck1 implements Vehicle1 {
    public String brand;
    public boolean electric;
    public Truck1(String brand) {
        this.brand = brand;
    }
    @Override
    public String getDetails() {
        System.out.println(this);
        return "The truck brand " + brand + " is a petrol truck";

    }

//    @Override
//    public int getHorsePower(int rpm, int torque) {
//        return (rpm * torque) / 5232;
//    }
@Override
    public void tax() {
        System.out.println("200 dollars / year!");
    }
}