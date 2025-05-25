package model;

public class Chips implements SideItem {
    private final String name;
    private final double chipPrice;

    public Chips(String name, double chipPrice){
        this.name = name;
        this.chipPrice = chipPrice;

    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getPrice() {
        return chipPrice;
    }
}
