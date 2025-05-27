package model;

public enum ChipOption {
    CLASSIC,
    BBQ,
    JALAPENO,
    CHEDDAR;

    public double getPrice(){
        return 1.50;
    }
    @Override
    public String toString(){
        return name().replace("_", " ");
    }

}
