package Lab1.Abstract_Factory.Clothes;
import Lab1.Abstract_Factory.AbstractFactory;
import Lab1.Abstract_Factory.Vehicles.Bicycle;
import Lab1.Abstract_Factory.Vehicles.Vehicle;

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
