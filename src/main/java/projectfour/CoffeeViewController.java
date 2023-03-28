package projectfour;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CoffeeViewController {
        ObservableList<String> donutList =
                FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");
        ObservableList<Integer> quantityList =
                FXCollections.observableArrayList(1, 2, 3, 4, 5);


        ObservableList<String> addOnList =
                FXCollections.observableArrayList("Sweet Cream", "French Vanilla", "Irish Cream" +
                        "Caramel", "Mocha");
        ObservableList<String> coffee;

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
        private ImageView donutImage;

        @FXML
        private TextField runningTotal;

        @FXML
        private TextField orders;


        @FXML
        private CheckBox sweetCream;

        @FXML
        private CheckBox frenchVanilla;

        @FXML
        private CheckBox irishCream;


        @FXML
        private CheckBox caramelBox;

        @FXML
        private CheckBox mochaBox;
        public CoffeeViewController(){
                comboBox = new ComboBox();
                quantitycomboBox = new ComboBox();
                flavors = new ListView();
                total = 0;
                coffee = FXCollections.observableArrayList();
                order = new Order(uniqueOrder);
                initialize();
        }

        @FXML
        protected void initialize(){
                comboBox.setValue("Coffee Size");
                comboBox.setItems(donutList);

                quantitycomboBox.setValue(1);
                quantitycomboBox.setItems(quantityList);

                //flavors.setItems(yeastFlavors);

        }


        private ArrayList<String> getAddons(){
                ArrayList<String> addList = new ArrayList<>();
                if(sweetCream.isSelected()){
                        addList.add("Sweet Cream");
                }

                if(frenchVanilla.isSelected()){
                        addList.add("French Vanilla");

                }

                if(mochaBox.isSelected()){
                        addList.add("Mocha");
                }

                if(irishCream.isSelected()){
                        addList.add("Irish Cream");

                }

                if(caramelBox.isSelected()){
                        addList.add("Caramel");
                }

                return addList;
        }

        /**
         * Adds a coffee order, given parameters from the UI.
         */

        @FXML
        protected void addCoffee(){
                String size = (String)comboBox.getSelectionModel().getSelectedItem();
                Coffee coffeeOrder = new Coffee(size);
                ArrayList<String> addOns = getAddons();
                coffeeOrder.addaddIn(addOns);
                int quantity = (int)quantitycomboBox.getSelectionModel().getSelectedItem();
                orders.setText(coffeeOrder.toString(quantity));
                total += coffeeOrder.itemPrice()*quantity;

        }

        /**
         * Adds a coffee order, given parameters from the UI.
         */
        @FXML
        protected void removeCoffee(){
                String size = (String)comboBox.getSelectionModel().getSelectedItem();
                Coffee coffeeOrder = new Coffee(size);
                ArrayList<String> addOns = getAddons();
                coffeeOrder.addaddIn(addOns);
                int quantity = (int)quantitycomboBox.getSelectionModel().getSelectedItem();
                orders.setText(coffeeOrder.toString(quantity));
                total += coffeeOrder.itemPrice()*quantity;

        }


        private void round(){
                DecimalFormat df = new DecimalFormat();
                df.setMaximumFractionDigits(2);
                df.setMinimumFractionDigits(2);
                total = Double.parseDouble(df.format(total));
        }
}
