package projectfour;

import java.util.ArrayList;

public class Order {

    private int orderNumber;
    private ArrayList<MenuItem> menuItems;

    public Order(int orderNumber){
        this.orderNumber = orderNumber;
        menuItems = new ArrayList<>();
    }

    public void addItem(MenuItem item){
        menuItems.add(item);
    }

    public void removeitem(MenuItem item){
        menuItems.remove(item);
    }

    public int getOrderNumber(){
        return this.orderNumber;
    }


}
