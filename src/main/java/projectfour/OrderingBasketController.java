package projectfour;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderingBasketController {

    @FXML
    private TextField subtotal;

    @FXML
    private TextField tax;

    @FXML
    private TextField amountdue;

    @FXML
    private ListView items;

    public OrderingBasketController(){
    }


    @FXML
    protected void revealPricing(){
        ArrayList<Order> list = AllOrders.allOrderR();
        System.out.println(list.get(0).getPrice());
        subtotal.setText(list.get(0).getPrice()+"");
        double taxAmt = list.get(list.size()-1).getPrice()*.0625;
        taxAmt = round(taxAmt);
        tax.setText(taxAmt+"");
        double finalAmt = taxAmt + list.get(list.size()-1).getPrice();
        finalAmt = round(finalAmt);
        amountdue.setText(finalAmt+"");
        ArrayList<Order> orders = AllOrders.allOrderR();
        ArrayList<String> order = orders.get(orders.size()-1).getMenuItems();
        ObservableList<String> donuts = FXCollections.observableArrayList();
        for(int i  = 0; i < order.size(); i++)
            donuts.add(order.get(i));
        items.setItems(donuts);
    }
    private double round(double amount){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        amount = Double.parseDouble(df.format(amount));
        return amount;
    }

    @FXML
    protected void onRemove(){
        String value = (String)items.getSelectionModel().getSelectedItem();
        if(value == null)
            return;
        ArrayList<Order> list = AllOrders.allOrderR();
        list.get(list.size()-1).getMenuItems().remove(value);
        int quantity;
        double amt=0;
        if(value.contains("Strawberry") || value.contains("Vanilla")
                || value.contains("Blueberry") || value.contains("Apple")
                || value.contains("Grape") || value.contains("Passionfruit")){
            quantity = Integer.parseInt(value.substring(value.length()-2,value.length()-1));
            Yeast yeast = new Yeast("Any");
            amt = Double.parseDouble(subtotal.getText()) - yeast.itemPrice() * quantity;
        }
        if(value.contains("French") || value.contains("Original")
                || value.contains("Powder")){
            quantity = Integer.parseInt(value.substring(value.length()-2,value.length()-1));
            DonutHole hole = new DonutHole("Any");
            amt = Double.parseDouble(subtotal.getText()) - hole.itemPrice() * quantity;
        }
        if(value.contains("Birthday Cake") || value.contains("Chocolate Cake")
                || value.contains("Cheese Cake")){
            quantity = Integer.parseInt(value.substring(value.length()-2,value.length()-1));
            Cake cake = new Cake("Any");
            amt = Double.parseDouble(subtotal.getText()) - cake.itemPrice() * quantity;
        }
        amt = round(amt);
        list.get(list.size()-1).setPrice(amt);
        revealPricing();
    }

}
