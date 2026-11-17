
package com.example.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OrderService service = new OrderService();

        try {
            boolean running = true;

            while (running) {
                System.out.println("\n===== ORDER PROCESSING SYSTEM =====");
                System.out.println("1. Place Order");
                System.out.println("2. View Customer Order History");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Enter customer name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter customer email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter number of items: ");
                        int count = Integer.parseInt(sc.nextLine());

                        if (count <= 0) {
                            System.out.println(
                                    "Number of items must be greater than zero.");
                            break;
                        }

                        List<OrderItem> items = new ArrayList<>();

                        for (int i = 1; i <= count; i++) {
                            System.out.println("\nItem " + i);

                            System.out.print("Product name: ");
                            String product = sc.nextLine();

                            System.out.print("Quantity: ");
                            int quantity =
                                    Integer.parseInt(sc.nextLine());

                            System.out.print("Price: ");
                            double price =
                                    Double.parseDouble(sc.nextLine());

                            if (quantity <= 0 || price < 0) {
                                System.out.println(
                                        "Invalid quantity or price.");
                                items.clear();
                                break;
                            }

                            items.add(
                                    new OrderItem(product, quantity, price));
                        }

                        if (!items.isEmpty()) {
                            service.placeOrder(name, email, items);
                        }
                        break;

                    case 2:
                        System.out.print("Enter customer ID: ");
                        Long customerId =
                                Long.parseLong(sc.nextLine());

                        service.displayOrderHistory(customerId);
                        break;

                    case 3:
                        running = false;
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } finally {
            HibernateUtil.shutdown();
            sc.close();
        }
    }
}
