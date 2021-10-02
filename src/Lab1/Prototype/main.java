package Lab1.Prototype;

public class main {
    public static void main(String[] args) {
        PrototypeFactory vehicleMaker = new PrototypeFactory();

        Car car = new Car();
        Car clonedCar = (Car) vehicleMaker.getClone(car);

        System.out.println("car hashcode: " + car.hashCode());
        System.out.println("cloned car hashcode: " + clonedCar.hashCode());
    }
}
