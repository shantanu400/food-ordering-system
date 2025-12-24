package entity;

import java.util.List;
import java.util.UUID;

public class Menu {
    private UUID menuId;
    private String name;
    private  int price;
    private boolean isAvailable;


    public Menu(String name,int price,boolean isAvailable){
        if(price<=0) throw new IllegalArgumentException("price is not positive");
        this.menuId=UUID.randomUUID();
        this.name=name;
        this.price=price;
        this.isAvailable=isAvailable;


    }

    public void updateMenu(String name, int price, boolean isAvailable) {
        if(price<=0) throw new IllegalArgumentException("price is not positive");
        this.name = name;
        this.price = price;
        this.isAvailable= isAvailable;
    }

    public UUID getMenuId() {
        return menuId;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
