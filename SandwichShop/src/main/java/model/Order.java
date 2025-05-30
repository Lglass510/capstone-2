package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Sandwich> sandwiches = new ArrayList<>();
    private List<SideItem> sides = new ArrayList<>();
    private List<ChipOption> chips = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private final LocalDateTime orderTime;

    public Order() {
        this.orderTime = LocalDateTime.now();
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void addSide(SideItem side) {
        sides.add(side);
    }

    public void addChip(ChipOption chip) {
        chips.add(chip);
    }
    public void addDrink(Drink drink){
        drinks.add(drink);
    }

    public List<SideItem> getSides() {
        return sides;
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }


    public double calculateTotalPrice() {
        double sandwichesTotal = sandwiches.stream().mapToDouble(Sandwich::calculateTotalPrice).sum();
        double sidesTotal = sides.stream().mapToDouble(SideItem::getPrice).sum();
        return sandwichesTotal + sidesTotal;
    }

    public String generateReceipt() {
        StringBuilder receipt = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        receipt.append("==== Subs4U Order Receipt ====\n");
        receipt.append("Order Time: ").append(orderTime.format(formatter)).append("\n\n");


        for (int i = 0; i < sandwiches.size(); i++) {
            receipt.append("Sandwich #").append(i + 1).append(":\n");
            receipt.append(sandwiches.get(i).getSummary()).append("\n");
        }

        if (!sides.isEmpty()) {
            receipt.append("Sides:\n");
            for (SideItem side : sides) {
                receipt.append("  - ").append(side.getName())
                        .append(" ($").append(String.format("%.2f", side.getPrice())).append(")\n");
            }
            receipt.append("\n");
        }

        receipt.append("Total Due: $").append(String.format("%.2f", calculateTotalPrice())).append("\n");
        receipt.append("==============================\n");

        return receipt.toString();
    }

    public String getTimestampedFilename() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        return "order_" + orderTime.format(formatter) + ".txt";
    }
}
