package controller;

import entity.Menu;
import entity.Restaurant;
import repository.MenuRepository;
import repository.RestaurantRepository;
import service.RestaurantService;

import java.util.List;
import java.util.UUID;

public class RestaurantController {

    private RestaurantRepository restaurantRepository;
    private MenuRepository menuRepository;
    private RestaurantService restaurantService;

    public RestaurantController(RestaurantRepository restaurantRepository, MenuRepository menuRepository,RestaurantService restaurantService) {
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
        this.restaurantService=restaurantService;
    }
    public void InitializeRestaurant(){
        restaurantService.InitializeRestaurant(4);
    }
    public void AddRestaurant(String name, int rating, int maxOrder, List<Menu> menu) {

        restaurantService.AddRestaurant(name,rating,maxOrder,menu);
    }

}
