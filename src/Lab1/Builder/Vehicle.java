package Lab1.Builder;

public class Vehicle {

    private String type;
    private int nrSeats;
    private int nrWheels;
    private String color;

    private Vehicle(VehicleBuilder builder) {
        this.type = builder.type;
        this.nrSeats = builder.nrSeats;
        this.nrWheels = builder.nrWheels;
        this.color = builder.color;
    }

    public static class VehicleBuilder {
        private String type;
        private int nrSeats;
        private int nrWheels;
        private String color;

        public VehicleBuilder(String type, int nrSeats) {
            this.type = type;
            this.nrSeats = nrSeats;
        }

        public VehicleBuilder nrWheels(int nrWheels) {
            this.nrWheels = nrWheels;
            return this;
        }

        public VehicleBuilder color(String color) {
            this.color = color;
            return this;
        }

        public Vehicle build() {
            Vehicle vehicle = new Vehicle(this);
            vehicle.type = this.type;
            vehicle.nrSeats = this.nrSeats;
            vehicle.nrWheels = this.nrWheels;
            vehicle.color = this.color;
            return vehicle;
        }
    }
    //getters
    public String getType() {
        return type;
    }

    public int getNrSeats() {
        return nrSeats;
    }

    public int getNrWheels() {
        return nrWheels;
    }

    public String getColor() {
        return color;
    }
}



