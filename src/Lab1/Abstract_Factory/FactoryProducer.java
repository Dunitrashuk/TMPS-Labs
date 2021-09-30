package Lab1.Abstract_Factory;
import Lab1.Abstract_Factory.Clothes.ClothesFactory;
import Lab1.Abstract_Factory.Vehicles.VehicleFactory;

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
