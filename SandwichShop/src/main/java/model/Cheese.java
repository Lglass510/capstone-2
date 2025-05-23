package model;

public class Cheese implements Topping {
    private final String name;
    private final boolean isExtra;

    public Cheese(String name, boolean isExtra){
        this.name = name;
        this.isExtra = isExtra;

    }
    @Override
    public String getName(){
        return name + (isExtra ? " (extra)" : "");
    }
    @Override
    public ToppingType getType(){
        return ToppingType.CHEESE;
    }

    @Override
    public double getPrice(SandwichSize size){
        double base = switch (size){
            case FOUR -> 0.75;
            case EIGHT -> 1.50;
            case TWELVE -> 2.25;
        };
        return isExtra ? base + switch (size){
            case FOUR -> 0.30;
            case EIGHT -> 0.60;
            case TWELVE -> 0.90;
        } : base;
    }
    @Override
    public boolean isExtra(){
        return isExtra;
    }

}
