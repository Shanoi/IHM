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
        directionView();
    }

    public void directionView() throws IOException {
        Stage stage = (Stage) seDirigerBouton.getScene().getWindow();
        Loader loader = new Loader();
        loader.load(stage, "/fxml/directions.fxml");
    }
}
