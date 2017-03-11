package fr.polytech.ihm.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
    void directionsPage() throws Exception {
        Stage stage = (Stage) seDirigerBouton.getScene().getWindow();
        Loader loader = new Loader();
        loader.load(stage, "/fxml/directions.fxml");
    }

}
