package models.vehicles.implementations.bikes;

import models.vehicles.abstractions.IVehicle;

public class Kawasaki implements IVehicle {
    private String model;
    private int year;
    private static double price;

    public static double givePrice() {
        return price;
    }
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

