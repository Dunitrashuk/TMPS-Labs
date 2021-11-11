package domain.builders.implementations;

import domain.builders.abstractions.IVehicleBuilder;
import models.vehicles.implementations.bikes.Ducati;

public class DucatiBuilder implements IVehicleBuilder {

    private Ducati ducati;

    public DucatiBuilder() {
        this.create();
    }

    public void create() {
        this.ducati = new Ducati();
    }

    @Override
    public void setModel(String model) {
        this.ducati.setModel(model);
    }

    @Override
    public void setYear(int year) {
        this.ducati.setYear(year);
    }

    @Override
    public void setPrice(double price) {
        this.ducati.setPrice(price);
    }

    public Ducati getVehicle() {
        Ducati ducati = this.ducati;
        this.create();
        return ducati;
    }
}
