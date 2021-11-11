package models.makers;

import domain.builders.implementations.*;

public class Maker {

    public void makeHonda(HondaBuilder builder) {
        builder.create();
        builder.setModel("\033[0;94m" + "Honda-CRV");
        builder.setYear(2020);
        builder.setPrice(35000);
    }

    public void makeMercedes(MercedesBuilder builder) {
        builder.create();
        builder.setModel("\033[0;94m" + "Mercedes-E200");
        builder.setYear(2018);
        builder.setPrice(28000);
    }

    public void makeDucati(DucatiBuilder builder) {
        builder.create();
        builder.setModel("\033[0;94m" + "Ducati-Monster-1200");
        builder.setYear(2019);
        builder.setPrice(15000);
    }

    public void makeKawasaki(KawasakiBuilder builder) {
        builder.create();
        builder.setModel("\033[0;94m" + "Kawasaki-Z900");
        builder.setYear(2021);
        builder.setPrice(9000);
    }

}
