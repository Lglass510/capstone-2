package model;

public class Sauce implements SideItem {
    private final String name;

    public Sauce(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }

    public double getPrice(){
        return 0.00;
    }
}
