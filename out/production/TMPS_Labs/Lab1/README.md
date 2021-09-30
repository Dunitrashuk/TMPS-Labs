# Topic: Creational Design Patterns

##### Author: Mamaliga Dumitras

## Introduction/Theory

In software engineering, the creational design patterns are the general solutions that deal with object creation, trying to create objects in a manner suitable to the situation. The basic form of object creation could result in design problems or added complexity to the design. Creational design patterns solve this problem by optimizing, hiding or controlling the object creation.

Some examples of this kind of design patterns are:

* Singleton
* Builder
* Prototype
* Object Pooling
* Factory Method
* Abstract Factory

## Implementation & Explanation

For this laboratory work I chose the domain area of vehicles. For this laboratory work I will use the Java Programming Language.

So, lets say we are a business that produces different kind of vehicles for some clients. As for simplicity I will use only 3 types of vehicles: Cars, Motor-Bikes and Bicycles. 

So we will have 3 main classes representing each vehicle. Now let's see how we can diversify the creation of this vehicles using some CDP.


### 1. Factory Method
I will start with Factory Method. 

Firstly first we need to create our main vehicle classes which are Car, Motor-Bike, and Bicycle.
Because all this classes are from a similar domain we can wrap them into a more generic class named "Vehicle" and inherit from it.

```java
public class Vehicle {

    public void getType(){}
}
```
_____
```java
public class Car extends Vehicle{

    @Override
    public void getType() {
        System.out.println("Car");
    }
}
```
```java
public class MotorBike extends Vehicle{

    @Override
    public void getType() {
        System.out.println("MotorBike");
    }
}
```

```java
public class Bicycle extends Vehicle{

    @Override
    public void getType() {
        System.out.println("Bicycle");
    }
}
```
_____________

And now we need to create our Factory method. As we can see here we are creating different type of vehicles based on the parameter pased to the function **createVehicle();**

```java
public class VehicleFactory {
    public Vehicle createVehicle(String type){
        if (type == null || type.isEmpty())
            return null;
        if ("Car".equals(type))
            return new Car();
        else if ("MotorBike".equals(type))
            return new MotorBike();
        else if ("Bicycle".equals(type))
            return new Bicycle();
        return null;
    }
}
```
And this is the main function where we create our factory and use it to create different kind of vehicles based on the parameter passed.
```java
public class main {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();

        Vehicle car = vehicleFactory.createVehicle("Car");
        Vehicle motorBike = vehicleFactory.createVehicle("MotorBike");
        Vehicle bicycle = vehicleFactory.createVehicle("Bicycle");

        car.getType();
        motorBike.getType();
        bicycle.getType();
    }
}
```
And the output will be:
```
Car
MotorBike
Bicycle
```
### 2. Factory Method

## Conclusion
