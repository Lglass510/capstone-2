package model;

public enum BreadType {
    WHITE(5.50, 7.00, 8.50),
    WHEAT(5.50, 7.00, 8.50),
    RYE(5.50, 7.00, 8.50),
    WRAP(5.50, 7.00, 8.50);

    private final double price4;
    private final double price8;
    private final double price12;

    BreadType(double price4, double price8, double price12){
        this.price4 = price4;
        this.price8 = price8;
        this.price12 = price12;
    }

    public double getPrice(SandwichSize size){
        return switch (size){
            case FOUR -> price4;
            case EIGHT -> price8;
            case TWELVE -> price12;
        };
    }
}
