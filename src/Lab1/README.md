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

And now we need to create our Factory method. As we can see here we are creating different type of vehicles based on the parameter passed to the function **createVehicle();**

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
### 2. Abstract Factory

The Abstract Factory design pattern builds upon the Factory Pattern and acts as the highest factory in the hierarchy. It represents the practice of creating a factory of factories.

This pattern is responsible for creating all other factories as its sub-classes, exactly like how factories are responsible for creating all of their own sub-classes.

So let's say our business expanded and wants to make clothes for different kind of vehicles. So we will have clothes for cars for motor-bikes and bicycles.

This way we will be able to implement our Abstract Factory after we are applying Factory Method to our new Factory for clothes.

We create a new class Clothes:
```java
public class Clothes {
    public void getType(){}
}
```
And as usual, a few concrete classes inherit from it:
```java
public class BicycleClothes extends Clothes {
    @Override
    public void getType() {
        System.out.println("Bicycle-Clothes");
    }
}

public class BicycleClothes extends Clothes {
    @Override
    public void getType() {
        System.out.println("Bicycle-Clothes");
    }
}

public class MotorBikeClothes extends Clothes {
    @Override
    public void getType() {
        System.out.println("MotorBike-Clothes");
    }
}
```
At this point, we have everything to create an *AbstractFactory* as well as the respective Factory classes for these two groups: **VehicleFactory** and **ClothesFactory**.

The AbstractFactory's concern is the ability to provide these objects to the FactoryProducer, not to instantiate them:

```java
public abstract class AbstractFactory {
    public abstract Vehicle getVehicle(String vehicle);
    public abstract Clothes getClothes(String clothes);
}
```

Before we define the class that instantiates these objects using the AbstractFactory, we need to create our two factories.
```java
public class ClothesFactory extends AbstractFactory {
    @Override
    public Clothes getClothes(String type){
        if (type == null || type.isEmpty())
            return null;
        if ("CarClothes".equals(type))
            return new CarClothes();
        else if ("MotorBikeClothes".equals(type))
            return new MotorBikeClothes();
        else if ("BicycleClothes".equals(type))
            return new BicycleClothes();
        return null;
    }

    @Override
    public Vehicle getVehicle(String vehicle) {
        return null;
    }
}
```

```java
public class VehicleFactory extends AbstractFactory {
    @Override
    public Vehicle getVehicle(String type){
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

    @Override
    public Clothes getClothes(String clothes) {
        return null;
    }
}
```
And now, with these, we can create the FactoryProducer which is responsible to instantiate the adequate factories, with the help of the AbstractFactory:

```java
public class FactoryProducer {
    public static AbstractFactory getFactory(String factory) {
        if(factory.equalsIgnoreCase("Vehicle")) {
            return new VehicleFactory();
        } else if(factory.equalsIgnoreCase("Clothes")) {
            return new ClothesFactory();
        }
        return null;
    }
}
```
By passing a String, the FactoryProducer returns the AbstractFactory with their requested child factory.

Here is the main program:
```java
public class main {
    public static void main(String[] args) {

        AbstractFactory vehicleFactory = FactoryProducer.getFactory("Vehicle");
        AbstractFactory clothesFactory = FactoryProducer.getFactory("Clothes");

        Vehicle car = vehicleFactory.getVehicle("Car");
        car.getType();

        Clothes carClothes = clothesFactory.getClothes("CarClothes");
        carClothes.getType();

        Vehicle bicycle = vehicleFactory.getVehicle("Bicycle");
        bicycle.getType();

        Clothes bicycleClothes = clothesFactory.getClothes("BicycleClothes");
        bicycleClothes.getType();
    }
}
```
The output will be:
```
Car
Car-Clothes
Bicycle
Bicycle-Clothes
```
## Conclusion