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
    private static double TAXRATE = .0625;
    private static int SIZEINDEX = 1;
    private static int EMPTY = 1;
    private ObservableList<String> donuts;

    @FXML
    protected void revealPricing(){
        ArrayList<Order> list = AllOrders.allOrderR();
        subtotal.setText(list.get(list.size() - SIZEINDEX).getPrice() + "");
        double taxAmt = list.get(list.size() - SIZEINDEX).getPrice() * TAXRATE;
        taxAmt = round(taxAmt);
        tax.setText(taxAmt + "");
        double finalAmt = taxAmt + list.get(list.size() - SIZEINDEX).getPrice();
        finalAmt = round(finalAmt);
        amountdue.setText(finalAmt + "");
        ArrayList<Order> orders = AllOrders.allOrderR();
        ArrayList<String> order = orders.get(orders.size() - SIZEINDEX).getMenuItems();
        donuts = FXCollections.observableArrayList();
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
        list.get(list.size() - SIZEINDEX).getMenuItems().remove(value);
        int quantity;
        double amt=0;
        if(value.contains("Strawberry") || value.contains("Vanilla")
                || value.contains("Blueberry") || value.contains("Apple")
                || value.contains("Grape") || value.contains("Passionfruit")){
            quantity = Integer.parseInt(value.substring(value.length()-2,value.length() - SIZEINDEX));
            System.out.println(quantity);
            Yeast yeast = new Yeast("Any");
            amt = Double.parseDouble(subtotal.getText()) - yeast.itemPrice() * quantity;
            System.out.println(yeast.itemPrice() * quantity);
        }
        if(value.contains("French") || value.contains("Original")
                || value.contains("Powder")){
            quantity = Integer.parseInt(value.substring(value.length()-2,value.length() - SIZEINDEX));
            System.out.println(quantity);
            DonutHole hole = new DonutHole("Any");
            amt = Double.parseDouble(subtotal.getText()) - hole.itemPrice() * quantity;
            System.out.println(hole.itemPrice() * quantity);

        }
        if(value.contains("Birthday Cake") || value.contains("Chocolate Cake")
                || value.contains("Cheese Cake")){
            quantity = Integer.parseInt(value.substring(value.length()-2,value.length() - SIZEINDEX));
            System.out.println(quantity);
            Cake cake = new Cake("Any");
            amt = Double.parseDouble(subtotal.getText()) - cake.itemPrice() * quantity;
            System.out.println(cake.itemPrice() * quantity);

        }
        amt = round(amt);
        list.get(list.size() - SIZEINDEX).setPrice(amt);
        revealPricing();
    }

    @FXML
    protected void onPlaceOrder(){
        Order order = new Order(AllOrders.getUniqueNumber());
        for(int i = 0; i < donuts.size(); i++){
            order.addItem(donuts.get(i));
        }
        AllOrders.addStoreOrder(order.getOrderNumber());
        AllOrders.allOrder = new ArrayList<>();
        AllOrders.incrementUnique();
        DonutViewController.total = 0;
        reset();
    }

    private void reset(){
        subtotal.setText("");
        tax.setText("");
        amountdue.setText("");
        donuts = FXCollections.observableArrayList();
        items.setItems(donuts);

    }
}
