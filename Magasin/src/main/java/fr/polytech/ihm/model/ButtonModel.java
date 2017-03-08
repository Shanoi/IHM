package fr.polytech.ihm.model;

import fr.polytech.ihm.controller.AppController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Kovox
 * @version 1.0
 * Represents the application's buttons model
 */
public class ButtonModel {

    public void homeView(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/shopMain.fxml"));
        Scene scene = new Scene(root);
        setPrimaryStageProperty(primaryStage, scene);
    }

    public void directionView(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/directions.fxml"));
        Scene scene = new Scene(root);
        setPrimaryStageProperty(primaryStage, scene);
    }

    public void setPrimaryStageProperty(Stage primaryStage, Scene scene) {
        new AppController(primaryStage, scene);
        primaryStage.setScene(scene);
        primaryStage.setFullScreenExitHint("");
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

}
