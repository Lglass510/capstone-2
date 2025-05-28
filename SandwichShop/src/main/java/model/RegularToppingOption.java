package model;

public enum RegularToppingOption implements Topping {
    LETTUCE("Lettuce"),
    PEPPERS("Peppers"),
    ONION("Onion"),
    TOMATOES("Tomatoes"),
    JALAPENOS("Jalapenos"),
    CUCUMBERS("Cucumbers"),
    PICKLES("Pickles"),
    GUACAMOLE("Guacamole"),
    MUSHROOMS("Mushrooms");

    private final String name;

    RegularToppingOption(String name){
        this.name = name;
    }

    @Override
    public double getPrice(SandwichSize size, boolean extra){
        return 0.0;
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
    public String toString(){
        String formatted = name().charAt(0) + name().substring(1).toLowerCase().replace("_", "");
        return formatted;
    }



}
