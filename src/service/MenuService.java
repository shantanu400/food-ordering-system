package service;

import entity.Menu;
import repository.MenuRepository;

import java.util.UUID;

public class MenuService {


    private MenuRepository menuRepository;

    public MenuService( MenuRepository menuRepository) {

        this.menuRepository = menuRepository;
    }

    public  void InitializeMenu(int numberofMenu){
        for(int i=0;i<numberofMenu;i++){
            addMenu("pizza"+i,200+1);
        }

    }

    public void addMenu(String name,int price){
        menuRepository.addMenuToMenus(name,price);
    }

    public void updateMenu(UUID menuId,String name, int price, boolean isAvailble){
        Menu existingMenu=menuRepository.getMenuById(menuId);
        if(existingMenu==null) throw new RuntimeException("menu not found");

        existingMenu.updateMenu(name,price,isAvailble);
        menuRepository.save(existingMenu);
    }


}
