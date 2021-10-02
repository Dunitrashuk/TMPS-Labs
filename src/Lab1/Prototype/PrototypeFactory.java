package Lab1.Prototype;

public class PrototypeFactory {
    public Vehicle getClone(Vehicle vehicle) {
        return vehicle.makeCopy();
    }
}
