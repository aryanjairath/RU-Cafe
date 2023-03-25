package projectfour;

import java.util.ArrayList;

public class Order {

    private int orderNumber;
    private ArrayList<String> menuItems;
    private double price;

    public Order(int orderNumber){
        this.orderNumber = orderNumber;
        menuItems = new ArrayList<String>();
        price = 0;
    }

    public void addItem(String item){
        menuItems.add(item);
    }

    public void removeitem(String item){
        menuItems.remove(item);
    }

    public ArrayList<String> getMenuItems(){
        return menuItems;
    }

    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return this.price;
    }


    public int getOrderNumber(){
        return this.orderNumber;
    }


}
