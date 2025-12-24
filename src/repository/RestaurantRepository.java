package repository;

import entity.Menu;
import entity.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RestaurantRepository {
    List<Restaurant> restaurantList=new ArrayList<>();

    public void AddRestaurantToRestaurantList(Restaurant restaurant){
        restaurantList.add(restaurant);
    }

public Restaurant getRestaurantBYId(UUID restaurantId){
        return restaurantList.stream().filter(r->r.getId().equals(restaurantId)).findFirst().orElse(null);
}

    public List<Restaurant> getAllRestaurants(){
        return restaurantList;
    }



    public String PrintRestaurantDetails(){
        StringBuilder sb=new StringBuilder();
        restaurantList.forEach(v ->{
                    sb.append(v.getName())
                            .append(", ")
                            .append(v.getRating())
                            .append(", ")
                            .append(v.getMaxOrders())
                            .append(", ");
                    v.getMenus().values().forEach(m->sb.append(m.getName())
                            .append(":")


                            .append(m.getPrice())
                            .append(",")

                    );
                    sb.append("\n");

                }



        );
        return sb.toString();
    }


}
