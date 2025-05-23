package model;

public interface Topping {
    String getName();
    ToppingType getType();
    double getPrice(SandwichSize size);
    boolean isExtra();
}
