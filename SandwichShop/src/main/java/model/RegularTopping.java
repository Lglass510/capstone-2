package model;

public class RegularTopping extends Topping {
    public RegularTopping(String name) {
        super(name, false, false);
    }

    public double getPrice(SandwichSize size){
        return 0.00;
    }


}
