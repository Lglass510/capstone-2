package model;

public enum SauceOption implements Topping {
    MAYO,
    MUSTARD,
    KETCHUP,
    RANCH,
    THOUSAND_ISLAND,
    VINAIGRETTE,
    AU_JUS,
    SAUCE;

    @Override
    public double getPrice(SandwichSize size, boolean extra){
        return 0.00;
    }

    @Override
    public String toString(){
        String name = name().toLowerCase().replace("_", "");
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}
