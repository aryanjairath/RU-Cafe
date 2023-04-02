package projectfour;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Order {

    private int orderNumber;
    private ArrayList<String> menuItems;
    private double price;

    private static double TAXAMOUNT = 1.06625;
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

    public double totalPrice(){
        return round(getPrice() * TAXAMOUNT);
    }
    public String toString(){
        return "Order number: " + getOrderNumber() + " "
                + this.getMenuItems().toString() + " Price: " + totalPrice();

    }

    /**
     * Rounds a decimal number to two digits.
     */

    private double round(double number){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        number = Double.parseDouble(df.format(number));
        return number;
    }

    public int getOrderNumber(){
        return this.orderNumber;
    }

    public void setOrderNumber(int orderNumber){
        this.orderNumber = orderNumber;
    }

}
