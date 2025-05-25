package model;

public class Drink implements SideItem{
    private final String name;
    private final double price;

    public Drink(String name, double price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getPrice(){
        return price;
    }
}
