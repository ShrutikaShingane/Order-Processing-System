
package com.example.order;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @OneToMany(mappedBy = "customer",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    private List<CustomerOrder> orders = new ArrayList<>();

    public Customer() {
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<CustomerOrder> getOrders() {
        return orders;
    }

    public void addOrder(CustomerOrder order) {
        orders.add(order);
        order.setCustomer(this);
    }

    @Override
    public String toString() {
        return "Customer{id=" + id
                + ", name='" + name + '\''
                + ", email='" + email + "'}";
    }
}
