package entity;

import enums.OrderStatus;

import java.util.Collections;
import java.util.Map;
import java.util.UUID;

public class Order {

    private final UUID orderId;
    private final Map<Menu, Integer> items;
    private OrderStatus orderStatus;
    private final Restaurant assignedRestaurant;
    private final String user;

    public Order(String user,
                 Map<Menu, Integer> items,
                 Restaurant assignedRestaurant) {

        this.orderId = UUID.randomUUID();
        this.user = user;
        this.items = Collections.unmodifiableMap(items);
        this.assignedRestaurant = assignedRestaurant;
        this.orderStatus = OrderStatus.PLACED;
    }

    // -------- STATE TRANSITIONS --------

    public void markAccepted() {
        if (orderStatus != OrderStatus.PLACED) {
            throw new IllegalStateException("Only placed orders can be accepted");
        }
        this.orderStatus = OrderStatus.ACCEPTED;
    }

    public void markCompleted() {
        if (orderStatus != OrderStatus.ACCEPTED) {
            throw new IllegalStateException("Only accepted orders can be completed");
        }
        this.orderStatus = OrderStatus.COMPLETED;
    }

    // -------- GETTERS ONLY --------

    public UUID getOrderId() {
        return orderId;
    }

    public Map<Menu, Integer> getItems() {
        return items;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public Restaurant getAssignedRestaurant() {
        return assignedRestaurant;
    }

    public String getUser() {
        return user;
    }
}
