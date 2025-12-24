package entity;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Restaurant {
    private UUID id;
    private String name;
    private double rating;
    private int maxOrders;
    private Map<UUID, Menu> menus = new ConcurrentHashMap<>();
    private int currentOrders;


    public Restaurant(String name, double rating, int maxOrders, List<Menu> menuList) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.rating = rating;
        this.maxOrders = maxOrders;
        this.currentOrders = 0;

        for (Menu m : menuList) {
            menus.put(m.getMenuId(), m);
        }
    }

    public boolean hasCapacity() {
        return currentOrders < maxOrders;
    }

    public boolean canFulfill(Map<Menu, Integer> items) {
        for (Menu m : items.keySet()) {
            if (!menus.containsKey(m.getMenuId())) {
                return false;
            }
        }
        return true;
    }

    // ---------- ORDER FLOW ----------

    public void acceptOrder() {
        if (!hasCapacity()) {
            throw new RuntimeException("Restaurant capacity full");
        }
        currentOrders++;
    }

    public void completeOrder() {
        currentOrders--;
    }

    public int calculateBill(Map<Menu, Integer> items) {
        int total = 0;
        for (Map.Entry<Menu, Integer> entry : items.entrySet()) {
            Menu menu = menus.get(entry.getKey().getMenuId());
            total += menu.getPrice() * entry.getValue();
        }
        return total;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getMaxOrders() {
        return maxOrders;
    }

    public void setMaxOrders(int maxOrders) {
        this.maxOrders = maxOrders;
    }

    public Map<UUID, Menu> getMenus() {
        return menus;
    }
}
