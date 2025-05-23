package model;

public class RegularTopping implements Topping{
    private final String name;

    public RegularTopping(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public ToppingType getType(){
        return ToppingType.REGULAR;
    }

    @Override
    public double getPrice(SandwichSize size){
        return 0.0;
    }

    @Override
    public boolean isExtra() {
        return false;
    }

}
