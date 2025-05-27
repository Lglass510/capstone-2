package model;

public enum CheeseOption implements Topping{
    AMERICAN(1.00, 2.00, 3.00),
    PROVOLONE(1.00, 2.00, 3.00),
    CHEDDAR(1.00, 2.00, 3.00),
    SWISS(1.00, 2.00, 3.00);


    private final double price4;
    private final double price8;
    private final double price12;

    CheeseOption(double price4, double price8, double price12){
        this.price4 = price4;
        this.price8 = price8;
        this.price12 = price12;
    }

    public double getPrice(SandwichSize size, boolean extra) {
        double basePrice = switch (size) {
            case FOUR -> price4;
            case EIGHT -> price8;
            case TWELVE -> price12;
        };


        if (extra) {
            double extraPrice = switch (size) {
                case FOUR -> 0.50;
                case EIGHT -> 1.00;
                case TWELVE -> 1.50;
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



