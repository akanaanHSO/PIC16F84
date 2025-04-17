package Frontend.GUI.WindowBuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Window.fxml"));

        primaryStage.setTitle("PIC16F84 Simulator");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();

    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
