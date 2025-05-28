package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Sandwich {
    private SandwichSize size;
    private BreadType bread;
    private List<Topping> toppings;

    public Sandwich(SandwichSize size, BreadType bread) {
        this.size = size;
        this.bread = bread;
        this.toppings = new ArrayList<>();
    }
    public void addTopping(Topping topping){
        toppings.add(topping);
    }
    public SandwichSize getSize() {
        return size;
    }

    public BreadType getBread() {
        return bread;
    }

    public List<Topping> getToppings(){
        return toppings;
    }


    public double calculateTotalPrice(){
        double basePrice = size.getBasePrice();
        for (Topping topping : toppings){
            basePrice += topping.getPrice(size, false);
        }
        return basePrice;
    }

    private String formatToppingsByType(ToppingType type){
        List<String> names = toppings.stream()
                .filter(t -> t.getType() == type)
                .map(Topping:: getName)
                .collect(Collectors.toList());
        return names.isEmpty() ? "None" : String.join(",", names);
    }

    public String getSummary(){
        StringBuilder summary = new StringBuilder();
        summary.append(" Size: ").append(size).append("\n");
        summary.append(" Bread").append(bread).append("\n");
        summary.append(" Toppings:\n");

        if(toppings.isEmpty()) {
            summary.append("  (No toppings selected)\n");
        } else {
            for(Topping topping : toppings){
                summary.append("   - ").append(topping.toString());
                if(topping instanceof MeatOption meat){
                    if (meat.getPrice(size, true) > 0)
                    summary.append(" ($").append(String.format("%2.f", meat.getPrice(size, true))).append(")");
                } else if (topping instanceof CheeseOption cheese) {
                    if(cheese.getPrice(size, true) > 0){
                        summary.append(" ($").append(String.format("%.2f", cheese.getPrice(size, true)));
                    }
                }
                summary.append("\n");
            }
        }
        summary.append(" Sandwich Price: %")
                .append(String.format("%.2f", calculateTotalPrice()))
                .append("\n");
        return summary.toString();
    }

    @Override
    public String toString() {
        return String.format(
                "%s\" %s Sandwich\n" +
                        "  Meats: %s\n" +
                        "  Cheeses: %s\n" +
                        "  Regular Toppings: %s\n" +
                        "  Premium Toppings: %s\n" +
                        "  Sauces: %s\n" +
                        "  Price: $%.2f",
                size.getInches(),
                bread,
                formatToppingsByType(ToppingType.MEAT),
                formatToppingsByType(ToppingType.CHEESE),
                formatToppingsByType(ToppingType.REGULAR),
                formatToppingsByType(ToppingType.SAUCE),
                formatToppingsByType(ToppingType.SIDE),
                calculateTotalPrice()
        );
    }

}

