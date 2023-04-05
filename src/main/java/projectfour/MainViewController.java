package projectfour;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class is the controller for the main view where a user
 * can choose to order items, check their bag, and all store
 * orders
 * @author Aryan Jairath, Anis Chihoub
 */
public class MainViewController {

    /**
     * This method is executed when the order donuts button is pressed
     * @throws IOException an IO exception indicating something is missing
     */
    @FXML
    protected void onOrderDonut() throws IOException {
        DonutView view = new DonutView();
        view.start(new Stage());
    }

    /**
     * This method is executed when the order coffee button is pressed
     * @throws IOException an IO exception indicating something is missing
     */
    @FXML
    protected void onOrderCoffee() throws IOException {
        OrderingBasketView view2 = new OrderingBasketView();
        CoffeeView view = new CoffeeView();
        view.start(new Stage());
    }

    /**
     * This method is executed when the order basket button is pressed
     * @throws IOException an IO exception indicating something is missing
     */
    @FXML
    protected void onYourOrder() throws IOException {
        OrderingBasketView view = new OrderingBasketView();
        view.start(new Stage());
    }

    /**
     * This method is executed when the store orders button is pressed
     * @throws IOException an IO exception indicating something is missing
     */
    @FXML
    protected void onAllOrders() throws IOException {
        OrderMenuView view = new OrderMenuView();
        view.start(new Stage());
    }

}
