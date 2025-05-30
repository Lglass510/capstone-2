package model;

public class Drink implements SideItem{

    private final DrinkOptions options;
    private final DrinkSize size;

    public Drink(DrinkOptions options, DrinkSize size) {
        this.options = options;
        this.size = size;
    }

    @Override
    public String getName() {
        return " ";
    }

    public double getPrice() {
        return size.getPrice();
    }

    public DrinkOptions getDrinkOptions() {
        return options;
    }

    public DrinkSize getSize() {
        return size;
    }

    @Override
    public String toString() {
        return size.name().charAt(0) + size.name().substring(1).toLowerCase() + " " + options;
    }
}


