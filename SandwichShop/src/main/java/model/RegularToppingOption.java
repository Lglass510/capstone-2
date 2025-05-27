package model;

public enum RegularToppingOption implements Topping {
    LETTUCE,
    PEPPERS,
    ONION,
    TOMATOES,
    JALAPENOS,
    CUCUMBERS,
    PICKLES,
    GUACAMOLE,
    MUSHROOMS;

    @Override
    public double getPrice(SandwichSize size, boolean extra){
        return 0.0;
    }
    @Override
    public String toString(){
        String formatted = name().charAt(0) + name().substring(1).toLowerCase().replace("_", "");
        return formatted;
    }



}
