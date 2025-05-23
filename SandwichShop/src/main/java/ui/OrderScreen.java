package ui;
import model.*;
import java.util.Scanner;

public class OrderScreen {
    private final  Scanner sc;
    private Order order;

    public OrderScreen(Scanner sc){
        this.sc = sc;
        this.order = new Order();
    }
    public void displayOrderScreen(){
        while(true){
            System.out.println("\n--Please choose a menu option--");
            System.out.println("1. Add Sandwich");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. Checkout");
            System.out.println("5. Cancel Order");

            int choice = getIntInput();

            switch (choice){
                case 1 -> Sandwich.buildSandwich(sc,order);
                case 2 -> Drink.addDrink(sc,order);
                case 3 -> Chips.addChips(sc,order);
                case 4 -> {
                    Checkout.displayCheckoutScreen(sc,order);
                    return;
                }
                case 5 -> {
                    System.out.println("Order cancelled. Returning to home screen.");
                    return;
                }
                default -> System.out.println("Invalid option, try again.");
            }
        }
    }
    private int getIntInput(){
        while(!sc.hasNextInt()){
            System.out.println("Please enter a number.");
            sc.next();
        }
        return sc.nextInt();
    }
    public Order getCurrentOrder(){
        return order;
    }
    public void resetOrder(){
        this.order = new Order();
    }

}
