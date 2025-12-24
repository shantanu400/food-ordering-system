package strategy;

import entity.Menu;
import entity.Restaurant;

import java.util.List;
import java.util.Map;

public interface SelectionStrategy {

    Restaurant selectRestaurant(
            Map<Menu, Integer> items,
            List<Restaurant> restaurants
    );
}