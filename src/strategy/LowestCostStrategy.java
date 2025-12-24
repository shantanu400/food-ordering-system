package strategy;

import entity.Menu;
import entity.Restaurant;

import java.util.List;
import java.util.Map;

public class LowestCostStrategy implements SelectionStrategy{
    @Override
    public Restaurant selectRestaurant(
            Map<Menu, Integer> items,
            List<Restaurant> restaurants) {

        Restaurant selected = null;
        int minCost = Integer.MAX_VALUE;

        for (Restaurant restaurant : restaurants) {

            // capacity check
            if (!restaurant.hasCapacity()) {
                continue;
            }

            // can fulfill all items?
            if (!restaurant.canFulfill(items)) {
                continue;
            }

            //  calculate bill
            int bill = restaurant.calculateBill(items);

            // pick minimum
            if (bill < minCost) {
                minCost = bill;
                selected = restaurant;
            }
        }

        return selected; // null if none found
    }
}
