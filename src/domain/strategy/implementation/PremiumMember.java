package domain.strategy.implementation;

import domain.strategy.abstractions.Strategy;

public class PremiumMember implements Strategy {
    @Override
    public double makeDiscount(double price) {
        //10% discount
        return price * 0.9;
    }
}
