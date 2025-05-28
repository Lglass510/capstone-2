package model;

public enum ChipOption {
    CLASSIC(1.50),
    BBQ(1.50),
    JALAPENO(1.50),
    CHEDDAR(1.50);

    public double getPrice(){
        return 1.50;
    }
    @Override
    public String toString(){
        return name().replace("_", " ");
    }

}
