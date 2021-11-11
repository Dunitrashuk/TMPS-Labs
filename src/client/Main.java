package client;

import domain.adapter.ClothingSetAdapter;
import domain.composite.Composite;
import domain.factories.abstractions.IAbstractFactory;
import domain.factories.implementation.BikeFactory;
import domain.factories.implementation.CarFactory;
import models.clothingSets.abstractions.IClothingSet;
import models.clothingSets.implementations.BikeClothingSet;
import models.clothingSets.implementations.CarClothingSet;
import models.vehicles.abstractions.IVehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        label:
        while (true) {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\n---Welcome to our DealerShip!---\nWhat you would like to buy?\n-Cars \n-Bikes -Clothing Sets \nIf you want to exit type exit ");
            String type = input.readLine();
            if (type.length() == 0)
                break;

            if (type.equals("cars")) {
                System.out.println("Do you want Clothing Set? y/n");
                String type2 = input.readLine();

                if (type2.equals("n")) {
                    IAbstractFactory carFactory = CarFactory.getCarFactory();
                    System.out.println(carFactory.makeVehicle("Honda", false).getDetails());
                    System.out.println(carFactory.makeVehicle("Mercedes", false).getDetails());
                } else {
                    IAbstractFactory carFactory = CarFactory.getCarFactory();
                    System.out.println(carFactory.makeVehicle("Honda", true).getDetails());
                    System.out.println(carFactory.makeVehicle("Mercedes", true).getDetails());
                }
            } else if (type.equals("bikes")) {
                System.out.println("Do you want Clothing Set? y/n");
                String type2 = input.readLine();
                IAbstractFactory bikeFactory = BikeFactory.getBikeFactory();
                if (type2.equals("n")) {
                    System.out.println(bikeFactory.makeVehicle("Ducati", false).getDetails());
                    System.out.println(bikeFactory.makeVehicle("Kawasaki", false).getDetails());
                } else {
                    System.out.println(bikeFactory.makeVehicle("Ducati", true).getDetails());
                    System.out.println(bikeFactory.makeVehicle("Kawasaki", true).getDetails());
                }
                break;
            } else if (type.equals("clothing sets")) {

                IClothingSet carClothingSet1 = new CarClothingSet("car-amateur", 225);
                IClothingSet carClothingSet2 = new CarClothingSet("car-pro", 350);

                IClothingSet bikeClothingSet1 = new BikeClothingSet("bike-amateur", 250);
                IClothingSet bikeClothingSet2 = new BikeClothingSet("bike-pro", 300);

                Composite carSets = new Composite("CarSets");
                Composite bikeSets = new Composite("BikesSets");

                carSets.addClothingSet(carClothingSet1);
                carSets.addClothingSet(carClothingSet2);

                bikeSets.addClothingSet(bikeClothingSet1);
                bikeSets.addClothingSet(bikeClothingSet2);

                IVehicle adaptedCarSet = new ClothingSetAdapter((IVehicle) carClothingSet1);
                IVehicle adaptedBikeSet = new ClothingSetAdapter((IVehicle) bikeClothingSet1);

                System.out.println(adaptedCarSet.getDetails());
                System.out.println(adaptedBikeSet.getDetails());

            } else if (type.equals("exit"))
                break label;
            else {
                System.out.println("We don't have these type of vehicles");
                break;
            }

        }
    }
}
