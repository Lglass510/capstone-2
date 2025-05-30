package model;

public enum ChipOption {
    CLASSIC("Classic", 1.50),
    BBQ("BB-Q",1.50),
    JALAPENO("Jalapeno",1.50),
    CHEDDAR("Cheddar",1.50);


    double price;
    String name;
     ChipOption(String name, double price){
        this.price = price;
        this.name = name;

    }

    public double getPrice(){
        return 1.50;
    }
    public String getName(){return name;}

    @Override
    public String toString(){
        return name().replace("_", " ");
    }

}
