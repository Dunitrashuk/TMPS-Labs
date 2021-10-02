package Lab1.Prototype;

import Lab1.Prototype.Vehicle;

public class Car implements Vehicle {

    public Vehicle makeCopy() {
        Car carObj = null;

        try {
            carObj = (Car) super.clone();
        }

        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return carObj;
    }

    @Override
    public void getType() {
        System.out.println("Car");
    }
}
