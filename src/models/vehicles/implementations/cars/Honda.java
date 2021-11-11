package models.vehicles.implementations.cars;

import models.vehicles.abstractions.IVehicle;

public class Honda implements IVehicle {
    private String model;
    private int year;
    private double price;

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getDetails(){
        return "\nModel:" + model + "\nYear: " + year + "\nPrice: " + price + "$\n";
    }

}

