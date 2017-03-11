package fr.polytech.ihm.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Thoma on 3/9/2017.
 */
public class UpperBandController {

    @FXML
    public void initialize(){
    }

    @FXML
    private ImageView homePicture;
    @FXML
    private Label homeLabel;

    @FXML
    void goHome(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            homeView((Stage) homePicture.getScene().getWindow());
        } else homeView((Stage) homeLabel.getScene().getWindow());
    }

    public void homeView(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/shopMain.fxml"));
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
