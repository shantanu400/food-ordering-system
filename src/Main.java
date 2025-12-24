import controller.MenuController;
import controller.OrderController;
import controller.RestaurantController;
import entity.Menu;
import repository.MenuRepository;
import repository.OrderRepository;
import repository.RestaurantRepository;
import service.MenuService;
import service.OrderService;
import service.RestaurantService;
import strategy.HighestRatingStrategy;
import strategy.SelectionStrategy;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {

        /* ================== SETUP (WIRING) ================== */

        MenuRepository menuRepository = new MenuRepository();
        RestaurantRepository restaurantRepository = new RestaurantRepository();
        OrderRepository orderRepository = new OrderRepository();

        MenuService menuService = new MenuService(menuRepository);
        RestaurantService restaurantService =
                new RestaurantService(restaurantRepository, menuRepository);
        OrderService orderService =
                new OrderService(orderRepository, restaurantRepository);

        MenuController menuController =
                new MenuController(menuService);
        RestaurantController restaurantController =
                new RestaurantController(restaurantRepository, menuRepository, restaurantService);
        OrderController orderController =
                new OrderController(orderService);

        /* ================== INITIAL DATA ================== */

        menuController.IntializeMenu();
        restaurantController.InitializeRestaurant();

        System.out.println(menuRepository.PrintMenus());
        System.out.println("This is restaurant:\n");
        System.out.println(restaurantRepository.PrintRestaurantDetails());
        /* ================== UPDATE MENU ================== */

        Menu menuToUpdate =
                menuRepository.GetMenus().values().iterator().next();

        menuController.updateMenu(
                menuToUpdate.getMenuId(),
                "Cheese Pizza",
                350,
                true
        );

        /* ================== CREATE ORDER ITEMS ================== */

        Iterator<Menu> iterator =
                menuRepository.GetMenus().values().iterator();

        Menu menu1 = iterator.next();
        Menu menu2 = iterator.next();

        Map<Menu, Integer> orderItems = new ConcurrentHashMap<>();
        orderItems.put(menu1, 2);
        orderItems.put(menu2, 4);

        /* ================== PLACE ORDER ================== */

        SelectionStrategy strategy = new HighestRatingStrategy();

        orderController.createNewOrder(
                "Shruthi",
                orderItems,
                strategy
        );

        /* ================== OUTPUT ================== */
        System.out.println("This is restaurant post Updation:\n");
        System.out.println(restaurantRepository.PrintRestaurantDetails());
        orderController.printOrders();
    }
}
