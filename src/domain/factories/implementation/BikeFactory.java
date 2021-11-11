package domain.factories.implementation;

import domain.builders.implementations.DucatiBuilder;
import domain.builders.implementations.KawasakiBuilder;
import domain.decorator.PersonalisedInterior;
import domain.factories.abstractions.IAbstractFactory;
import models.vehicles.abstractions.IVehicle;
import models.makers.Maker;

public class BikeFactory implements IAbstractFactory {
    private static BikeFactory bikeFactory;
    private final Maker maker =  new Maker();
    public static BikeFactory getBikeFactory() {
        if(bikeFactory == null)
            bikeFactory = new BikeFactory();
        return bikeFactory;
    }

    private BikeFactory(){}

    public IVehicle makeVehicle(String model, boolean personalisedInterior) {
        IVehicle vehicle = null;

        if(model == null) return null;

        if(model.toLowerCase() == "ducati") {
            DucatiBuilder ducatiBuilder = new DucatiBuilder();
            maker.makeDucati(ducatiBuilder);
            vehicle = ducatiBuilder.getVehicle();
        }else if(model.toLowerCase() == "kawasaki") {
            KawasakiBuilder kawasakiBuilder = new KawasakiBuilder();
            maker.makeKawasaki(kawasakiBuilder);
            vehicle = kawasakiBuilder.getVehicle();
        }

        if(personalisedInterior == true) vehicle = new PersonalisedInterior(vehicle);

        return vehicle;
    }
}
