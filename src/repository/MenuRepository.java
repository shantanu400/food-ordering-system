package repository;

import entity.Menu;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MenuRepository {
    Map<UUID, Menu> menus=new ConcurrentHashMap<>();
    public void addMenuToMenus(String name, int price){
        Menu tempMenu=new Menu(name,price,true);
        menus.put(tempMenu.getMenuId(),tempMenu);

    }

    public Map<UUID,Menu> GetMenus() {
        return menus;
    }

    public Menu getMenuById(UUID menuId){
        return menus.values().stream().filter(m->m.getMenuId().equals(menuId)).findFirst().orElse(null);
    }

    public void save(Menu menu){
menus.put(menu.getMenuId(),menu);
    }


    public String PrintMenus(){
        StringBuilder sb= new StringBuilder("This is menus:");
        menus.forEach((k,v)->sb.append(v.getName() +":" + v.getPrice() + " "));

        return sb.toString();
    }
}
