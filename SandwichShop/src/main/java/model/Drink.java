package model;

public enum Drink {
    SMALL(1.50),
    MEDIUM(2.00),
    LARGE(2.50);

    private final double price;

    Drink(double price){
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

}
