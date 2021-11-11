package models.clothingSets.implementations;

import models.clothingSets.abstractions.IClothingSet;

public class CarClothingSet implements IClothingSet {
    private String type;
    private float price;

    public CarClothingSet(String type, float price) {
        this.type = type;
        this.price = price;
    }
    @Override
    public void setType(String type) {
        this.type = type + "Set";
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getDetails() {
        return "\nSet Type: " + type + "\nPrice: " + price;
    }
}
