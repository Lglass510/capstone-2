package ui;

import model.Order;
import model.OrderBuilder;

public class Main {
    public static void main(String[] args) {
        OrderBuilder orderBuilder = new OrderBuilder();
        Order order = orderBuilder.buildOrder();

        System.out.println("\n===== Your Order Summary =====");
        System.out.println(order);
        System.out.printf("Total Price: $%.2f%n", order.calculateTotal());
        System.out.println("==============================");
    }
}




