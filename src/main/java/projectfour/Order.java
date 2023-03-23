package projectfour;

import java.util.ArrayList;

public class Order {

    private int orderNumber;
    private ArrayList<String> menuItems;

    public Order(int orderNumber){
        this.orderNumber = orderNumber;
        menuItems = new ArrayList<String>();
    }

    public void addItem(String item){
        menuItems.add(item);
    }

    public void removeitem(String item){
        menuItems.remove(item);
    }

    public void printOrder(){
        for(int i = 0; i < menuItems.size(); i++){
            System.out.println(menuItems.get(i));
        }
    }

    public int getOrderNumber(){
        return this.orderNumber;
    }


}
