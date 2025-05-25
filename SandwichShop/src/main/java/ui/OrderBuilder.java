package ui;
import model.*;

import java.util.*;

import static model.Chips.chipPrice;

public class OrderBuilder {
    private final Scanner sc = new Scanner(System.in);

    public Order startOrder() {
        System.out.println("Welcome to Subsonic!");
        Order order = new Order();

        do {
            Sandwich sandwich = buildSandwich();
            order.addSandwich(sandwich);
        } while (askYesOrNo("Would you like to add another sandwich"));

        addSides(order);

        System.out.println("\nOrder Receipt:");
        System.out.println(order.getReceipt());
        return order;
    }

    private Sandwich buildSandwich() {


        System.out.println("Choose your bread: ");
        for (int i = 0; i < BreadType.values().length; i++) {
            System.out.printf("%d) %s%n", i + 1, BreadType.values()[i]);
        }
        int breadChoice = getUserChoice(1, BreadType.values().length);
        BreadType bread = BreadType.values()[breadChoice - 1];

        System.out.println("Choose your sandwich size:");
        for (int i = 0; i < SandwichSize.values().length; i++) {
            System.out.printf("%d) %s%n", i + 1, SandwichSize.values()[i]);
        }
        int sizeChoice = getUserChoice(1, SandwichSize.values().length);
        SandwichSize size = SandwichSize.values()[sizeChoice - 1];

        Sandwich sandwich = new Sandwich(bread, size);

        addToppings(sandwich);

        System.out.println("\nHere's your sandwich summary: ");
        System.out.println(sandwich.getSummary());
        return sandwich;
    }

    private void addToppings(Sandwich sandwich) {
        while (true) {
            System.out.println("\nChoose a topping category:");
            System.out.println("1) Meat");
            System.out.println("2) Cheese");
            System.out.println("3) Regular Toppings");
            System.out.println("4) Done");

            int choice = getUserChoice(1, 4);

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter meat name:");
                    String meat = sc.nextLine();
                    boolean extra = askExtra();
                    sandwich.addTopping(new Meat(meat, extra));
                }
                case 2 -> {
                    System.out.println("Enter cheese name:");
                    String cheese = sc.nextLine();
                    boolean extra = askExtra();
                    sandwich.addTopping(new Cheese(cheese, extra));
                }
                case 3 -> {
                    System.out.println("Enter topping name:");
                    String reg = sc.nextLine();
                    sandwich.addTopping(new RegularTopping(reg));
                }
                case 4 -> {
                    return;
                }
            }
        }
    }

    private boolean askExtra() {
        System.out.println("Do you want extra? (yes/no): ");
        String input = sc.nextLine().trim().toLowerCase();
        return input.startsWith("y");
    }

    private int getUserChoice(int min, int max) {
        while (true) {
            System.out.println("Your choice: ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (choice >= min && choice <= max) return choice;
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalid input. Try again.");
        }
    }

    private void addSides(Order order){
        while (true) {
            System.out.println("\nChoose a side: ");
            System.out.println("1) Chips");
            System.out.println("2) Drink");
            System.out.println("3) Sauce");
            System.out.println("4) Done");

            int choice = getUserChoice(1,4);

            switch (choice){
                case 1 -> {
                    System.out.println("Enter chips name: ");
                    String chipsName = sc.nextLine();
                    order.addSide(new Chips(chipsName,1.50));
                }
                case 2 -> {
                    System.out.println("Enter drink name: ");
                    String drinkName = sc.nextLine();
                    order.addSide(new Drink(drinkName, drinkPrice));
                }
                case 3 -> {
                    System.out.println("Enter sauce name:");
                    String sauceName = sc.nextLine();
                    order.addSide(new Sauce(sauceName));
                }
                case 4 -> {
                    return;
                }
            }
        }
    }
    private boolean askYesOrNo(String prompt) {
        System.out.println(prompt + " (yes/no): ");
        String input = sc.nextLine().trim().toLowerCase();
        return input.startsWith("y");
    }

}