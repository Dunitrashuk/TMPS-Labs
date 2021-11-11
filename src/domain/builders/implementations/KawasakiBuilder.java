package domain.builders.implementations;

import domain.builders.abstractions.IVehicleBuilder;
import models.vehicles.implementations.bikes.Kawasaki;

public class KawasakiBuilder implements IVehicleBuilder {
    private Kawasaki kawasaki;

    public KawasakiBuilder() {
        this.create();
    }

    public void create() {
        this.kawasaki = new Kawasaki();
    }

    @Override
    public void setModel(String model) {
        this.kawasaki.setModel(model);
    }

    @Override
    public void setYear(int year) {
        this.kawasaki.setYear(year);
    }

    @Override
    public void setPrice(double price) {
        this.kawasaki.setPrice(price);
    }

    public Kawasaki getVehicle() {
        Kawasaki kawasaki = this.kawasaki;
        this.create();
        return kawasaki;
    }
}
