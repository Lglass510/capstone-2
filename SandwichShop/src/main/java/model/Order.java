package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Sandwich> sandwiches = new ArrayList<>();
    private final List<Drink> drinks = new ArrayList<>();
    private final List<Chip> chips = new ArrayList<>();
    private final LocalDateTime orderTime;

    public Order() {
        this.orderTime = LocalDateTime.now();
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChip(Chip chip) {
        chips.add(chip);
    }

    public double calculateTotalPrice() {
        return sandwiches.stream().mapToDouble(Sandwich::calculateTotalPrice).sum()
        + drinks.stream().mapToDouble(Drink::getPrice).sum()
        + chips.stream().mapToDouble(Chip::getPrice).sum();
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

        if (!drinks.isEmpty()) {
            receipt.append("Drinks:\n");
            for (Drink d : drinks) {
                receipt.append("  - ").append(d.toString())
                        .append(" ($").append(String.format("%.2f", d.getPrice())).append(")\n");
            }
            receipt.append("\n");
        }

        if (!chips.isEmpty()) {
            receipt.append("Chips:\n");
            for (Chip c : chips) {
                receipt.append("  - ").append(c.toString())
                        .append(" ($").append(String.format("%.2f", c.getPrice())).append(")\n");
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
