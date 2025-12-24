package controller;

import entity.Menu;
import entity.Restaurant;
import enums.OrderStatus;
import service.OrderService;
import strategy.SelectionStrategy;

import java.util.Map;

public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void createNewOrder(String user, Map<Menu,Integer> items, SelectionStrategy strategy ){
        orderService.createOrder(user,items,strategy);
    }

    public void printOrders() {
        orderService.printAllOrders();
    }

}
