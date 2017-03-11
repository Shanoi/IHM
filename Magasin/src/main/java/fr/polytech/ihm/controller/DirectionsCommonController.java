package fr.polytech.ihm.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author Thomas
 * @version 1.0
 *          Represents the main lower band (directionsCommon) controller class.
 *          It allows to go on the directions page and handle directions button.
 */
public class DirectionsCommonController {

    @FXML
    private Button seDirigerBouton;

    @FXML
    public void initialize() {

    }

    @FXML
    void directionsPage() throws Exception {
        Stage stage = (Stage) seDirigerBouton.getScene().getWindow();
        Loader loader = new Loader();
        loader.load(stage, "/fxml/Client/directions.fxml");
    }

}
