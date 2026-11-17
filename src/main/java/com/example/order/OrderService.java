
package com.example.order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class OrderService {

    public void placeOrder(
            String customerName,
            String email,
            List<OrderItem> items) {

        EntityManager em =
                HibernateUtil.getEntityManagerFactory()
                             .createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            Customer customer =
                    new Customer(customerName, email);

            em.persist(customer);

            CustomerOrder order = new CustomerOrder(customer);

            for (OrderItem item : items) {
                order.addItem(item);
            }

            em.persist(order);

            transaction.commit();

            System.out.println("Order placed successfully!");
            System.out.println("Customer ID: " + customer.getId());
            System.out.println("Order ID: " + order.getId());

        } catch (Exception e) {

            if (transaction.isActive()) {
                transaction.rollback();
            }

            System.out.println(
                    "Failed to place order: " + e.getMessage());

        } finally {
            em.close();
        }
    }

    public void displayOrderHistory(Long customerId) {

        EntityManager em =
                HibernateUtil.getEntityManagerFactory()
                             .createEntityManager();

        try {
            List<CustomerOrder> orders = em.createQuery(
                    "SELECT DISTINCT o FROM CustomerOrder o "
                    + "LEFT JOIN FETCH o.items "
                    + "WHERE o.customer.id = :customerId",
                    CustomerOrder.class)
                    .setParameter("customerId", customerId)
                    .getResultList();

            if (orders.isEmpty()) {
                System.out.println("No orders found.");
                return;
            }

            for (CustomerOrder order : orders) {
                System.out.println(order);

                for (OrderItem item : order.getItems()) {
                    System.out.println("  " + item);
                }
            }

        } catch (Exception e) {
            System.out.println(
                    "Error retrieving order history: "
                    + e.getMessage());

        } finally {
            em.close();
        }
    }
}
