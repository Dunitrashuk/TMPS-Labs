package domain.strategy.implementation;

import domain.strategy.abstractions.Strategy;

public class VipMember implements Strategy {
    @Override
    public double makeDiscount(double price) {
        //20% discount
        return price * 0.8;
    }
}
