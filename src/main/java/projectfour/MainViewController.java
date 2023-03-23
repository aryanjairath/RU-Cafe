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
        CoffeeView view = new CoffeeView();
        view.start(new Stage());
    }
}
