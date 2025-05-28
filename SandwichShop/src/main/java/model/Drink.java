package model;

public class Drink {

    private final DrinkType type;
    private final DrinkSize size;

    public Drink(DrinkType type, DrinkSize size) {
        this.type = type;
        this.size = size;
    }

    public double getPrice() {
        return size.getPrice();
    }

    public DrinkType getType() {
        return type;
    }

    public DrinkSize getSize() {
        return size;
    }

    @Override
    public String toString() {
        return size.name().charAt(0) + size.name().substring(1).toLowerCase() + " " + type;
    }
}


