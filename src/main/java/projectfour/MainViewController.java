package projectfour;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    @FXML
    protected void onOrderDonut() throws IOException {
        DonutView view = new DonutView();
        view.start(new Stage());
    }

    @FXML
    protected void onOrderCoffee() throws IOException {
        CoffeeView view = new CoffeeView();
        view.start(new Stage());
    }


    @FXML
    protected void onYourOrder() throws IOException {
        OrderingBasketView view = new OrderingBasketView();
        view.start(new Stage());
    }


}
