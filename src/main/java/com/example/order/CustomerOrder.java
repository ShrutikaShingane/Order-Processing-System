
package com.example.order;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "order",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    public CustomerOrder() {
    }

    public CustomerOrder(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addItem(OrderItem item) {
        items.add(item);
        item.setOrder(this);
    }

    @Override
    public String toString() {
        return "Order{id=" + id
                + ", customerId="
                + (customer != null ? customer.getId() : null)
                + ", items=" + items.size() + "}";
    }
}
