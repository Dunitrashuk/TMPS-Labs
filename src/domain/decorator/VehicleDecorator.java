package domain.decorator;

import models.vehicles.abstractions.IVehicle;

public abstract class VehicleDecorator implements IVehicle {

    private IVehicle vehicle;

    public VehicleDecorator(IVehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void setModel(String model) {
        vehicle.setModel(model);
    }

    @Override
    public void setYear(int year) {
        vehicle.setYear(year);
    }

    @Override
    public void setPrice(double price) {
        vehicle.setPrice(price);
    }

    @Override
    public double getPrice() {
        return vehicle.getPrice();
    }

    @Override
    public String getModel() {
        return vehicle.getModel();
    }

    @Override
    public int getYear() {
        return vehicle.getYear();
    }

    @Override
    public String getDetails() { return vehicle.getDetails(); }
}
