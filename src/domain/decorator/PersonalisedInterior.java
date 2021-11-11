package domain.decorator;

import models.vehicles.abstractions.IVehicle;

public class PersonalisedInterior extends VehicleDecorator{

    public PersonalisedInterior(IVehicle vehicle) {
        super(vehicle);
    }

    public String setInterior() {
            return ("Personalised Interior included with Vehicle");
    }

    @Override
    public String getDetails() {
        return super.getDetails();
    }

    @Override
    public void setModel(String model) {
        super.setModel(model);
    }

    @Override
    public void setYear(int year) {
        super.setYear(year);
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 5000;
    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public int getYear() {
        return super.getYear();
    }

}
