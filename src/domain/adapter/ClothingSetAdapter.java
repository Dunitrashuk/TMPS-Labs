package domain.adapter;

import models.vehicles.abstractions.IVehicle;

public class ClothingSetAdapter implements IVehicle {

    private final IVehicle vehicle;

    public ClothingSetAdapter(IVehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String getDetails() {
        return vehicle.getDetails();
    }

    @Override
    public void setModel(String model) {}

    @Override
    public void setYear(int year) {}

    @Override
    public void setPrice(double price) {}

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getModel() {
        return null;
    }

    @Override
    public int getYear() {
        return 0;
    }
}
