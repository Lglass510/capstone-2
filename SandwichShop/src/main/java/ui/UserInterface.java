package ui;

import java.util.Scanner;

import model.*;

public class UserInterface {
    private static Scanner sc = new Scanner(System.in);
    private static Order order = new Order();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("=== Subs4U Ordering System ===");
            System.out.println("1. Create Sandwich");
            System.out.println("2. Add Side");
            System.out.println("3. View Order");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String input = sc.nextLine();

            switch (input) {
                case "1":
                    createSandwich();
                    break;
                case "2":
                    addSide();
                    break;
                case "3":
                    viewOrder();
                    break;
                case "4":
                    checkout();
                    running = false;
                    break;
                case "5":
                    running = false;
                    System.out.println("Thanks for visiting Subs4U!");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
            System.out.println();
        }
    }

    private static void createSandwich() {
        System.out.println("--- Create Sandwich ---");

        // Choose BreadType
        BreadType bread = chooseOption("Bread Type", BreadType.values());

        // Choose SandwichSize
        SandwichSize size = chooseOption("Sandwich Size", SandwichSize.values());

        // Ask if toasted
        boolean toasted = askYesNo("Do you want your sandwich toasted? (y/n): ");

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        // Add toppings loop
        boolean addingToppings = true;
        while (addingToppings) {
            System.out.println("Add Topping:");
            System.out.println("1. Meat");
            System.out.println("2. Cheese");
            System.out.println("3. Sauce");
            System.out.println("4. Regular Toppings");
            System.out.println("5. Done adding toppings");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    MeatOption meat = chooseOption("Meat Option", MeatOption.values());
                    sandwich.addTopping(meat);
                    break;
                case "2":
                    CheeseOption cheese = chooseOption("Cheese Option", CheeseOption.values());
                    sandwich.addTopping(cheese);
                    break;
                case "3":
                    SauceOption sauce = chooseOption("Sauce Option", SauceOption.values());
                    sandwich.addTopping(sauce);
                    break;

                case "4":
                    RegularToppingOption reg = chooseOption("Regular Topping", RegularToppingOption.values());
                    sandwich.addTopping(reg);
                    break;
                case "5":
                    addingToppings = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        order.addSandwich(sandwich);
        System.out.println("Sandwich added to order!");
    }

    // Generic method to pick an enum option by number
    private static <T extends Enum<T>> T chooseOption(String prompt, T[] options) {
        while (true) {
            System.out.println(prompt + ":");
            for (int i = 0; i < options.length; i++) {
                System.out.printf("%d. %s\n", i + 1, options[i].name());
            }
            System.out.print("Choose an option (1-" + options.length + "): ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= options.length) {
                    return options[choice - 1];
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalid choice, try again.");
        }
    }

    private static boolean askYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("y")) return true;
            if (input.equals("n")) return false;
            System.out.println("Please enter 'y' or 'n'.");
        }
    }

    private static void addSide() {
        boolean addingSides = true;
        while (addingSides) {
            System.out.println("--- Add Side ---");
            System.out.println("1. Chips");
            System.out.println("2. Drink");
            System.out.println("0. Done");

            String input = sc.nextLine();
            switch (input) {
                case "1":
                    ChipOption chip = chooseOption("Choose chips", ChipOption.values());
                    order.addChip(chip);
                    System.out.println(chip.getName() + " chips added to your order.");
                    break;
                case "2":
                    DrinkOptions drinkOptions = chooseOption("Choose drink", DrinkOptions.values());
                    DrinkSize size = chooseOption("Choose drink size" , DrinkSize.values());
                    Drink drink = new Drink(drinkOptions, size);
                    order.addDrink(drink);
                    System.out.println(drink.getName() + " added to your order");
                    break;
                case "0":
                    addingSides = false;
                    break;
                default:
                    System.out.println("Invalid choice.");


            }
        }
        System.out.println("Side adding coming soon...");
    }

    private static void viewOrder() {
        System.out.println("--- Current Order ---");
        System.out.println(order.generateReceipt());
    }

    private static void checkout() {
        System.out.println("--- Checkout ---");
        System.out.println(order.generateReceipt());
        System.out.println("Thank you for your order!");
    }
}
