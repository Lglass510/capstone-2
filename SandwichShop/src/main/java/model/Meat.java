package model;

public class Meat extends Topping {

    public Meat(String name,boolean isExtra) {
        super(name, true, isExtra);

    }

    public String getName() {
        return name;
    }

    @Override
    public double getPrice(SandwichSize size) {
        double base;
        switch (size) {
            case FOUR -> base = 1.00;
            case EIGHT -> base = 2.00;
            case TWELVE -> base = 3.00;
            default -> throw new IllegalArgumentException("Not a choice.");
        }
        if (isExtra) {
            switch (size) {
                case FOUR -> base += 0.50;
                case EIGHT -> base += 1.00;
                case TWELVE -> base += 1.50;
            }
        }
        return base;
    }


}
