package Lab1.Abstract_Factory.Vehicles;
import Lab1.Abstract_Factory.AbstractFactory;
import Lab1.Abstract_Factory.Clothes.Clothes;

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
