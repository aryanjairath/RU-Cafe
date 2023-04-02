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

/**
 * This class is the controller for the donut view
 * and manages the responses to any GUI interactions
 * for the donut view stage.
 * @author Anis Chihoub, Aryan Jariath
 */
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
    private static double total;
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

    /**
     * Constructor for the donut view controller which sets the combo
     * boxes and a couple pre-defined images
     */
    public DonutViewController(){
        comboBox = new ComboBox();
        quantitycomboBox = new ComboBox();
        flavors = new ListView();
        total = 0;
        donuts = FXCollections.observableArrayList();
        order = new Order(uniqueOrder);
        donutImage = new ImageView();
        initialize();
    }

    /**
     * Performs tasks and sets pre-defined values as soon
     * as the view is opened.
     */
    @FXML
    protected void initialize(){
        comboBox.setValue("Yeast Donut");
        comboBox.setItems(donutList);
        quantitycomboBox.setValue(1);
        quantitycomboBox.setItems(quantityList);
        flavors.setItems(yeastFlavors);
    }

    /**
     * Finds the selected value and a corresponding image for it
     * @throws IOException Thrown in case there is no image found
     * for the given selected value
     */
    @FXML
    protected void selectedValue() throws IOException {
        if(comboBox.getValue().equals("Yeast Donut")){
            flavors.setItems(yeastFlavors);
            File f = new File("yeast.jpg");
            String absolute = f.getCanonicalPath();
            absolute = absolute.substring(0, absolute.length()-10);
            absolute += "\\src\\main\\resources\\projectfour\\yeast.jpg";
            donutImage.setImage(new Image(absolute));
        }
        if(comboBox.getValue().equals("Cake Donut")) {
            flavors.setItems(cakeFlavors);
            File f = new File("cake.jpg");
            String absolute = f.getCanonicalPath();
            absolute = absolute.substring(0, absolute.length()-9);
            absolute += "\\src\\main\\resources\\projectfour\\cake.jpg";
            donutImage.setImage(new Image(absolute));
        }
        if(comboBox.getValue().equals("Hole Donut")) {
            flavors.setItems(donutHoles);
            File f = new File("holes.jpg");
            String absolute = f.getCanonicalPath();
            absolute = absolute.substring(0, absolute.length()-10);
            absolute += "\\src\\main\\resources\\projectfour\\holes.jpg";
            donutImage.setImage(new Image(absolute));
        }

    }

    /**
     * Performs actions when the add donut button is pressed
     * to add donuts to temporary list view.
     */
    @FXML
    protected void addDonut(){
        String donutType = (String)comboBox.getSelectionModel().getSelectedItem();
        String flavor = (String)flavors.getSelectionModel().getSelectedItem();
        if(flavor == null){
            String errorMessage = "Must select a donut flavor!";
            Alert coffeeFailure = new Alert(Alert.AlertType.ERROR);
            coffeeFailure.setContentText(errorMessage);
            coffeeFailure.show();
            return;
        }
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


    /**
     * Actions performed when the remove button is pressed
     * in the GUI.
     */
    @FXML
    protected void onRemove(){
        String value = (String)result.getSelectionModel().getSelectedItem();
        if(value == null) {
            String errorMessage = "No Donut Selected!";
            Alert coffeeFailure = new Alert(Alert.AlertType.ERROR);
            coffeeFailure.setContentText(errorMessage);
            coffeeFailure.show();
            return;
        }
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


    /**
     * Rounds a given decimal to two decimal places
     * @return a rounded price.
     */
    private void round(){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        total = Double.parseDouble(df.format(total));
    }


    /**
     * This method sets a certain total for a donut order object
     * @param tot A double representing the total value for
     * a particular donut order
     */
    public static void setTotal(double tot){
        total = tot;
    }


    /**
     * This method gives access to total cost field of donut.
     * @return A double value representing the total donut view
     * cost.
     */
    public static double getTotal(){
        return total;
    }


    /**
     * This method performs actions when the add to order button
     * is pressed; checks if donut can be added at all.
     */
    @FXML
    protected void addOrder(){
        if(donuts.size() == 0){
            String errorMessage = "No donuts are selected!";
            Alert coffeeFailure = new Alert(Alert.AlertType.ERROR);
            coffeeFailure.setContentText(errorMessage);
            coffeeFailure.show();
            return;
        }
        for(int i = 0; i < donuts.size(); i++) {
            String type = donuts.get(i);
            order.addItem(type);
        }
        System.out.println(CoffeeViewController.total + total);
        order.setPrice(CoffeeViewController.total + total);
        AllOrders.addOrder(order,uniqueOrder);
        reset();
    }

    /**
     * This method resets all fields after the add to order
     * button is pressed
     */
    private void reset(){
        initialize();
        order = new Order(uniqueOrder);
        donuts = FXCollections.observableArrayList();
        result.setItems(donuts);
        quantitycomboBox.setValue(1);
        runningTotal.setText("");
    }
}
