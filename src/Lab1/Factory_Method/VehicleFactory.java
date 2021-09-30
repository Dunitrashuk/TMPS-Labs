package Lab1.Factory_Method;

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
