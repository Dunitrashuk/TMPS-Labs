package Lab1.Builder;

public class main {
    public static void main(String[] args) {
        Vehicle car = new Vehicle.VehicleBuilder("car", 5)
                .nrWheels(4)
                .color("red")
                .build();

        Vehicle bicycle = new Vehicle.VehicleBuilder("bicycle", 1)
                .nrWheels(2)
                .build();

        System.out.println("Type: " + car.getType());
        System.out.println("Seats: " + car.getNrSeats());
        System.out.println("Wheels: " + car.getNrWheels());
        System.out.println("Color: " + car.getColor());

        System.out.println("\nType: " + bicycle.getType());
        System.out.println("Seats: " + bicycle.getNrSeats());
        System.out.println("Wheels: " + bicycle.getNrWheels());
    }
}
