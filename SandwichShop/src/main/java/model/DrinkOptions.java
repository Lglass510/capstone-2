package model;

public enum DrinkOptions {
    COKE,
    SPRITE,
    LEMONADE,
    TEA,
    WATER;

    @Override
    public String toString(){
        return name().replace("_", " ").toLowerCase();
    }



}
