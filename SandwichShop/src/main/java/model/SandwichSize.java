
package model;

public enum SandwichSize {
    FOUR(4,5.50),
    EIGHT(8,7.00),
    TWELVE(12,8.50);

    private final int inches;
    private final double basePrice;

    SandwichSize(int inches, double basePrice) {
        this.inches = inches;
        this.basePrice = basePrice;
    }

    public int getInches() {
        return inches;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return inches + "\"";
    }
}
