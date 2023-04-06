package projectfour;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class starts the Order Menu View and essentially
 * deals with all of the orders that the cafe obtains.
 * @author Anis Chihoub, Aryan Jairath
 *
 */
public class OrderMenuView extends Application {

    private static double LENGTH = 600;

    private static double WIDTH = 500;


    /**
     * This method runs the stage for the order GUI
     * @param stage a Stage object that has the necessary GUI components
     * @throws IOException an IO exception indicating something is missing.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                CoffeeView.class.getResource("StoreOrderView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), LENGTH,  WIDTH);
        stage.setTitle("All Orders");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method runs launch to start the order GUI.
     * @param args an array of String.
     */
    public static void main(String[] args) {
        launch();
    }
}
