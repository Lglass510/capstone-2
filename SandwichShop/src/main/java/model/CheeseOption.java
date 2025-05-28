package model;

public enum CheeseOption implements Topping{
    AMERICAN(0.75, 1.50, 2.25, "American"),
    PROVOLONE(0.75, 1.50, 2.25, "Provolone"),
    CHEDDAR(0.75, 1.50, 2.25, "Cheddar"),
    SWISS(0.75, 1.50, 2.25, "Swiss");


    private final double price4;
    private final double price8;
    private final double price12;
    private final String name;

    CheeseOption(double price4, double price8, double price12, String name){
        this.price4 = price4;
        this.price8 = price8;
        this.price12 = price12;
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public ToppingType getType(){
        return ToppingType.CHEESE;
    }

    public double getPrice(SandwichSize size, boolean extra) {
        double basePrice = switch (size) {
            case FOUR -> price4;
            case EIGHT -> price8;
            case TWELVE -> price12;
        };


        if (extra) {
            double extraPrice = switch (size) {
                case FOUR -> 0.30;
                case EIGHT -> 0.60;
                case TWELVE ->0.90;
            };
            return basePrice + extraPrice;
        }
        return basePrice;
    }

    @Override
    public String toString(){
        String name = name().toLowerCase().replace("_", "");
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}



