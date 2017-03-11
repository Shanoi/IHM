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
    private Label homeLabel;

    @FXML
    void goHome() throws IOException {
        homeView();
    }

    public void homeView() throws IOException {
        Stage stage = (Stage) homeLabel.getScene().getWindow();
        Loader loader = new Loader();
        loader.load(stage, "/fxml/shopMain.fxml");
    }
}
