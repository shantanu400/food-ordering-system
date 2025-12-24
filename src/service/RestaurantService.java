package service;

import entity.Menu;
import entity.Restaurant;
import enums.RestaurantName;
import repository.MenuRepository;
import repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RestaurantService {
    private MenuRepository menuRepository;
    private RestaurantRepository restaurantRepository;


    public RestaurantService(RestaurantRepository restaurantRepository,MenuRepository menuRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuRepository=menuRepository;
    }

    public void InitializeRestaurant(int numberOfRestaurant){
        List<Menu> menu = new ArrayList<>(menuRepository.GetMenus().values());
        RestaurantName[] names = RestaurantName.values();

        for (int i = 0; i < numberOfRestaurant && i < names.length; i++) {
            AddRestaurant(names[i].name(), 5, i + 5, menu);
        }
    }
    public void AddRestaurant(String name, int rating, int maxOrder, List<Menu> menu){
        Restaurant tempRestaurant=new Restaurant(name,rating,maxOrder,menu);

        restaurantRepository.AddRestaurantToRestaurantList(tempRestaurant);
    }
//    public void updateMenuOfRestaurant(UUID restaurantId,Menu updatedMenu){
//        Restaurant currRestaurant=restaurantRepository.getRestaurantBYId(restaurantId);
//        if (currRestaurant == null) {
//            throw new RuntimeException("Restaurant not found");
//        }
//        Menu currMenu=menuRepository.getMenuById(updatedMenu.getMenuId());
//        if (currMenu==null){
//            throw new RuntimeException("menu not found");
//        }
//        restaurantRepository.updateMenu(updatedMenu,currRestaurant,currMenu);
//
//
//    }
}
