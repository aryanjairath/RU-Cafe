package projectfour;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class is the main method for tutition manager, which
 * sets up the GUI and runs it.
 * @author Anis Chihoub, Aryan Jairath
 */
public class DonutView extends Application {

    private static double LENGTH = 620;

    private static double WIDTH = 620;

    /**
     * This method runs the stage for the GUI
     *
     * @param stage a Stage object that has the necessary GUI components
     * @throws IOException an IO exception indicating something is missing.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                CoffeeView.class.getResource("DonutView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), LENGTH, WIDTH);
        stage.setTitle("Donut View");
        stage.setScene(scene);
        stage.show();
    }
}