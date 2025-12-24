package strategy;

import entity.Menu;
import entity.Restaurant;

import java.util.List;
import java.util.Map;

public class HighestRatingStrategy implements SelectionStrategy {

    @Override
    public Restaurant selectRestaurant(
            Map<Menu, Integer> items,
            List<Restaurant> restaurants) {

        Restaurant selected = null;
        double bestRating = -1;

        for (Restaurant restaurant : restaurants) {

            // Capacity check
            if (!restaurant.hasCapacity()) {
                continue;
            }

            // Can fulfill all items?
            if (!restaurant.canFulfill(items)) {
                continue;
            }

            // Pick highest rating
            if (restaurant.getRating() > bestRating) {
                bestRating = restaurant.getRating();
                selected = restaurant;
            }
        }

        return selected; // null if no restaurant can fulfill
    }
}
