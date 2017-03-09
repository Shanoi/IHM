package fr.polytech.ihm.controller;

import fr.polytech.ihm.model.ButtonModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Thoma on 3/9/2017.
 */
public class DirectionsCommonController {

    private ButtonModel buttonModel = new ButtonModel();

    @FXML
    public void initialize(){
    }

    @FXML
    private Button seDirigerBouton;

    @FXML
    void directionsPage() throws IOException {
        buttonModel.directionView((Stage) seDirigerBouton.getScene().getWindow());
    }
}
