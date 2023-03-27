package projectfour;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class DonutViewController {
    ObservableList<String> donutList =
            FXCollections.observableArrayList("Yeast Donut", "Cake Donut", "Hole Donut");
    ObservableList<Integer> quantityList =
            FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    ObservableList<String> yeastFlavors =
            FXCollections.observableArrayList("Strawberry", "Vanilla", "Blueberry",
                    "Apple", "Grape","Passionfruit");

    ObservableList<String> cakeFlavors =
            FXCollections.observableArrayList("Birthday Cake", "Chocolate Cake",
                    "Cheese Cake");

    ObservableList<String> donutHoles =
            FXCollections.observableArrayList("French", "Original",
                    "Powder");
    ObservableList<String> donuts;

    private double total;
    private int uniqueOrder = 0;

    private Order order;


    @FXML
    private ComboBox comboBox;

    @FXML
    private ComboBox quantitycomboBox;

    @FXML
    private ListView flavors;

    @FXML
    private ListView result;

    @FXML
    private Button add;

    @FXML
    private TextField runningTotal;
    public DonutViewController(){
        comboBox = new ComboBox();
        quantitycomboBox = new ComboBox();
        flavors = new ListView();
        total = 0;
        donuts = FXCollections.observableArrayList();
        initialize();
    }

    @FXML
    protected void initialize(){
        comboBox.setValue("Yeast Donut");
        comboBox.setItems(donutList);

        quantitycomboBox.setValue(1);
        quantitycomboBox.setItems(quantityList);

        flavors.setItems(yeastFlavors);

    }

    @FXML
    protected void selectedValue(){
        if(comboBox.getValue().equals("Yeast Donut")){
            flavors.setItems(yeastFlavors);
        }
        if(comboBox.getValue().equals("Cake Donut"))
            flavors.setItems(cakeFlavors);
        if(comboBox.getValue().equals("Hole Donut"))
            flavors.setItems(donutHoles);
    }

    @FXML
    protected void addDonut(){
        String donutType = (String)comboBox.getSelectionModel().getSelectedItem();
        String flavor = (String)flavors.getSelectionModel().getSelectedItem();
        int quantity = (int)quantitycomboBox.getSelectionModel().getSelectedItem();
        if(donutType.equals("Yeast Donut")){
            Yeast yeast = new Yeast(flavor);
            total += yeast.itemPrice()*quantity;
        }
        if(donutType.equals("Cake Donut")){
            Cake cake = new Cake(flavor);
            total += cake.itemPrice()*quantity;
        }
        if(donutType.equals("Hole Donut")){
            DonutHole hole = new DonutHole(flavor);
            total += hole.itemPrice()*quantity;
        }
        String output = "";
        if(flavor != null)
            output = (flavor+"("+quantity+")");
        else
            return;
        round();
        donuts.add(output);
        result.setItems(donuts);
        runningTotal.setText(total+"");
    }

    @FXML
    protected void onRemove(){
        String value = (String)result.getSelectionModel().getSelectedItem();
        donuts.remove(value);
        int quantity;
        if(value.contains("Strawberry") || value.contains("Vanilla")
                || value.contains("Blueberry") || value.contains("Apple")
                || value.contains("Grape") || value.contains("Passionfruit")){
            quantity = Integer.parseInt(value.substring(value.length()-2,value.length()-1));
            Yeast yeast = new Yeast("Any");
            total -= yeast.itemPrice() * quantity;
        }
        if(value.contains("French") || value.contains("Original")
                || value.contains("Powder")){
            quantity = Integer.parseInt(value.substring(value.length()-2,value.length()-1));
            DonutHole hole = new DonutHole("Any");
            total -= hole.itemPrice() * quantity;
        }
        if(value.contains("Birthday Cake") || value.contains("Chocolate Cake")
                || value.contains("Cheese Cake")){
            quantity = Integer.parseInt(value.substring(value.length()-2,value.length()-1));
            Cake cake = new Cake("Any");
            total -= cake.itemPrice() * quantity;
        }
        round();
        runningTotal.setText(total+"");


    }
    private void round(){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        total = Double.parseDouble(df.format(total));
    }

    private MenuItem findItem(String value){
        if(value.contains("Strawberry") || value.contains("Vanilla")
                || value.contains("Blueberry") || value.contains("Apple")
                || value.contains("Grape") || value.contains("Passionfruit")){
            Yeast yeast = new Yeast(value);
            return yeast;
        }
        if(value.contains("French") || value.contains("Original")
                || value.contains("Powder")){
            DonutHole hole = new DonutHole(value);
            return hole;
        }
        if(value.contains("Birthday Cake") || value.contains("Chocolate Cake")
                || value.contains("Cheese Cake")){
            Cake cake = new Cake(value);
            return cake;
        }
        return null;
    }
    @FXML
    protected void addOrder(){
        order = new Order(uniqueOrder);
        uniqueOrder++;
        if(donuts.size() == 0)
            return;
        for(int i = 0; i < donuts.size(); i++) {
            String type = donuts.get(i);
            order.addItem(type);
        }
        //order.printOrder();
        reset();

    }

    private void reset(){
        initialize();
        order = new Order(uniqueOrder);
        donuts = FXCollections.observableArrayList();
        result.setItems(donuts);
        quantitycomboBox.setValue(1);
        total = 0;
        runningTotal.setText("");

    }
    private boolean checkAdd(){

        return true;
    }
}
