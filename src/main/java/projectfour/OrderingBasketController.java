package projectfour;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.ArrayList;


/**
 * This class is the controller for the ordering basket and
 * manages all UI interactions for this view.
 * @author Aryan Jairath, Anis Chihoub
 */
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
    private static double ZEROTOTAL = 0;

    private static int SIZEINDEX = 1;
    private static int OFFSETINDEX = 1;

    private static int TWODIGITS = 2;
    private static int START = 0;


    private ObservableList<String> donuts;


    /**
     * This method displays the current order's pricing
     * in the ordering basket for viewing.
     */
    @FXML
    public void revealPricing(){
        ArrayList<Order> list = AllOrders.allOrderR();
        double amount = round(list.get(list.size() - SIZEINDEX).getPrice());
        subtotal.setText(amount + "");
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


    /**
     * This method rounds a decimal number to two digits
     * @param amount The value to round to two decimals
     * @return The rounded double value
     */
    private double round(double amount){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(TWODIGITS);
        df.setMinimumFractionDigits(TWODIGITS);
        amount = Double.parseDouble(df.format(amount));
        return amount;
    }

    /**
     * This method removes an item from the arraylist of
     * all orders and also reflects the corresponding
     * updated pricing
     */
    @FXML
    protected void onRemove(){
        String value = (String)items.getSelectionModel().getSelectedItem();
        if(value == null)
            return;
        ArrayList<Order> list = AllOrders.allOrderR();
        list.get(list.size() - SIZEINDEX).getMenuItems().remove(value);
        int quantity;
        double amt = 0;
        int quantity1 = Integer.parseInt(value.substring(value.indexOf('(')
                + OFFSETINDEX, value.indexOf(')')));
        if(value.contains("Strawberry") || value.contains("Vanilla")
                || value.contains("Blueberry") || value.contains("Apple")
                || value.contains("Grape") || value.contains("Passionfruit")){
            quantity = quantity1;
            Yeast yeast = new Yeast("Any");
            amt = Double.parseDouble(subtotal.getText()) - yeast.itemPrice() * quantity;
        }
        if(value.contains("French") || value.contains("Original")
                || value.contains("Powder")){
            quantity = quantity1;
            DonutHole hole = new DonutHole("Any");
            amt = Double.parseDouble(subtotal.getText()) - hole.itemPrice() * quantity;
        }
        if(value.contains("Birthday Cake") || value.contains("Chocolate Cake")
                || value.contains("Cheese Cake")){
            quantity = quantity1;
            Cake cake = new Cake("Any");
            amt = Double.parseDouble(subtotal.getText()) - cake.itemPrice() * quantity;
        }
        if(value.contains("Short") || value.contains("Tall") || value.contains("Grande") || value.contains("Venti")){
            String sizeOfCoffee = value.substring(START,value.indexOf("("));
            quantity = Integer.parseInt(value.substring(value.indexOf("(") + OFFSETINDEX,
                    value.indexOf(")")));
            int numberOfAddons = Integer.parseInt(
                    value.substring(value.indexOf(":") + OFFSETINDEX,value.indexOf(".")));
            Coffee tempCoffee = new Coffee(sizeOfCoffee);
            ArrayList<String> addons = new ArrayList<String>();
            for(int i = 0; i < numberOfAddons; i++){
                addons.add("");
            }
            tempCoffee.addaddIn(addons);
            amt = Double.parseDouble(subtotal.getText()) - tempCoffee.itemPrice() * quantity;
        }
        amt = round(amt);
        list.get(list.size() - SIZEINDEX).setPrice(amt);
        revealPricing();
    }

    /**
     * This method initializes the pricing for the Ordering
     * basket
     */
    public void initialize(){
        revealPricing();
    }

    /**
     * This method adds the current order to the
     * order arraylist and increments the order number
     */
    @FXML
    protected void onPlaceOrder(){
        Order order = new Order(AllOrders.getUniqueNumber());
        for(int i = 0; i < donuts.size(); i++){
            order.addItem(donuts.get(i));
        }
        AllOrders.addStoreOrder(order.getOrderNumber());
        AllOrders.allOrder = new ArrayList<>();
        DonutViewController.setTotal(ZEROTOTAL);
        CoffeeViewController.setTotal(ZEROTOTAL);
        AllOrders.incrementUnique();
        reset();
    }

    /**
     * This method resets all fields after the add to order
     * button is pressed
     */
    private void reset(){
        subtotal.setText("");
        tax.setText("");
        amountdue.setText("");
        donuts = FXCollections.observableArrayList();
        items.setItems(donuts);

    }
}
