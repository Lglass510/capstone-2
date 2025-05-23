package model;

public class Cheese extends Topping {
    public Cheese(String name, boolean isExtra) {
        super(name, true, isExtra);

    }
    public String getName() {return name;}

    @Override
    public double getPrice(SandwichSize size) {
        double base;
        switch (size) {
            case FOUR -> base = 0.75;
            case EIGHT -> base = 1.50;
            case TWELVE -> base = 2.25;
            default -> throw new IllegalArgumentException("Not a choice.");
        }
        if (isExtra) {
            switch (size) {
                case FOUR -> base += 0.30;
                case EIGHT -> base += 0.60;
                case TWELVE -> base += 0.90;
            }
        }
        return base;
    }


}


