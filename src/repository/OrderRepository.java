package repository;

import entity.Menu;
import entity.Order;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class OrderRepository {
    Map<UUID, Order> orders=new ConcurrentHashMap<>();

    public void addOrderToOrders(Order order){
        orders.put(order.getOrderId(),order);
    }

    public void save(Order order){
        orders.put(order.getOrderId(),order);
    }

    public void printOrders() {
        System.out.println("---- ORDERS ----");
        for (Order order : orders.values()) {
            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("User: " + order.getUser());
            System.out.println("Restaurant: " + order.getAssignedRestaurant().getName());
            System.out.println("Status: " + order.getOrderStatus());
            System.out.println("Items:");

            for (Map.Entry<Menu, Integer> entry : order.getItems().entrySet()) {
                System.out.println(
                        "  - " + entry.getKey().getName() +
                                " x " + entry.getValue() +
                                " (₹" + entry.getKey().getPrice() + ")"
                );
            }
            System.out.println("----------------");
        }
    }


}
