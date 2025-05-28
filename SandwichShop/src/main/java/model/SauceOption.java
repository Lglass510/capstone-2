package model;

public enum SauceOption implements Topping {
    MAYO("Mayo"),
    MUSTARD("Mustard"),
    KETCHUP("Ketchup"),
    RANCH("Ranch"),
    THOUSAND_ISLAND("Thousand Island"),
    VINAIGRETTE("Vinaigrette"),
    AU_JUS("Au Jus"),
    SAUCE("Sauce");

    private final String name;
    SauceOption(String name){
        this.name = name;
    }
    @Override
    public String getName(){
        return name;
    }

    @Override
    public double getPrice(SandwichSize size, boolean extra){
        return 0.00;
    }
    @Override
    public ToppingType getType(){
        return ToppingType.SAUCE;
    }

    @Override
    public String toString(){
        String name = name().toLowerCase().replace("_", "");
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}
