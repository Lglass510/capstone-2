package model;
import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private BreadType bread;
    private SandwichSize size;
    private final List<Topping> toppings = new ArrayList<>();

    public Sandwich(BreadType bread, SandwichSize size){
        this.bread = bread;
        this.size = size;
    }

    public void addTopping(Topping topping){
        toppings.add(topping);
    }
    public void removeTopping(String name){
        toppings.removeIf(t -> t.getName().equalsIgnoreCase(name));
    }

    public double calculateTotalPrice(){
        double basePrice = switch (size){
            case FOUR -> 4.00;
            case EIGHT -> 6.00;
            case TWELVE -> 8.00;
        };
        for(Topping t : toppings){
            basePrice += t.getPrice(size);
        }
        return basePrice;
    }
    public String getSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bread: ").append(bread).append("\n");
        sb.append("Size: ").append(size).append("\n");
        sb.append("Toppings:\n");
        for(Topping t : toppings) {
            sb.append(" - ").append(t.getName()).append(" ($")
                    .append(String.format("%.2f", t.getPrice(size))).append(")\n");
        }
        sb.append("Total: $").append(String.format("%.2f", calculateTotalPrice()));
        return sb.toString();

    }
}
