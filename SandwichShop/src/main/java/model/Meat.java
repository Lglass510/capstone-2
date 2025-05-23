package model;

public class Meat implements Topping {
    private final String name;
    private final boolean isExtra;

    public Meat(String name, boolean isExtra){
        this.name = name;
        this.isExtra = isExtra;
    }

    @Override
    public String getName(){
        return name + (isExtra ? "(extra)" : "");
    }

    @Override
    public double getPrice(SandwichSize size){
        double base = switch (size) {
            case FOUR -> 1.00;
            case EIGHT -> 2.00;
            case TWELVE -> 3.00;
        };
        return isExtra ? base + switch (size) {
            case FOUR -> 0.50;
            case EIGHT -> 1.00;
            case TWELVE -> 1.50;
        } : base;
    }
    @Override
    public boolean isExtra(){
        return isExtra;
    }
    @Override
    public ToppingType getType(){
        return ToppingType.MEAT;
    }

}
