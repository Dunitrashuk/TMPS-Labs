package domain.factories.abstractions;

import models.vehicles.abstractions.IVehicle;

public interface IAbstractFactory {
    IVehicle makeVehicle(String model, boolean clothingSet);
}
