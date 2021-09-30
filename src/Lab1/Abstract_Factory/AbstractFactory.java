package Lab1.Abstract_Factory;

import Lab1.Abstract_Factory.Clothes.Clothes;
import Lab1.Abstract_Factory.Vehicles.Bicycle;
import Lab1.Abstract_Factory.Vehicles.Vehicle;

public abstract class AbstractFactory {
    public abstract Vehicle getVehicle(String vehicle);
    public abstract Clothes getClothes(String clothes);
}
