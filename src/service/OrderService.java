package service;

import entity.Menu;
import entity.Order;
import entity.Restaurant;
import enums.OrderStatus;
import repository.OrderRepository;
import repository.RestaurantRepository;
import strategy.SelectionStrategy;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;

public class OrderService {
private OrderRepository orderRepository;
private RestaurantRepository restaurantRepository;

    public OrderService(OrderRepository orderRepository, RestaurantRepository restaurantRepository) {
        this.orderRepository = orderRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public void createOrder(String user, Map<Menu,Integer> items, SelectionStrategy strategy){
        //Get all restaurants
        List<Restaurant> restaurants =
                restaurantRepository.getAllRestaurants();

        //Select restaurant using strategy
        Restaurant assignedRestaurant =
                strategy.selectRestaurant(items, restaurants);

        if (assignedRestaurant == null) {
            throw new RuntimeException("Cannot assign order");
        }

        // Create order (status set internally)
        Order newOrder = new Order(user, items, assignedRestaurant);

        // Restaurant accepts order (capacity check inside)
        assignedRestaurant.acceptOrder();

        // Persist order
        orderRepository.save(newOrder);
    }

    public void printAllOrders() {
        orderRepository.printOrders();
    }

}
