package Lab1.Abstract_Factory;

import Lab1.Abstract_Factory.Clothes.Clothes;
import Lab1.Abstract_Factory.Vehicles.Vehicle;

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

