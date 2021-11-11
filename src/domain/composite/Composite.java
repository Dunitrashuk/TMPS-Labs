package domain.composite;

import models.clothingSets.abstractions.IClothingSet;

import java.util.ArrayList;
import java.util.List;

public class Composite implements IClothingSet{
    private String type;

    private List<IClothingSet> sets;

    public Composite(String type) {
        this.type = type;
        this.sets = new ArrayList<>();
    }

    public void addClothingSet(IClothingSet set) {
        sets.add(set);
    }

    public void removeClothingSet(IClothingSet set) {
        sets.remove(set);
    }

    @Override
    public void setType(String type) {
        for (IClothingSet sets : sets) {
            sets.setType(type);
        }
    }

    @Override
    public void setPrice(float price) {
        for (IClothingSet sets : sets) {
            sets.setPrice(price);
        }
    }

    @Override
    public String getType() {
        return type;
    }
}
