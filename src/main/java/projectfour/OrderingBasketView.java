package projectfour;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is the main method for tutition manager, which
 * sets up the GUI and runs it.
 * @author Anis Chihoub, Aryan Jairath
 */
public class OrderingBasketView extends Application {

    /**
     * This method runs the stage for the GUI
     * @param stage a Stage object that has the necessary GUI components
     * @throws IOException an IO exception indicating something is missing.
     */

    @FXML
    private ListView resultView;

    private static int SIZEINDEX = 1;

    private ObservableList<String> orderList;

    private static int BEGININDEX = 0;

    private static int ENDINDEX = 1;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                CoffeeView.class.getResource("OrderingBasketView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600,  500);
        stage.setTitle("Ordering Basket");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * This method runs launch to start the GUI.
     * @param args an array of String.
     */
    public static void main(String[] args) {
        launch();
    }
}