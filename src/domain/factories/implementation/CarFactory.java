package domain.factories.implementation;

import domain.builders.implementations.HondaBuilder;
import domain.builders.implementations.MercedesBuilder;
import domain.decorator.PersonalisedInterior;
import domain.factories.abstractions.IAbstractFactory;
import models.vehicles.abstractions.IVehicle;
import models.makers.Maker;

public class CarFactory implements IAbstractFactory {
    private static CarFactory carFactory;
    private final Maker maker =  new Maker();

    public static CarFactory getCarFactory() {
        if(carFactory == null)
            carFactory = new CarFactory();
        return carFactory;
    }

    private CarFactory(){}

    public IVehicle makeVehicle(String model, boolean personalisedInterior) {
        IVehicle vehicle = null;

        if(model == null)
            return null;

        if(model.toLowerCase() == "honda") {
            HondaBuilder hondaBuilder = new HondaBuilder();
            maker.makeHonda(hondaBuilder);
            vehicle = hondaBuilder.getVehicle();
        }else if(model.toLowerCase() == "mercedes") {
            MercedesBuilder mercedesBuilder = new MercedesBuilder();
            maker.makeMercedes(mercedesBuilder);
            vehicle = mercedesBuilder.getVehicle();
        }

        if(personalisedInterior == true) vehicle = new PersonalisedInterior(vehicle);

        return vehicle;
    }
}
