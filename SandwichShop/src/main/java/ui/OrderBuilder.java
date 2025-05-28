package ui;

import model.*;
import java.util.*;


import java.util.Scanner;

public class OrderBuilder {
    private final Scanner scanner = new Scanner(System.in);
    private final Order order = new Order();

    public Order buildOrder() {
        System.out.println("Welcome to Subs4U! Let's build your order.");

        boolean ordering = true;
        while (ordering) {
            System.out.println("\n1) Add Sandwich");
            System.out.println("2) Add Side");
            System.out.println("3) Finish Order");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addSandwich();
                case "2" -> addSide();
                case "3" -> ordering = false;
                default -> System.out.println("Invalid choice, try again.");
            }
        }

        System.out.println("Order completed.\n");
        return order;
    }

    private void addSandwich() {
        BreadType bread = promptBread();
        SandwichSize size = promptSize();

        Sandwich sandwich = new Sandwich(size, bread);

        boolean addingToppings = true;
        while (addingToppings) {
            System.out.println("\nAdd Topping:");
            System.out.println("1) Meat");
            System.out.println("2) Cheese");
            System.out.println("3) Regular Toppings");
            System.out.println("4) Sauce");
            System.out.println("5) Done adding toppings");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addToppingFromEnum(sandwich, MeatOption.values());
                case "2" -> addToppingFromEnum(sandwich, CheeseOption.values());
                case "3" -> addToppingFromEnum(sandwich, RegularToppingOption.values());
                case "4" -> addToppingFromEnum(sandwich, SauceOption.values());
                case "5" -> addingToppings = false;
                default -> System.out.println("Invalid choice, try again.");
            }
        }

        order.addSandwich(sandwich);
        System.out.println("Sandwich added to order.");
    }

    private void addToppingFromEnum(Sandwich sandwich, Topping[] options) {
        System.out.println("Available options:");
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d) %s%n", i + 1, options[i]);
        }
        System.out.print("Select topping number or 0 to cancel: ");

        String input = scanner.nextLine();
        int index;
        try {
            index = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        if (index == 0) return;

        if (index < 1 || index > options.length) {
            System.out.println("Invalid choice.");
            return;
        }

        Topping topping = options[index - 1];
        sandwich.addTopping(topping);
        System.out.println(topping + " added.");
    }

    private BreadType promptBread() {
        System.out.println("\nSelect Bread Type:");
        BreadType[] breads = BreadType.values();
        for (int i = 0; i < breads.length; i++) {
            System.out.printf("%d) %s%n", i + 1, breads[i]);
        }
        while (true) {
            System.out.print("Enter choice: ");
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= breads.length) {
                    return breads[choice - 1];
                }
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid choice, try again.");
        }
    }

    private SandwichSize promptSize() {
        System.out.println("\nSelect Sandwich Size:");
        SandwichSize[] sizes = SandwichSize.values();
        for (int i = 0; i < sizes.length; i++) {
            System.out.printf("%d) %s inch%n", i + 1, sizes[i].name());
        }
        while (true) {
            System.out.print("Enter choice: ");
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= sizes.length) {
                    return sizes[choice - 1];
                }
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid choice, try again.");
        }
    }

    private void addSide() {
        System.out.println("\nAdd Side:");
        System.out.println("1) Chips");
        System.out.println("2) Drink");
        System.out.print("Choose an option: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1" -> addChip();
            case "2" -> addDrink();
            default -> System.out.println("Invalid choice.");
        }
    }

    private void addChip() {
        ChipOption[] chips = ChipOption.values();
        System.out.println("\nSelect Chip Option:");
        for (int i = 0; i < chips.length; i++) {
            System.out.printf("%d) %s%n", i + 1, chips[i]);
        }
        System.out.print("Enter choice: ");
        String input = scanner.nextLine();

        try {
            int choice = Integer.parseInt(input);
            if (choice >= 1 && choice <= chips.length) {
                ChipOption chip = chips[choice - 1];
                order.addSide(() -> chip.toString(), chip.getPrice());
                System.out.println(chip + " chips added.");
                return;
            }
        } catch (NumberFormatException ignored) {}

        System.out.println("Invalid choice.");
    }

    private void addDrink() {
        DrinkOptions[] drinks = DrinkOptions.values();
        DrinkSize[] sizes = DrinkSize.values();

        System.out.println("\nSelect Drink Option:");
        for (int i = 0; i < drinks.length; i++) {
            System.out.printf("%d) %s%n", i + 1, drinks[i]);
        }
        System.out.print("Enter choice: ");
        String drinkInput = scanner.nextLine();

        int drinkChoice;
        try {
            drinkChoice = Integer.parseInt(drinkInput);
            if (drinkChoice < 1 || drinkChoice > drinks.length) {
                System.out.println("Invalid choice.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        System.out.println("\nSelect Drink Size:");
        for (int i = 0; i < sizes.length; i++) {
            System.out.printf("%d) %s%n", i + 1, sizes[i]);
        }
        System.out.print("Enter choice: ");
        String sizeInput = scanner.nextLine();

        int sizeChoice;
        try {
            sizeChoice = Integer.parseInt(sizeInput);
            if (sizeChoice < 1 || sizeChoice > sizes.length) {
                System.out.println("Invalid choice.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        DrinkOptions selectedDrink = drinks[drinkChoice - 1];
        DrinkSize selectedSize = sizes[sizeChoice - 1];
        order.addSide(new SideItem() {
            @Override
            public String getName() {
                return selectedSize + " " + selectedDrink.toString();
            }

            @Override
            public double getPrice() {
                return selectedSize.getPrice();
            }
        });
        System.out.println(selectedSize + " " + selectedDrink + " added.");
    }
}
