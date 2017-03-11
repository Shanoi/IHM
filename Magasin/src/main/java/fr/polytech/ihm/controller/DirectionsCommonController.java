package fr.polytech.ihm.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Thoma on 3/9/2017.
 */
public class DirectionsCommonController {

    @FXML
    public void initialize(){
    }

    @FXML
    private Button seDirigerBouton;

    @FXML
    void directionsPage() throws IOException {
        directionView((Stage) seDirigerBouton.getScene().getWindow());
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
