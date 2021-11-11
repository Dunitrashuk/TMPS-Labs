package domain.builders.implementations;

import domain.builders.abstractions.IVehicleBuilder;
import models.vehicles.implementations.cars.Honda;

public class HondaBuilder implements IVehicleBuilder {

    private Honda honda;

    public HondaBuilder() {
        this.create();
    }

    public void create() {
        this.honda = new Honda();
    }

    @Override
    public void setModel(String model) {
        this.honda.setModel(model);
    }

    @Override
    public void setYear(int year) {
        this.honda.setYear(year);
    }

    @Override
    public void setPrice(double price) {
        this.honda.setPrice(price);
    }

    public Honda getVehicle() {
        Honda honda = this.honda;
        this.create();
        return honda;
    }

}
