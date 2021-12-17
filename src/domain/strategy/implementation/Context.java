package domain.strategy.implementation;

import domain.strategy.abstractions.Strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){

        this.strategy = strategy;
    }

    public double executeStrategy (double price){

        return strategy.makeDiscount(price);
    }
}
