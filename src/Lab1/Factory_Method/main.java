package Lab1.Factory_Method;

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
