package domain.builders.implementations;

import domain.builders.abstractions.IVehicleBuilder;
import models.vehicles.implementations.cars.Mercedes;

public class MercedesBuilder implements IVehicleBuilder {
    private Mercedes mercedes;

    public MercedesBuilder() {
        this.create();
    }

    public void create() {
        this.mercedes = new Mercedes();
    }

    @Override
    public void setModel(String model) {
        this.mercedes.setModel(model);
    }

    @Override
    public void setYear(int year) {
        this.mercedes.setYear(year);
    }

    @Override
    public void setPrice(double price) {
        this.mercedes.setPrice(price);
    }

    public Mercedes getVehicle() {
        Mercedes mercedes = this.mercedes;
        this.create();
        return mercedes;
    }
}
