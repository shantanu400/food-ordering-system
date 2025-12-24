package controller;

import entity.Menu;
import service.MenuService;

import java.util.UUID;

public class MenuController {


    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    public void IntializeMenu() {
        menuService.InitializeMenu(3);
    }

    public void updateMenu(UUID menuId,String name, int price, boolean isAvailble){
        menuService.updateMenu(menuId,name,price,isAvailble);
    }




}
