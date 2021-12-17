# Behavioral Design Patterns


## Author: Mamaliga Dumitras

----

## Objectives:

* Study and understand the Behavioral Design Patterns.
* Determine the additional functionalities of the system;
* Implement at least 1 BDPs for the specific domain;
* Keep the files grouped (into packages/directories) by their responsibilities

## Theory:

*Behavioral design patterns* are concerned with the interaction and responsibility of objects.

In these design patterns, the interaction between the objects should be in such a way that they can easily talk to each other and still should be loosely coupled.Some examples of this kind of design patterns are:
* ***Chain of Responsibility*** - Lets you pass requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain;
* ***Command*** - Turns a request into a stand-alone object that contains all information about the request. This transformation lets you parameterize methods with different requests, delay or queue a request's execution, and support undoable operations;
* ***Iterator*** -  Lets you traverse elements of a collection without exposing its underlying representation (list, stack, tree, etc.);
* ***Mediator*** - Lets you reduce chaotic dependencies between objects. The pattern restricts direct communications between the objects and forces them to collaborate only via a mediator object;
* ***Memento*** - Lets you save and restore the previous state of an object without revealing the details of its implementation;
* ***Observer*** - Lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they're observing;
* ***State*** -  Lets an object alter its behavior when its internal state changes. It appears as if the object changed its class;
* ***Strategy*** - Lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable;
* ***Template Method*** - Defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure;
* ***Visitor*** - Lets you separate algorithms from the objects on which they operate.

## Used Design Pattern:

* Strategy

## Implementation

* **Strategy**
  The strategy that I used in my laboratory work is a hierarchy of users. I added the possibility to have two types of users: Premium Members and VIP Members. In case that a user is a Premium Member a discount of 10% will be applied, but in case a user is a VIP Member a discount of 20% will be applied.

Firstly, for this design pattern, I have created an *interface* named ```Strategy```.

```java
public interface Strategy {
    double doDiscount (double price);
}

```
Then, I created the concrete classes ```PremiumMember```  and ```VipMember``` which implements the same ```Strategy``` interface. These classes are applying the discount of 10% and 20% to the items.
```java
public class PremiumMember implements Strategy {
  @Override
  public double makeDiscount(double price) {
    //10% discount
    return price * 0.9;
  }
}
```
```java
public class VipMember implements Strategy {
  @Override
  public double makeDiscount(double price) {
    //20% discount
    return price * 0.8;
  }
}
```

After this, I created ***Context*** Class, which will be used in ```Main.java``` to change the strategy.
```java
public class Context {
  private Strategy strategy;

  public Context(Strategy strategy){

    this.strategy = strategy;
  }

  public double executeStrategy (double price){

    return strategy.makeDiscount(price);
  }
}
```

## Output
Here you can see the output for different cases:
* Cars without personalised interior for Premium Members:
```
--Welcome to our DealerShip!--
What you would like to buy?
-Cars 
-Bikes 
-Clothing Sets 
If you want to exit type exit 
cars
Are you a Premium Member? y/n
y
Do you want Personalised Interior for an extra of 5000$ ? y/n
n

Model: Honda-CRV
Year: 2020
Price: 35000 $

Model: Mercedes-E200
Year: 2018
Price: 28000 $

Prices for Premium Members:
Honda: 31500 $
Mercedes: 25200 $
```
* Cars without personalised interior for VIP Members:
```
--Welcome to our DealerShip!--
What you would like to buy?
-Cars 
-Bikes 
-Clothing Sets 
If you want to exit type exit 
cars
Are you a Premium Member? y/n
n
Do you want Personalised Interior for an extra of 5000$ ? y/n
n

Model: Honda-CRV
Year: 2020
Price: 35000 $

Model: Mercedes-E200
Year: 2018
Price: 28000 $

Maybe you are a VIP Member? y/n
y
Prices for VIP Members:
Honda: 28000 $
Mercedes: 22400 $
```

* Cars with personalised interior for VIP Members:
```
--Welcome to our DealerShip!--
What you would like to buy?
-Cars 
-Bikes 
-Clothing Sets 
If you want to exit type exit 
cars
Are you a Premium Member? y/n
n
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

Maybe you are a VIP Member? y/n
y
Prices for VIP Members:
Honda: 32000 $
Mercedes: 26400 $
```

* Bikes without personalised interior for Premium Members:
```
--Welcome to our DealerShip!--
What you would like to buy?
-Cars 
-Bikes 
-Clothing Sets 
If you want to exit type exit 
bikes
Are you a Premium Member? y/n
y
Do you want Personalised Interior for an extra of 5000$ ? y/n
n

Model: Ducati-Monster-1200
Year: 2019
Price: 15000 $

Model: Kawasaki-Z900
Year: 2021
Price: 9000 $

Prices for Premium Members:
Ducati: 13500 $
Kawasaki: 8100 $
```
## Conclusions
In this laboratory work I implemented a Behavioral Design Pattern, specifically the Strategy Pattern. In short,
I consider that I learned a lot about design patterns in this whole semester. Behavioral design patterns are design patterns that identify common communication patterns between objects and realize them.
By doing so, these patterns increase flexibility in carrying out this communication.