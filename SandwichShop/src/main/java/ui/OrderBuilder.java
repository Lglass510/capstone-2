package ui;

import model.*;
import java.util.*;
import java.util.Scanner;



public class OrderBuilder {
    private final Scanner sc = new Scanner(System.in);
    private final Order order = new Order();

    public void start(){
        Order order = buildOrder();
        ReceiptGenerator.generateReceipt(order);
        System.out.println("Thank you for your order!");
    }

    public Order buildOrder() {
        System.out.println("Welcome to Subs4U! Let's build your order.");

        boolean ordering = true;
        while (ordering) {
            System.out.println("\n1) Add Sandwich");
            System.out.println("2) Add Side");
            System.out.println("3) Finish Order");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine();

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

        Sandwich sandwich = new Sandwich(size, bread,true);

        boolean addingToppings = true;
        while (addingToppings) {
            System.out.println("\nAdd Topping:");
            System.out.println("1) Meat");
            System.out.println("2) Cheese");
            System.out.println("3) Regular Toppings");
            System.out.println("4) Sauce");
            System.out.println("5) Done adding toppings");
            System.out.println("6) Remove a topping");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> addMeat(sandwich);
                case "2" -> addCheese(sandwich);
                case "3" -> addRegularTopping(sandwich);
                case "4" -> addSauce(sandwich);
                case "5" -> addingToppings = false;
                case "6" -> removeTopping(sandwich);
                default -> System.out.println("Invalid choice, try again.");
            }
        }

        order.addSandwich(sandwich);
        System.out.println("Sandwich added to order.");
    }


    private void addMeat(Sandwich sandwich) {
        System.out.println("Choose a meat:");
        for (int i = 0; i < MeatOption.values().length; i++) {
            System.out.printf("%d. %s%n", i + 1, MeatOption.values()[i]);
        }
        System.out.println("Enter choice: ");
        String input = sc.nextLine();

        try {
            int choice = Integer.parseInt(input);
            if (choice >= 1 && choice <= MeatOption.values().length) {
                MeatOption selected = MeatOption.values()[choice - 1];
                sandwich.addTopping(selected);
                System.out.println(selected + " added.");
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }


        private void addCheese(Sandwich sandwich){
            System.out.println("Choose a cheese:");
            for (int i = 0; i < CheeseOption.values().length; i++) {
                System.out.printf("%d. %s%n", i + 1, CheeseOption.values()[i]);
            }
            System.out.println("Enter choice: ");
            String input = sc.nextLine();

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= CheeseOption.values().length) {
                    CheeseOption selected = CheeseOption.values()[choice - 1];
                    sandwich.addTopping(selected);
                    System.out.println(selected + " added.");
                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }

        }

        private void addRegularTopping(Sandwich sandwich ){
            System.out.println("Choose a Regular Topping:");
            for (int i = 0; i < RegularToppingOption.values().length; i++) {
                System.out.printf("%d. %s%n", i + 1, RegularToppingOption.values()[i]);
            }
            System.out.println("Enter choice: ");
            String input = sc.nextLine();

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= RegularToppingOption.values().length) {
                    RegularToppingOption selected = RegularToppingOption.values()[choice - 1];
                    sandwich.addTopping(selected);
                    System.out.println(selected + " added.");
                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }


        }

        private void addSauce(Sandwich sandwich){
            System.out.println("Choose a sauce:");
            for (int i = 0; i < SauceOption.values().length; i++) {
                System.out.printf("%d. %s%n", i + 1, SauceOption.values()[i]);
            }
            System.out.println("Enter choice: ");
            String input = sc.nextLine();

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= SauceOption.values().length) {
                    SauceOption selected = SauceOption.values()[choice - 1];
                    sandwich.addTopping(selected);
                    System.out.println(selected + " added.");
                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }


        }

// generic method that takes any topping enum array
    private void addToppingFromEnum(Sandwich sandwich, Topping[] options) {
        System.out.println("Available options:");
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d) %s%n", i + 1, options[i]);
        }
        System.out.print("Select topping number or 0 to cancel: ");

        String input = sc.nextLine();
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
            String input = sc.nextLine();
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
            String input = sc.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= sizes.length) {
                    return sizes[choice - 1];
                }
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid choice, try again.");
        }
    }
    private void removeTopping(Sandwich sandwich){
        List<Topping> toppings = sandwich.getToppings();

        if(toppings.isEmpty()){
            System.out.println("No toppings to remove.");
            return;
        }
        System.out.println("\nCurrent Toppings: ");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, toppings.get(i));

        }
        System.out.println("Enter the number of toppings to remove, or 0 to cancel: ");
        String input = sc.nextLine();

        try{
            int index = Integer.parseInt(input);
            if(index == 0) return;
            if (index >= 1 && index <= toppings.size()){
                Topping removed = toppings.remove(index -1);
                System.out.println(removed + " removed.");
            } else {
                System.out.println("Invalid choice.");
            }

            } catch (NumberFormatException e){
                System.out.println("Invalid input.");
            }

    }

    private void addSide() {
        System.out.println("\nAdd Side:");
        System.out.println("1) Chips");
        System.out.println("2) Drink");
        System.out.print("Choose an option: ");

        String choice = sc.nextLine();

        switch (choice) {
            case "1" -> addChip();
            case "2" -> addDrink();
            default -> System.out.println("Invalid choice.");
        }
    }

    private void addChip() {
        ChipOption[] chipOptions = ChipOption.values();
        System.out.println("\nSelect Chip Option:");
        for (int i = 0; i < chipOptions.length; i++) {
            System.out.printf("%d) %s%n", i + 1, chipOptions[i]);
        }
        System.out.print("Enter choice number: ");
        int choice = getValidInput(1, chipOptions.length);

        ChipOption selectedChip = chipOptions[choice - 1];
        order.addChip(selectedChip);

        System.out.println(selectedChip.getName() + " chips added to order.");
    }


    private int getValidInput(int min,int max) {
        while (true) {
            try {
                int input = Integer.parseInt(sc.nextLine().trim());
                if (input >= min && input <= max) {
                    return input;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Invalid input. Please enter a number between " + min + "and" + max);
        }
    }

    private void addDrink() {
        DrinkOptions[] drinks = DrinkOptions.values();
        DrinkSize[] sizes = DrinkSize.values();

        System.out.println("\nSelect Drink Option:");
        for (int i = 0; i < drinks.length; i++) {
            System.out.printf("%d) %s%n", i + 1, drinks[i]);
        }
        System.out.print("Enter choice: ");
        String drinkInput = sc.nextLine();

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
        String sizeInput = sc.nextLine();

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
