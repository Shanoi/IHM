package fr.polytech.ihm.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Created by Thoma on 3/9/2017.
 */
public class UpperBandController {

    @FXML
    private Label homeLabel;

    @FXML
    public void initialize(){

    }

    @FXML
    void goHome() throws Exception {
        Stage stage = (Stage) homeLabel.getScene().getWindow();
        Loader loader = new Loader();
        loader.load(stage, "/fxml/Client/shopMain_listView.fxml");
    }

    @FXML
    void enSavoirPlus() throws Exception {
        Stage stage = (Stage) homeLabel.getScene().getWindow();
        Loader loader = new Loader();
        loader.load(stage, "/fxml/Client/savoirplus.fxml");
    }

}
