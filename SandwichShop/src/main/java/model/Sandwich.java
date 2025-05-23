package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandwich {
    private SandwichSize sandwichSize;
    private BreadType breadType;
    private boolean toasted;
    private List<Topping> toppings = new ArrayList<>();

    public Sandwich( SandwichSize sandwichSize, BreadType breadType, boolean toasted){
        this.sandwichSize = sandwichSize;
        this.breadType = breadType;
        this.toasted = toasted;
    }

    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    public double getPrice(){
        double base;
        switch (sandwichSize){
            case FOUR -> base = 5.50;
            case EIGHT -> base = 7.00;
            case TWELVE -> base = 8.50;
            default -> throw new IllegalStateException("THAT WASN'T AN OPTION!!!");

        }
        for (Topping topping : toppings){
            base += topping.getPrice(sandwichSize);
        }
        return base;
    }
    public List<Topping> getToppings(){
        return toppings;
    }
    public static void buildSandwich(Scanner sc, Order order){}

}
