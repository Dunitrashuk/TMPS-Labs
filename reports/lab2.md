# Structural Design Patterns


## Author: Mamaliga Dumitras

----

## Objectives

* Study and understand the Structural Design Patterns.
* Determine the additional functionalities of the system;
* Implement at least 3 SDPs for the specific domain;
* Keep the files grouped (into packages/directories) by their responsibilities

## Theory

In software engineering, the *structural patterns* explain how to assemble objects and classes into larger structures while keeping these structures flexible and efficient.
Some examples of this kind of design patterns are:
* ***Adapter*** - Allows objects with incompatible interfaces to collaborate;
* ***Bridge*** - Lets you split a large class, or a set of closely related classes into two separate hierarchies—abstraction and implementation—which can be developed independently of each other;
* ***Composite*** - Lets you compose objects into tree structures and then work with these structures as if they were individual objects;
* ***Decorator*** - Lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors;
* ***Facade*** - Wraps a complex sub-system with a simple abstraction.
* ***Proxy*** - Lets you provide a substitute or placeholder for another object. A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object;
* ***Flyweight*** - Lets you fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all the data in each object.

## Used Design Patterns:

* Decorator
* Composite
* Adapter

## Implementation & Explanation

I implemented a dealership where you can buy cars or bikes (vehicles). From my previous lab work I used the Builder and Abstract Factory Creational Design Patterns.
First SDP that I implemented is Decorator.

### 1. Decorator

This Design Pattern allowed me to add some functionality to my objects ex(cars and bikes implementing Vehicle). I used it as a wrapper for Vehicles. In the beginning I created an abstract decorator class ```VehicleDecorator``` that implements the ```IVehicle``` interface.

```java
public abstract class VehicleDecorator implements IVehicle {

    private IVehicle vehicle;

    public VehicleDecorator(IVehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void setModel(String model) {
        vehicle.setModel(model);
    }

    @Override
    public void setYear(int year) {
        vehicle.setYear(year);
    }

    @Override
    public void setPrice(double price) {
        vehicle.setPrice(price);
    }

    @Override
    public double getPrice() {
        return vehicle.getPrice();
    }

    @Override
    public String getModel() {
        return vehicle.getModel();
    }

    @Override
    public int getYear() {
        return vehicle.getYear();
    }

    @Override
    public String getDetails() { return vehicle.getDetails(); }
}
```
After that I created a decorator class ```PersonalisedInterior```. This class allows me to add a personalised interior to the car or bike the user wants to buy for some additional money.

```java
public class PersonalisedInterior extends VehicleDecorator{

    public PersonalisedInterior(IVehicle vehicle) {
        super(vehicle);
    }

    public String setInterior() {
        return ("Personalised Interior included with Vehicle");
    }

    @Override
    public String getDetails() {
        return super.getDetails();
    }

    @Override
    public void setModel(String model) {
        super.setModel(model);
    }

    @Override
    public void setYear(int year) {
        super.setYear(year);
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 5000;
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public int getYear() {
        return super.getYear();
    }

}
```
### 2. Composite
I decided to create Clothing Sets for each vehicle. I created the ```BikeClothingSet``` and ```CarClothingSet``` which implements the interface ```IClothingSet```
```java
public interface IClothingSet {
void setType(String type);
void setPrice(float price);
String getType();
}
```

```java
public class BikeClothingSet implements IClothingSet {
    private String type;
    private float price;

    public BikeClothingSet(String type, float price) {
        this.type = type;
        this.price = price;
    }
    @Override
    public void setType(String type) {
        this.type = type + "Set";
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getDetails() {
        return "\nSet Type: " + type + "\nPrice: " + price;
    }
}
```
The ```CarClothingSet``` is almost identical.

The composite pattern creates a class that contains group of its own objects.
In my case, I created the ```Composite``` class, which was used to group different types of clothing sets. But it can be used also to group the vehicles.

```java
public class Composite implements IClothingSet{
    private String type;
    private List<IClothingSet> sets;

    public Composite(String type) {
        this.type = type;
        this.sets = new ArrayList<>();
    }

    public void addClothingSet(IClothingSet set) {
        sets.add(set);
    }

    public void removeClothingSet(IClothingSet set) {
        sets.remove(set);
    }

    @Override
    public void setType(String type) {
        for (IClothingSet sets : sets) {
            sets.setType(type);
        }
    }

    @Override
    public void setPrice(float price) {
        for (IClothingSet sets : sets) {
            sets.setPrice(price);
        }
    }

    @Override
    public String getType() {
        return type;
    }
}
```
Using this it will be easier to add different clothing sets that will appear in the future using ```addClothingSet``` and ```removeClothingSet```.
Here is the portion from main() where I used ```Composite```.

```java
IClothingSet carClothingSet1 = new CarClothingSet("car-amateur", 225);
IClothingSet carClothingSet2 = new CarClothingSet("car-pro", 350);

IClothingSet bikeClothingSet1 = new BikeClothingSet("bike-amateur", 250);
IClothingSet bikeClothingSet2 = new BikeClothingSet("bike-pro", 300);

Composite carSets = new Composite("CarSets");
Composite bikeSets = new Composite("BikesSets");

carSets.addClothingSet(carClothingSet1);
carSets.addClothingSet(carClothingSet2);

bikeSets.addClothingSet(bikeClothingSet1);
bikeSets.addClothingSet(bikeClothingSet2);
```
### 3. Adapter
The Adapter gave me the possibility to make a connection between objects with a different interface. In my case, between ```IVehicle``` and ```IClothingSet```. I created a class ```ClothingSetAdapter``` which implements IVehicle an incompatible class, and it will be used to adapt clothing sets.
```java
public class ClothingSetAdapter implements IVehicle {

    private final IVehicle vehicle;

    public ClothingSetAdapter(IVehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String getDetails() {
        return vehicle.getDetails();
    }

    @Override
    public void setModel(String model) {}

    @Override
    public void setYear(int year) {}

    @Override
    public void setPrice(double price) {}

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getModel() {
        return null;
    }

    @Override
    public int getYear() {
        return 0;
    }
}
```
```java
IVehicle adaptedCarSet = new ClothingSetAdapter((IVehicle) carClothingSet1);
IVehicle adaptedBikeSet = new ClothingSetAdapter((IVehicle) bikeClothingSet1);

System.out.println(adaptedCarSet.getDetails());
System.out.println(adaptedBikeSet.getDetails());
```
## Output
```
--Welcome to our DealerShip!--
What you would like to buy?
-Cars 
-Bikes 
-Clothing Sets 
If you want to exit type exit 
cars
Do you want Personalised Interior for an extra of 5000$ ? y/n
n

Model: Honda-CRV
Year: 2020
Price: 35000 $


Model: Mercedes-E200
Year: 2018
Price: 28000 $
```
```
--Welcome to our DealerShip!--
What you would like to buy?
-Cars 
-Bikes 
-Clothing Sets 
If you want to exit type exit 
cars
Do you want Personalised Interior for an extra of 5000$ ? y/n
y

Model: Honda-CRV
Year: 2020
Personalised Interior included with Vehicle
Price: 40000 $


Model: Mercedes-E200
Year: 2018
Personalised Interior included with Vehicle
Price: 33000 $
```

```
--Welcome to our DealerShip!--
What you would like to buy?
-Cars 
-Bikes 
-Clothing Sets 
If you want to exit type exit 
bikes
Do you want Personalised Interior for an extra of 5000$ ? y/n
n

Model: Ducati-Monster-1200
Year: 2019
Price: 15000 $


Model: Kawasaki-Z900
Year: 2021
Price: 9000 $
```

```
--Welcome to our DealerShip!--
What you would like to buy?
-Cars 
-Bikes 
-Clothing Sets 
If you want to exit type exit 
clothing sets

Set Type: car-amateur
Price: 225 $

Set Type: car-pro
Price: 350 $

Set Type: bike-amateur
Price: 250 $

Set Type: bike-amateur
Price: 300 $
```

## Conclusions

In this laboratory work I implemented some Structural Design Patterns. In this laboratory work I extended my project from the last laboratory and I improved my skills on design patterns. Also I tried to organize my project better using more directories and structuring my files based on functionality.